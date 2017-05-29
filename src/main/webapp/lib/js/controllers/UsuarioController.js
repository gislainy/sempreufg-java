(function () {
    angular.module('sportsgo').controller('UsuarioController', UsuarioController);

    function UsuarioController($scope, $location, usuarioService, requisicoesService, clearMaskService) {

        function init() {
            $scope.usuario = usuarioService.get('usuario');
        }

        init();

        $scope.selecionarPessoa = function () {
            if ($scope.tipopessoa === 'fisica') {
                $scope.cpfBool = true;
                $scope.cnpjBool = false;
                $scope.usuarioFisica = true;
                $scope.usuarioJuririda = false;
            } else if ($scope.tipopessoa === 'juridica') {
                $scope.cpfBool = false;
                $scope.cnpjBool = true;
                $scope.usuarioJuririda = true;
                $scope.usuarioFisica = false;
            } else {
                $scope.cpfBool = false;
                $scope.cnpjBool = false;
                $scope.usuarioJuririda = false;
                $scope.usuarioFisica = false;
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
            limparMascaras();
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
        };

        function limparMascaras() {
            //$scope.usuario.telefone = clearMaskService.clearMaskTelefone($scope.usuario.telefone);
            if($scope.usuario.cpfcnpj.length == 14) {
                $scope.usuario.cpfcnpj = clearMaskService.clearMaskCpf($scope.usuario.cpfcnpj);
            } else {
                $scope.usuario.cpfcnpj = clearMaskService.clearMaskCnpj($scope.usuario.cpfcnpj);
            }
        }

       

    }
})();