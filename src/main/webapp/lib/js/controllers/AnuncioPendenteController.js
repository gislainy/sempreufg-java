(function () {

    angular.module('sportsgo').controller('AnuncioPendenteController', AnuncioPendenteController);

    function AnuncioPendenteController($scope, growl, usuarioService, routeService, requisicoesService) {

        function init() {
            $scope.anuncios = usuarioService.get('anuncios');
            $scope.tipoAnuncio = 'em análise';
            definirFotoCapa();
        }

        init();

        function definirFotoCapa() {
            var indice;
            for (indice in $scope.anuncios) {
                $scope.anuncios[indice].fotoCapa = $scope.anuncios[indice].arquivos[0].enderecoArquivo;
            }
        }

        $scope.carregarDetalhesAnuncio = function (anuncio) {
            usuarioService.set('anuncioEscolhido', anuncio);
            routeService.mudarRota('/sportsgo/anuncio/detalhe');
        };

        $scope.publicarAnuncio = function (anuncio, index) {
            anuncio.status = 'PUBLICADO';
            anuncio.usuario = {
                "idUsuario": anuncio.usuario
            }
            delete anuncio.fotoCapa;
            delete anuncio.arquivos;
            var publicar = confirm('Deseja publicar o anúncio?');
            if (publicar) {
                requisicoesService.publicarAnuncio(anuncio)
                    .then(function (response) {
                        if (response.data.retorno) {
                            growl.success('Anúncio publicado com sucesso');
                            $scope.anuncios.splice(index, 1);
                        } else {
                            growl.error('Falha ao tentar bloquear anúncio');
                        }
                    }, function (error) {
                        console.log(error);
                    });
            }
        };

        $scope.bloquearAnuncio = function (anuncio, index) {
            anuncio.status = 'BLOQUEADO';
            anuncio.usuario = {
                "idUsuario": anuncio.usuario
            }
            delete anuncio.fotoCapa;
            delete anuncio.arquivos;
            var bloquear = confirm('Deseja bloquear o anúncio?');
            if (bloquear) {
                requisicoesService.bloquearAnuncio(anuncio)
                    .then(function (response) {
                        if (response.data.retorno) {
                            growl.success('Anúncio bloqueado com sucesso');
                            $scope.anuncios.splice(index, 1);
                        } else {
                            growl.error('Falha ao tentar bloquear anúncio');
                        }
                    }, function (error) {
                        console.log(error);
                    });
            }

        };

    }

})();