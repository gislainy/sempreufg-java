(function () {
    angular.module('sportsgo').factory('usuarioService', usuarioService);

    function usuarioService() {

        var usuario = {};

        return {
            set: function (key, value) {
                usuario[key] = value;
            },
            get: function (key) {
                return usuario[key];
            }
        }

    }
})();