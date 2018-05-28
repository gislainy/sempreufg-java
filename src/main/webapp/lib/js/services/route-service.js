(function(){
    angular.module('sempreufg').service('routeService', routeService);

    function routeService($timeout, $location) {
        this.mudarRota = function(caminho) {
            return $location.path(caminho);
        };

        this.mudarRotaTimeout = function(caminho) {
            $timeout(function(){
                return $location.path(caminho);
            },5000);
        };

      
    }

})();

