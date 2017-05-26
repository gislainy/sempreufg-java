(function () {
    angular.module('sportsgo').factory('requisicoesService', requisicoesService);

    function requisicoesService($http, urlConfig, $q) {

        var _novoUsuario = function (pessoa) {
            return $http.post(urlConfig.baseUrl + '/usuario/novo', pessoa);
        };

        return {
            novoUsuario: _novoUsuario
        };

    }

})();