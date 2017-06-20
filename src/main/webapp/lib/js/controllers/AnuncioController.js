(function () {
    angular.module('sportsgo').controller('AnuncioController', AnuncioController);

    function AnuncioController($scope, requisicoesService, usuarioService, fileUploadService) {

        $scope.modalidadesEsportivas = [
            "Futebol",
            "Natação",
            "Atletismo",
            "Tênis",
            "Basquetebol",
            "Voleibol",
            "Skate",
            "Airsoft"
        ];

        /*$scope.cadastrarAnuncio = function () {
            configurarObjetoParaRequisicao();
            requisicoesService.cadastrarAnuncio($scope.anuncio)
                .then(function (response) {
                    console.log(response.data);
                }, function (error) {
                    console.log('Falha na requisição :' + error);
                });
        }; */

        $scope.cadastrarAnuncio = function () {
            configurarObjetoParaRequisicao();
            var file = $scope.myFile;
            var uploadUrl = "http://localhost:9090/services/anuncio/novo", //Url of webservice/api/server
                promise = fileUploadService.uploadFileToUrl($scope.anuncio, file, uploadUrl);

            promise.then(function (response) {
                $scope.serverResponse = response;
            }, function () {
                $scope.serverResponse = 'An error has occurred';
            });
        }

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
                var modalidade = $scope.anuncio.modalidade.toString();
                $scope.anuncio.modalidade = modalidade;
            }


            function formatarPreco() {
                var preco = $scope.anuncio.precoEvento.replace(',','').replace('R','').replace('$','');
                $scope.anuncio.precoEvento = parseFloat(preco);
            } 

            function getDataInclusao() {
                var date = new Date();
                return (date.getMonth() + 1) + '/' + date.getDate() + '/' +  date.getFullYear();
            }

            function formatarDatas() {
                $scope.anuncio.dataTermino = parseInt($scope.anuncio.dataTermino.replace('/','').replace('/',''));
                $scope.anuncio.datas.dataEvento = parseInt($scope.anuncio.datas.dataEvento.replace('/','').replace('/',''));
                $scope.anuncio.dataInclusao = parseInt($scope.anuncio.dataInclusao.replace('/','').replace('/',''));
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