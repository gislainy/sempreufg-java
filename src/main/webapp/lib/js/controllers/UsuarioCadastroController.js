(function () {
    angular.module('sportsgo').controller('UsuarioCadastroController', UsuarioCadastroController);

    function UsuarioCadastroController($scope, growl, requisicoesService, routeService, clearMaskService) {


        $scope.cadastrarUsuario = function () {
            if (validarCpfCnpj()) {
                if (validarTelefone()) {
                    limparMascaras();
                    inserirDadosArray($scope.usuario.enderecos, $scope.usuario.redesSociais, $scope.usuario.telefones);
                    requisicoesService.completarCadastroUsuario($scope.usuario)
                        .then(function (response) {
                            if(response.data.retorno) {
                                growl.error('Cadastro completado com sucesso');
                                routeService.mudarRotaTimeout('/sportsgo');
                            }
                        }, function (error) {
                            console.log('Falha na requisição' + error);
                        });
                }
            }
        }

        function validarCpfCnpj() {
            if ($scope.cpfBool) {
                if (ValidarCPF($scope.usuario.cpfcnpj)) {
                    return true;
                } else {
                    growl.error('CPF inválido');
                    return false;
                }
            } else if ($scope.cnpjBool) {
                if (ValidarCNPJ($scope.usuario.cpfcnpj)) {
                    return true;
                } else {
                    growl.error('CNPJ inválido');
                    return false;
                }
            }
        }

        function validarTelefone() {
            if (ValidarTelefone($scope.usuario.telefones)) {
                return true;
            } else {
                growl.error("Telefone inválido");
                return false;
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

        $scope.setFacebook = function () {
            $scope.usuario.redesSociais = {
                'nomeRede': 'facebook'
            }
        }

        $scope.setTwitter = function () {
            $scope.usuario.redesSociais = {
                'nomeRede': 'twitter'
            }
        }

        $scope.setInstagram = function () {
            $scope.usuario.redesSociais = {
                'nomeRede': 'instagram'
            }
        }

        function limparMascaras() {
            if ($scope.usuario.cpfcnpj.length == 14) {
                $scope.usuario.cpfcnpj = clearMaskService.clearMaskCpf($scope.usuario.cpfcnpj);
            } else {
                $scope.usuario.cpfcnpj = clearMaskService.clearMaskCnpj($scope.usuario.cpfcnpj);
            }
            if ($scope.usuario.telefones.length > 0) {
                separarDadosTelefone(clearMaskService.clearMaskTelefone($scope.usuario.telefones));
            }
        }

        function separarDadosTelefone(telefone) {
            $scope.usuario.telefones = {};
            $scope.usuario.telefones.dddNumero = telefone.slice(0,2);
            $scope.usuario.telefones.numero = telefone.slice(2);
        }

        function inserirDadosArray(endereco, redesocial, telefone) {
            var arrayEndereco = [];
            var arrayRedeSocial = [];
            var arrayTelefones = [];
            arrayEndereco.push(endereco);
            arrayRedeSocial.push(redesocial);
            arrayTelefones.push(telefone);
            $scope.usuario.enderecos = arrayEndereco;
            $scope.usuario.redesSociais = arrayRedeSocial;
            $scope.usuario.telefones = arrayTelefones;
            $scope.usuario.emails = [];
            $scope.usuario.login = null;
            $scope.usuario.senha = null;
        }


    }

})();