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
        .when('/sportsgo/novo_usuario/dados', {
            templateUrl: 'lib/views/usuario/dados.html',
            controller: 'UsuarioController'
        })
        .when('/sportsgo/novo_usuario/credenciais', {
            templateUrl: 'lib/views/usuario/credenciais.html',
            controller: 'UsuarioController'
        })
        ;

    $routeProvider.otherwise({ redirectTo: '/sportsgo' });

}

function interceptor($httpProvider) {
    $httpProvider.interceptors.push('authInterceptor');
}
