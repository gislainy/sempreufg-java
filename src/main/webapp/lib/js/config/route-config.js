angular.module('sempreufg')
    .config(configurar)
    .config(interceptor);

function configurar($routeProvider) {
    $routeProvider
        .when('/sempreufg/login', {
            templateUrl: 'lib/views/login.html',
            controller: 'LoginController'
        })
        .when('/sempreufg', {
            templateUrl: 'lib/views/index.html',
            controller: 'IndexController'
        })
        .when('/sempreufg/usuario/novo', {
            templateUrl: 'lib/views/usuario/pre-cadastro.html',
            controller: 'UsuarioController'
        })
        .when('/sempreufg/usuario/cadastro', {
            templateUrl: 'lib/views/usuario/cadastro.html',
            controller: 'UsuarioCadastroController'
        })

        .when('/sempreufg/anuncio/novo', {
            templateUrl: 'lib/views/anuncios/cadastro.html',
            controller: 'AnuncioController'
        })
        .when('/sempreufg/anuncio/detalhe', {
            templateUrl: 'lib/views/anuncios/detalhes-anuncio.html',
            controller: 'AnuncioDetalheController'
        })
        .when('/sempreufg/anuncio/futebol', {
            templateUrl: 'lib/views/anuncios/anuncios-por-modalidade.html',
            controller: 'AnuncioModalidadeController'
        })
        .when('/sempreufg/anuncio/atletismo', {
            templateUrl: 'lib/views/anuncios/anuncios-por-modalidade.html',
            controller: 'AnuncioModalidadeController'
        })
        .when('/sempreufg/anuncio/voleibol', {
            templateUrl: 'lib/views/anuncios/anuncios-por-modalidade.html',
            controller: 'AnuncioModalidadeController'
        })
        .when('/sempreufg/anuncio/basquetebol', {
            templateUrl: 'lib/views/anuncios/anuncios-por-modalidade.html',
            controller: 'AnuncioModalidadeController'
        })
        .when('/sempreufg/anuncio/tenis', {
            templateUrl: 'lib/views/anuncios/anuncios-por-modalidade.html',
            controller: 'AnuncioModalidadeController'
        })
        .when('/sempreufg/anuncio/natacao', {
            templateUrl: 'lib/views/anuncios/anuncios-por-modalidade.html',
            controller: 'AnuncioModalidadeController'
        })
        .when('/sempreufg/anuncio/airsoft', {
            templateUrl: 'lib/views/anuncios/anuncios-por-modalidade.html',
            controller: 'AnuncioModalidadeController'
        })
        .when('/sempreufg/anuncio/skate', {
            templateUrl: 'lib/views/anuncios/anuncios-por-modalidade.html',
            controller: 'AnuncioModalidadeController'
        })
        .when('/sempreufg/anuncio/todos', {
            templateUrl: 'lib/views/anuncios/anuncios-todos.html',
            controller: 'AnuncioTodosController'
        })
        .when('/sempreufg/anuncios/pendentes', {
            templateUrl: 'lib/views/anuncios/anuncios-em-analise.html',
            controller: 'AnuncioPendenteController'
        })
        .when('/sempreufg/anuncios/pendentes-usuario', {
            templateUrl: 'lib/views/anuncios/anuncios-pendentes-usuario.html',
            controller: 'AnunciosUsuarioController'
        })
        .when('/sempreufg/anuncios/publicados-usuario', {
            templateUrl: 'lib/views/anuncios/anuncios-publicados-usuario.html',
            controller: 'AnunciosUsuarioController'
        })
        .when('/sempreufg/anuncios/bloqueados', {
            templateUrl: 'lib/views/anuncios/anuncios-bloqueados.html',
            controller: 'AnuncioBloqueadoController'
        })
         .when('/sempreufg/anuncio/editar', {
            templateUrl: 'lib/views/anuncios/editar-anuncio.html',
            controller: 'AnuncioEditarController'
        })
        ;

    $routeProvider.otherwise({ redirectTo: '/sempreufg' });
}

function interceptor($httpProvider) {
    $httpProvider.interceptors.push('authInterceptor');
}
