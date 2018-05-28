(function () {
    angular.module('sempreufg').factory('usuarioService', usuarioService);

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