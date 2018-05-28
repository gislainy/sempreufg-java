(function () {
    angular.module('sempreufg').controller('LoginController', LoginController);

    function LoginController($scope, requisicoesService, growl, $location) {

        $scope.autenticar = function () {
            $scope.usuario.login = $scope.usuario.login.toLowerCase();
            requisicoesService.autenticarUsuario($scope.usuario)
                .then(function (response) {
                    if (response.data === null || response.data === '') {
                        growl.error('Usuário ou senha inválido');
                    } else {
                        $scope.$emit('usuarioLogado', { logado: true,admin: response.data.admin, usuario: response.data.nome, imagem: response.data.imagem, id: response.data.id });
                        localStorage.setItem('token', response.data.token);
                        $location.path('#/sempreufg');
                    }
                }, function (error) {
                    console.log('Falha na requisição: ' + error);
                });
        };


    }

})();