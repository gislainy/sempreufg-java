(function () {
    angular.module('sportsgo').controller('AnuncioDetalheController', AnuncioDetalheController);

    function AnuncioDetalheController($scope, usuarioService, requisicoesService) {

        function init() {
            $scope.anuncio = usuarioService.get('anuncioEscolhido');
            $scope.comentarios = $scope.anuncio.comentarios;
            $scope.coment = {};
            $scope.anuncio.usuario = {
                "idUsuario": $scope.anuncio.usuario
            }
            carregarAutor();
        }

        init();

        function carregarAutor() {
            requisicoesService.buscarUsuarioID($scope.anuncio.usuario)
                .then(function (response) {
                    if (response.data !== null && response.data !== '') {
                        $scope.autor = response.data.nome + ' ' + response.data.sobrenome;
                        delete response.data;
                    } else {
                        growl.error('Falha ao buscar autor do anúncio');
                    }
                }, function (error) {
                    console.log(error);
                });
        }

        $scope.inserirComentario = function () {
            configurarObjetoRequisicao();
            requisicoesService.inserirComentarioAnuncio($scope.anuncio)
                .then(function (response) {
                    if (response.data.retorno) {
                        $scope.comentarios.push($scope.coment);
                        $scope.textoComentario = null;
                    } else {
                        growl.error('Falha ao comentar anúncio');
                    }
                }, function (error) {
                    console.log(error);
                });
        }

        function configurarObjetoRequisicao() {
            var index;
            for (index in $scope.anuncio.arquivos) {
                $scope.anuncio.arquivos[index].codAnuncio = $scope.anuncio.arquivos[index].anuncio;
                delete $scope.anuncio.arquivos[index].anuncio;
            }
            for (index in $scope.anuncio.comentarios) {
                $scope.anuncio.comentarios[index].codAnuncio = $scope.anuncio.comentarios[index].anuncio;
                delete $scope.anuncio.comentarios[index].anuncio;
            }
            for (index in $scope.anuncio.datas) {
                $scope.anuncio.datas[index].codAnuncio = $scope.anuncio.datas[index].anuncio;
                delete $scope.anuncio.datas[index].anuncio;
            }
            for (index in $scope.anuncio.locais) {
                $scope.anuncio.locais[index].codAnuncio = $scope.anuncio.locais[index].anuncio;
                delete $scope.anuncio.locais[index].anuncio;
            }
            $scope.coment.autor = $scope.autor;
            $scope.coment.texto = $scope.textoComentario;
            $scope.coment.idUsuario = $scope.anuncio.usuario;
            $scope.anuncio.comentarios = [{}];
            $scope.anuncio.comentarios.push($scope.coment);
        }

    }
})();