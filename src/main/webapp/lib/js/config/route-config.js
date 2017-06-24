angular.module('sportsgo')
    .config(configurar)
    .config(interceptor);

function configurar($routeProvider) {
    $routeProvider
        .when('/sportsgo/login', {
            templateUrl: 'lib/views/login.html',
            controller: 'LoginController'
        })
        .when('/sportsgo', {
            templateUrl: 'lib/views/principal.html',
            controller: 'IndexController'
        })
        .when('/sportsgo/usuario/novo', {
            templateUrl: 'lib/views/usuario/pre-cadastro.html',
            controller: 'UsuarioController'
        })
        .when('/sportsgo/usuario/cadastro', {
            templateUrl: 'lib/views/usuario/cadastro.html',
            controller: 'UsuarioCadastroController'
        })

        .when('/sportsgo/anuncio/novo', {
            templateUrl: 'lib/views/anuncios/cadastro.html',
            controller: 'AnuncioController'
        })
        .when('/sportsgo/anuncio/detalhe', {
            templateUrl: 'lib/views/anuncios/detalhes-anuncio.html',
            controller: 'AnuncioDetalheController'
        })
        .when('/sportsgo/anuncio/futebol', {
            templateUrl: 'lib/views/anuncios/anuncios-por-modalidade.html',
            controller: 'AnuncioModalidadeController'
        })
        .when('/sportsgo/anuncio/atletismo', {
            templateUrl: 'lib/views/anuncios/anuncios-por-modalidade.html',
            controller: 'AnuncioModalidadeController'
        })
        .when('/sportsgo/anuncio/voleibol', {
            templateUrl: 'lib/views/anuncios/anuncios-por-modalidade.html',
            controller: 'AnuncioModalidadeController'
        })
        .when('/sportsgo/anuncio/basquetebol', {
            templateUrl: 'lib/views/anuncios/anuncios-por-modalidade.html',
            controller: 'AnuncioModalidadeController'
        })
        .when('/sportsgo/anuncio/tenis', {
            templateUrl: 'lib/views/anuncios/anuncios-por-modalidade.html',
            controller: 'AnuncioModalidadeController'
        })
        .when('/sportsgo/anuncio/natacao', {
            templateUrl: 'lib/views/anuncios/anuncios-por-modalidade.html',
            controller: 'AnuncioModalidadeController'
        })
        .when('/sportsgo/anuncio/airsoft', {
            templateUrl: 'lib/views/anuncios/anuncios-por-modalidade.html',
            controller: 'AnuncioModalidadeController'
        })
        .when('/sportsgo/anuncio/skate', {
            templateUrl: 'lib/views/anuncios/anuncios-por-modalidade.html',
            controller: 'AnuncioModalidadeController'
        })
        .when('/sportsgo/anuncio/todos', {
            templateUrl: 'lib/views/anuncios/anuncios-todos.html',
            controller: 'AnuncioTodosController'
        })
        ;

    $routeProvider.otherwise({ redirectTo: '/sportsgo' });
}

function interceptor($httpProvider) {
    $httpProvider.interceptors.push('authInterceptor');
}
