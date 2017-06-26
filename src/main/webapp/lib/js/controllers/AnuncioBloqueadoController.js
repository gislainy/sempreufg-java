(function () {

    angular.module('sportsgo').controller('AnuncioBloqueadoController', AnuncioBloqueadoController);

    function AnuncioBloqueadoController($scope, growl, usuarioService, requisicoesService) {

        function init() {
            $scope.anuncios = usuarioService.get('anuncios');
            $scope.tipoAnuncio = 'bloqueados';
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

         $scope.desbloquearAnuncio = function (anuncio, index) {
            anuncio.status = 'EM_ANALISE';
            anuncio.usuario = {
                "idUsuario": anuncio.usuario
            }
            delete anuncio.fotoCapa;
            delete anuncio.arquivos;
            var bloquear = confirm('Deseja desbloquear o anúncio?');
            if (bloquear) {
                requisicoesService.desbloquearAnuncio(anuncio)
                    .then(function (response) {
                        if (response.data.retorno) {
                            growl.success('Anúncio desbloqueado com sucesso');
                            $scope.anuncios.splice(index, 1);
                        } else {
                            growl.error('Falha ao tentar desbloquear anúncio');
                        }
                    }, function (error) {
                        console.log(error);
                    });
            }

        };


    };

})();