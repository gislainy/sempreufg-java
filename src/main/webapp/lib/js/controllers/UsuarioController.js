(function () {
    angular.module('sempreufg').controller('UsuarioController', UsuarioController);

    function UsuarioController($scope, $location, clearMaskService, $timeout, requisicoesService, growl) {

        $scope.cadastrarUsuario = function () {
            if ($scope.usuario.senha === $scope.confirmarSenha) {
                inserirEmailArray($scope.usuario.emails);
                validarCadastroUsuario();
            } else {
                growl.error('Senhas diferentes!');
            }
        };

        function redirectLogin() {
            $timeout(function () {
                $location.path('#/sempreufg/login');
            }, 5000);
        }

        function validarCadastroUsuario() {
            $scope.usuario.login = $scope.usuario.login.toLowerCase();
            requisicoesService.validarCadastroUsuario($scope.usuario)
                .then(function (response) {
                    if(response.data.retorno) {
                        growl.error('Usuário já cadastrado com os seguintes dados: '+ response.data.erros.toString());
                        $scope.usuario.emails = $scope.emailAntigo;
                    } else {
                        verificarUsuarioAdmin();
                        novoUsuario();
                        delete $scope.usuario;
                        delete $scope.confirmarSenha;
                    }
                }, function (error) {
                    console.log('Falha na requisição '+ error);
                });
        }

        function verificarUsuarioAdmin() {
            if ($scope.usuario.login.toLowerCase().trim() === 'admin') {
                $scope.usuario.admin = true;
            } else {
                $scope.usuario.admin = false;
            }
        }


        function novoUsuario() {
            requisicoesService.novoUsuario($scope.usuario)
                .then(function (response) {
                    if (response.data !== null && response.data !== '') {
                        growl.success('Usuário: ' + response.data.login + ' foi cadastrado com sucesso');
                        $scope.usuario = null;
                        enviarEmailUsuario(response.data);
                        redirectLogin();
                    }
                }, function (error) {
                    console.log('Falha na requisição ' + error);
                });
        }

        function enviarEmailUsuario(usuario) {
            requisicoesService.enviarEmailUsuario(usuario)
                .then(function (response) {
                    console.log('Email enviado com sucesso');
                }, function (error) {
                    console.log('Falha ao enviar email');
                });
        }

        function inserirEmailArray(email) {
            var arrayEmail = [];
            $scope.emailAntigo = email;
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