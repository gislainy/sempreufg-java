angular.module('sportsgo').service('logoutService', logoutService);

function logoutService($location, usuarioService, growl, $timeout, $q) {
    this.logout = function () {
        localStorage.clear();
        $q.when();
        usuarioService.set('logado', false);
        usuarioService.set('usuarioLogado', null);
        usuarioService.set('id', null);
        $location.path('/sportsgo/login');
    };

    this.logoutTimeout = function () {
        localStorage.clear();
        $q.when();
        growl.info('Sessão encerrada por tempo, será redirecionado para um novo login');
        $timeout(function () {
            usuarioService.set('logado', false);
            usuarioService.set('usuarioLogado', null);
            usuarioService.set('id', null);
            $location.path('/sportsgo/login');
        }, 5000);
    };
}