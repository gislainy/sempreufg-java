(function () {

    angular.module('sempreufg').controller('AnuncioBloqueadoController', AnuncioBloqueadoController);

    function AnuncioBloqueadoController($scope, growl,routeService, usuarioService, requisicoesService) {

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
            routeService.mudarRota('/sempreufg/anuncio/detalhe');
        };

         $scope.desbloquearAnuncio = function (anuncio, index) {
            anuncio.status = 'EM_ANALISE';
            anuncio.usuario = {
                "idUsuario": anuncio.usuario
            };
            delete anuncio.fotoCapa;
            delete anuncio.arquivos;
            var bloquear = confirm('Deseja desbloquear o anúncio?');
            if (bloquear) {
                requisicoesService.desbloquearAnuncio(anuncio)
                    .then(function (response) {
                        if (response.data.retorno) {
                            growl.success('Anúncio desbloqueado com sucesso');
                            $scope.anuncios.splice(index, 1);
                            verificarArrayAnuncios();
                        } else {
                            growl.error('Falha ao tentar desbloquear anúncio');
                        }
                    }, function (error) {
                        console.log(error);
                    });
            }

        };

        function verificarArrayAnuncios() {
            if($scope.anuncios.length === 0) {
                routeService.mudarRota('/sempreufg');
            }
        }

    }

})();