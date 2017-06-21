(function(){
    angular.module('sportsgo').controller('AnuncioModalidadeController',AnuncioModalidadeController);

    function AnuncioModalidadeController($scope, usuarioService) {

        function init() {
            $scope.anuncios = usuarioService.get('anuncios');
            $scope.modalidade = usuarioService.get('modalidade');
            definirFotoCapa();
        }

        init();

        function definirFotoCapa() {
            var indice;
            for (indice in $scope.anuncios) {
                $scope.anuncios[indice].fotoCapa = $scope.anuncios[indice].arquivos[0].enderecoArquivo;
            }
        }


    }

})();