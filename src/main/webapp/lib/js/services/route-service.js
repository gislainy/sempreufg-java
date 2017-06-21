(function(){
    angular.module('sportsgo').service('routeService', routeService);

    function routeService($timeout, $location) {
        this.mudarRota = function(caminho) {
            
        };

        this.mudarRotaTimeout = function(caminho) {
            $timeout(function(){
                return $location.path(caminho);
            },5000);
        };

      
    }

})();

