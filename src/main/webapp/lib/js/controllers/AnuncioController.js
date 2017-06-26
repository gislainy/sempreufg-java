(function() {
    angular.module('sportsgo').controller('AnuncioController', AnuncioController);

    function AnuncioController($scope, requisicoesService, usuarioService, fileUploadService, growl) {
        
        $scope.modalidadesEsportivas = [
            "Futebol", "Natação", "Atletismo", "Tênis", "Basquetebol", "Voleibol", "Skate", "Airsoft"
        ];

        $scope.cadastrarAnuncio = function() {
            configurarObjetoParaRequisicao();
            var config = {
                transformRequest: angular.identity,
                headers: {
                    'Content-Type': undefined
                }
            };
            var formData = fileUploadService.uploadFileToUrl($scope.anuncio, $scope.myFile);
            requisicoesService.cadastrarAnuncio(formData, config)
                .then(function(response) {
                    if (response.data.retorno === true) {
                        growl.success('Anúncio enviado para análise com sucesso');
                        $scope.anuncio = null;
                        $scope.myFile = null;
                    } else {
                        growl.error('Falha ao cadastrar o anúncio');
                    }
                }, function(error) {
                    console.log('Falha na requisição: ' + error);
                });
        };

        function configurarObjetoParaRequisicao() {
            formatarModalidade();
            $scope.anuncio.dataInclusao = getDataInclusao();
            formatarDatas();
            formatarPreco();
            $scope.anuncio.usuario = {};
            $scope.anuncio.usuario.idUsuario = usuarioService.get('id');
            inserirItensArray($scope.anuncio);
            $scope.anuncio.pendencias = [];
            $scope.anuncio.alteracoes = [];
            $scope.anuncio.dadosPremium = [];
            $scope.anuncio.arquivos = [];
        }

        function formatarModalidade() {
            var modalidade = $scope.anuncio.modalidade[0].toString().toLowerCase();
            if (modalidade === 'tênis') {
                modalidade = 'tenis';
            } else if (modalidade === 'natação') {
                modalidade = 'natacao';
            }
            $scope.anuncio.modalidade = modalidade;
        }


        function formatarPreco() {
            var preco = $scope.anuncio.precoEvento.replace(',', '.').replace('R', '').replace('$', '');
            $scope.anuncio.precoEvento = parseFloat(preco);
        }

        function getDataInclusao() {
            var date = new Date();
            return (date.getMonth() + 1) + '/' + date.getDate() + '/' + date.getFullYear();
        }

        function getDataFormatada(dataEvento) {
            var dataFormatada = dataEvento.split('/');
            var dia = parseInt(dataFormatada[0]) + 1;
            dataFormatada[0] = dia.toString();
            return dataFormatada[2] + '-' + dataFormatada[1] + '-' + dataFormatada[0];
        }

        function formatarDatas() {
            $scope.anuncio.dataTermino = new Date(getDataFormatada($scope.anuncio.dataTermino));
            $scope.anuncio.datas.dataEvento = new Date(getDataFormatada($scope.anuncio.datas.dataEvento));
            $scope.anuncio.dataInclusao = new Date($scope.anuncio.dataInclusao);
        }

        function validarDatasInseridas(dataInicio,dataTermino) {
            var dtinicio = dataInicio.split('-');
            var dtfim = dataTermino.split('-');
            //var dtatual = new Date();
            
        }

        function inserirItensArray(anuncio) {
            var arrayLocais = [];
            var arrayDatas = [];
            arrayLocais.push(anuncio.locais);
            arrayDatas.push(anuncio.datas);
            $scope.anuncio.locais = arrayLocais;
            $scope.anuncio.datas = arrayDatas;
        }


    }
})();