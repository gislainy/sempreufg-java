(function(){
    angular.module('sportsgo').controller('AnunciosUsuarioController',AnunciosUsuarioController);

    function AnunciosUsuarioController($scope, growl, usuarioService, requisicoesService) {

        function init() {
            $scope.anuncios = usuarioService.get('anuncios');
            $scope.tipoAnuncio = usuarioService.get('tipoAnuncio');
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



    }


})();