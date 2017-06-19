(function () {
    angular.module('sportsgo').factory('requisicoesService', requisicoesService);

    function requisicoesService($http, urlConfig, $q) {

        var _novoUsuario = function (pessoa) {
            return $http.post(urlConfig.baseUrl + '/usuario/novo', pessoa);
        };

        var _autenticarUsuario = function (usuario) {
            return $http.post(urlConfig.baseUrl + '/usuario/autenticar', usuario);
        };

        var _enviarEmailUsuario = function (usuario) {
            return $http.post(urlConfig.baseUrl + '/usuario/enviar-email', usuario);
        };

        var _validarCadastroUsuario = function (usuario) {
            return $http.post(urlConfig.baseUrl + '/usuario/validar-cadastro', usuario);
        };

        var _cadastrarAnuncio = function (anuncio) {
            return $http.post(urlConfig.baseUrl + '/anuncio/novo', anuncio);
        };

        return {
            novoUsuario: _novoUsuario,
            autenticarUsuario: _autenticarUsuario,
            enviarEmailUsuario: _enviarEmailUsuario,
            validarCadastroUsuario: _validarCadastroUsuario,
            cadastrarAnuncio: _cadastrarAnuncio
        };

    }

})();