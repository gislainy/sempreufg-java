(function () {
    angular.module('sportsgo').factory('requisicoesService', requisicoesService);

    function requisicoesService($http, urlConfig, $q) {

        var _novoUsuario = function (usuario) {
            return $http.post(urlConfig.baseUrl + '/usuario/novo', usuario);
        };

        return {
            novoUsuario: _novoUsuario
        };

    }

})();