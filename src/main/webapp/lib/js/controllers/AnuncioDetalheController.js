(function () {
    angular.module('sportsgo').controller('AnuncioDetalheController', AnuncioDetalheController);

    function AnuncioDetalheController($scope, usuarioService, requisicoesService) {

        function init() {
            $scope.anuncio = usuarioService.get('anuncioEscolhido');
            carregarAutor();
        }

        init();

        function carregarAutor() {
            requisicoesService.buscarUsuarioID($scope.anuncio.usuario)
            .then(function(response){
                if(response.data !== null && response.data !== '') {
                    $scope.autor = response.data.nome + ' ' + response.data.sobrenome;
                    delete response.data;
                } else {
                    growl.error('Falha ao buscar autor do anúncio');
                }
            },function(error){
                console.log(error);
            });
        }

    }
})();