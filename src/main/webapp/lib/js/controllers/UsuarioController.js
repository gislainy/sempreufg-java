(function () {
    angular.module('sportsgo').controller('UsuarioController', UsuarioController);

    function UsuarioController($scope, $location, usuarioService, requisicoesService) {

        function init() {
            $scope.usuario = usuarioService.get('usuario');
        }

        init();

        $scope.selecionarPessoa = function () {
            if ($scope.usuario.pessoa.tipopessoa === 'fisica') {
                $scope.cpfBool = true;
                $scope.cnpjBool = false;
            } else if ($scope.usuario.pessoa.tipopessoa === 'juridica') {
                $scope.cpfBool = false;
                $scope.cnpjBool = true;
            } else {
                $scope.cpfBool = false;
                $scope.cnpjBool = false;
            }
        };

        $scope.carregarViewCredenciais = function() {
            usuarioService.set('usuario', $scope.usuario);
            $location.path('/sportsgo/novo_usuario/credenciais');
        };

        $scope.carregarViewDados = function() {
            $location.path('/sportsgo/novo_usuario/dados');
            $scope.usuario = usuarioService.get('usuario');
        };

        $scope.cadastrarUsuario = function() {
            requisicoesService.novoUsuario($scope.usuario)
            .then(function(response) {
                if(response.data) {
                    console.log('Usuário cadastrado com sucesso');
                } else {
                    console.log('Falha ao cadastrar o usuário');
                }
            }, function(error){
                console.log(error);
            });
        }

       

    }
})();