(function(){
    angular.module('sempreufg').service('clearMaskService', clearMaskService);

    function clearMaskService(){
        this.clearMaskCpf = function(cpf) {
            return cpf.replace('.', '').replace('.', '').replace('-', '').trim();
        }; 
        this.clearMaskCnpj = function(cnpj) {
            return cnpj.replace('.','').replace('.','').replace('/','').replace('-','').trim();
        };
        this.clearMaskValor = function(valor) {
            return valor.replace('.', '').replace(',', '').replace('R$', '').trim();
        };
        this.clearMaskCep = function(cep) {
            return cep.replace('.','').replace('-','').trim();
        };
        this.clearMaskTelefone = function(telefone) {
            return telefone.replace('(','').replace(')','').replace('-','').trim();
        }
    }

})();