(function () {
    angular.module('sportsgo').factory('requisicoesService', requisicoesService);

    function requisicoesService($http, urlConfig, $q) {

        var _novoUsuario = function (pessoa) {
            return $http.post(urlConfig.baseUrl + '/usuario/novo', pessoa);
        };

        var _completarCadastroUsuario = function (usuario) {
            return $http.post(urlConfig.baseUrl + '/usuario/completar-cadastro', usuario);
        };

        var _autenticarUsuario = function (usuario) {
            return $http.post(urlConfig.baseUrl + '/usuario/autenticar', usuario);
        };

        var _buscarUsuarioID = function (id) {
            return $http.get(urlConfig.baseUrl + '/usuario/buscaUsuario/'+id);
        };

        var _enviarEmailUsuario = function (usuario) {
            return $http.post(urlConfig.baseUrl + '/usuario/enviar-email', usuario);
        };

        var _validarCadastroUsuario = function (usuario) {
            return $http.post(urlConfig.baseUrl + '/usuario/validar-cadastro', usuario);
        };

        var _cadastrarAnuncio = function (anuncio, config) {
            return $http.post(urlConfig.baseUrl + '/anuncio/novo', anuncio, config);
        };

         var _carregarAnuncios = function () {
            return $http.get(urlConfig.baseUrl + '/anuncio/listar-anuncios');
        };

        var _carregarAnunciosPorModalidade = function (modalidade) {
            return $http.get(urlConfig.baseUrl + '/anuncio/listar-anuncios-por-modalidade/'+modalidade);
        };

        return {
            novoUsuario: _novoUsuario,
            completarCadastroUsuario: _completarCadastroUsuario,
            autenticarUsuario: _autenticarUsuario,
            enviarEmailUsuario: _enviarEmailUsuario,
            validarCadastroUsuario: _validarCadastroUsuario,
            cadastrarAnuncio: _cadastrarAnuncio,
            carregarAnuncios: _carregarAnuncios,
            carregarAnunciosPorModalidade: _carregarAnunciosPorModalidade,
            buscarUsuarioID: _buscarUsuarioID
        };

    }

})();