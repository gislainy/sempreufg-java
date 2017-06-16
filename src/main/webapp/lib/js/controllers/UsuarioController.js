(function () {
    angular.module('sportsgo').controller('UsuarioController', UsuarioController);

    function UsuarioController($scope, $location, clearMaskService, requisicoesService, growl) {

        $scope.cadastrarUsuario = function () {
            if ($scope.usuario.senha === $scope.confirmarSenha) {
                if (validarCpfCnpj()) {
                    inserirEmailArray($scope.usuario.emails);
                    requisicoesService.novoUsuario($scope.usuario)
                        .then(function (response) {
                            growl.error('Usuário: '+response.data.usuario + 'foi cadastrado com sucesso');
                            $location.path('/sportsgo/login');
                        }, function (error) {
                            console.log(error);
                        });
                } else {
                    if($scope.cpfBool) {
                        growl.error('CPF inválido!');
                    } else {
                        growl.error('CNPJ inválido');
                    }
                }
            } else {
                growl.error('Senhas diferentes!');
            }
        };

        function inserirEmailArray(email) {
            var arrayEmail = [];
            arrayEmail.push(email);
            $scope.usuario.emails = arrayEmail;
        }

        function validarCpfCnpj() {
            if ($scope.cpfBool) {
                return ValidarCPF($scope.usuario.cpfcnpj);
            } else if ($scope.cnpjBool) {
                return ValidarCNPJ($scope.usuario.cpfcnpj);
            }
        }

        $scope.cpfActive = function () {
            $scope.cpfBool = true;
            $scope.cnpjBool = false;
            $scope.usuario.cpfcnpj = null;
        };

        $scope.cnpjActive = function () {
            $scope.cpfBool = false;
            $scope.cnpjBool = true;
            $scope.usuario.cpfcnpj = null;
        };

        function limparMascaras() {
            if ($scope.usuario.cpfcnpj.length == 14) {
                $scope.usuario.cpfcnpj = clearMaskService.clearMaskCpf($scope.usuario.cpfcnpj);
            } else {
                $scope.usuario.cpfcnpj = clearMaskService.clearMaskCnpj($scope.usuario.cpfcnpj);
            }
        }



    }
})();