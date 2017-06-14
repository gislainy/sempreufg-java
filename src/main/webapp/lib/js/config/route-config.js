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
        ;

    $routeProvider.otherwise({ redirectTo: '/sportsgo' });

}

function interceptor($httpProvider) {
    $httpProvider.interceptors.push('authInterceptor');
}
