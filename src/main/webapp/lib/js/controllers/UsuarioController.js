(function () {
    angular.module('sportsgo').controller('UsuarioController', UsuarioController);

    function UsuarioController($scope, $location, usuarioService, requisicoesService, clearMaskService) {

        function init() {
            $scope.pessoa = usuarioService.get('pessoa');
        }

        init();

        $scope.selecionarPessoa = function () {
            if ($scope.pessoa.tipopessoa === 'fisica') {
                $scope.cpfBool = true;
                $scope.cnpjBool = false;
            } else if ($scope.pessoa.tipopessoa === 'juridica') {
                $scope.cpfBool = false;
                $scope.cnpjBool = true;
            } else {
                $scope.cpfBool = false;
                $scope.cnpjBool = false;
            }
        };

        $scope.carregarViewCredenciais = function() {
            usuarioService.set('pessoa', $scope.pessoa);
            $location.path('/sportsgo/novo_usuario/credenciais');
        };

        $scope.carregarViewDados = function() {
            $location.path('/sportsgo/novo_usuario/dados');
            $scope.pessoa = usuarioService.get('pessoa');
        };

        $scope.cadastrarUsuario = function() {
            limparMascaras();
            requisicoesService.novoUsuario($scope.pessoa)
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
            $scope.pessoa.telefone = clearMaskService.clearMaskTelefone($scope.pessoa.telefone);
            if($scope.pessoa.cpfcnpj.length == 14) {
                $scope.pessoa.cpfcnpj = clearMaskService.clearMaskCpf($scope.pessoa.cpfcnpj);
            } else {
                $scope.pessoa.cpfcnpj = clearMaskService.clearMaskCnpj($scope.pessoa.cpfcnpj);
            }
        }

       

    }
})();