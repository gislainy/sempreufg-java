(function(){
    angular.module('sportsgo').controller('IndexController', IndexController);

    function IndexController($scope, usuarioService, growl) {
        
         $scope.$on('usuarioLogado', function(event, args) {
            growl.success('Bem vindo '+args.usuario+'!');
            usuarioService.set('logado', args.logado);
            usuarioService.set('usuarioLogado', args.usuario);
            usuarioService.set('id', args.id);
            $scope.logado = args.logado;
            if(args !== undefined && args !== null && args.logado) {
                 $scope.usuario = args.usuario;
            }
        });

    }
})();