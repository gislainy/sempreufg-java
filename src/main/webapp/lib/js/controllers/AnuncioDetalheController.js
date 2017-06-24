(function(){
    angular.module('sportsgo').controller('AnuncioDetalheController', AnuncioDetalheController);

    function AnuncioDetalheController($scope, usuarioService) {

        function init() {
            $scope.anuncio = usuarioService.get('anuncioEscolhido');
        }

        init();

    }
})();