(function () {
    angular.module('sempreufg').factory('requisicoesService', requisicoesService);

    function requisicoesService($http, urlConfig, $q) {

        var _novoUsuario = function (pessoa) {
            return $http.post(urlConfig.baseUrl + '/usuario/novo', pessoa);
        };

        var _completarCadastroUsuario = function (usuario, config) {
            return $http.post(urlConfig.baseUrl + '/usuario/completar-cadastro', usuario, config);
        };

        var _autenticarUsuario = function (usuario) {
            return $http.post(urlConfig.baseUrl + '/usuario/autenticar', usuario);
        };

        var _buscarUsuarioID = function (id) {
            return $http.get(urlConfig.baseUrl + '/usuario/buscaUsuario/' + id);
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

        var _carregarTodosAnuncios = function () {
            return $http.get(urlConfig.baseUrl + '/anuncio/listar-anuncios');
        };

        var _carregarAnunciosPublicados = function () {
            return $http.get(urlConfig.baseUrl + '/anuncio/listar-anuncios-publicados');
        };

        var _carregarAnunciosEmAnalise = function () {
            return $http.get(urlConfig.baseUrl + '/anuncio/listar-anuncios-em-analise');
        };

        var _carregarAnunciosBloqueados = function () {
            return $http.get(urlConfig.baseUrl + '/anuncio/listar-anuncios-bloqueados');
        };

        var _carregarAnunciosPorModalidade = function (modalidade) {
            return $http.get(urlConfig.baseUrl + '/anuncio/listar-anuncios-por-modalidade/' + modalidade);
        };

        var _publicarAnuncio = function (anuncio) {
            return $http.post(urlConfig.baseUrl + '/anuncio/publicar', anuncio);
        };

        var _bloquearAnuncio = function (anuncio) {
            return $http.post(urlConfig.baseUrl + '/anuncio/bloquear', anuncio);
        };

        var _desbloquearAnuncio = function (anuncio) {
            return $http.post(urlConfig.baseUrl + '/anuncio/desbloquear', anuncio);
        };

        var _carregarAnunciosPublicadosPorUsuario = function (id) {
            return $http.get(urlConfig.baseUrl + '/anuncio/listar-anuncios-publicados-por-usuario/' + id);
        };

        var _carregarAnunciosEmAnalisePorUsuario = function (id) {
            return $http.get(urlConfig.baseUrl + '/anuncio/listar-anuncios-pendentes-por-usuario/' + id);
        };

        var _deletarAnuncio = function (anuncio) {
            return $http.post(urlConfig.baseUrl + '/anuncio/deletar', anuncio);
        };

        var _inserirComentarioAnuncio = function (anuncio) {
            return $http.post(urlConfig.baseUrl + '/anuncio/inserir-comentario', anuncio);
        };

        var _buscarComentariosAnuncio = function (id) {
            return $http.get(urlConfig.baseUrl + '/anuncio/buscar-comentarios-anuncio/' + id);
        };



        return {
            novoUsuario: _novoUsuario,
            completarCadastroUsuario: _completarCadastroUsuario,
            autenticarUsuario: _autenticarUsuario,
            enviarEmailUsuario: _enviarEmailUsuario,
            validarCadastroUsuario: _validarCadastroUsuario,
            cadastrarAnuncio: _cadastrarAnuncio,
            carregarAnunciosPublicados: _carregarAnunciosPublicados,
            carregarAnunciosEmAnalise: _carregarAnunciosEmAnalise,
            carregarAnunciosBloqueados: _carregarAnunciosBloqueados,
            carregarTodosAnuncios: _carregarTodosAnuncios,
            carregarAnunciosPorModalidade: _carregarAnunciosPorModalidade,
            buscarUsuarioID: _buscarUsuarioID,
            publicarAnuncio: _publicarAnuncio,
            bloquearAnuncio: _bloquearAnuncio,
            desbloquearAnuncio: _desbloquearAnuncio,
            carregarAnunciosPublicadosPorUsuario: _carregarAnunciosPublicadosPorUsuario,
            carregarAnunciosEmAnalisePorUsuario: _carregarAnunciosEmAnalisePorUsuario,
            deletarAnuncio: _deletarAnuncio,
            inserirComentarioAnuncio: _inserirComentarioAnuncio,
            buscarComentariosAnuncio: _buscarComentariosAnuncio
        };

    }

})();