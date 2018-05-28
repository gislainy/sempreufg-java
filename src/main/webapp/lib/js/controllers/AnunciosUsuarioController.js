(function () {
    angular.module('sempreufg').controller('AnunciosUsuarioController', AnunciosUsuarioController);

    function AnunciosUsuarioController($scope, growl, usuarioService, requisicoesService, routeService) {

        function init() {
            $scope.anuncios = usuarioService.get('anuncios');
            $scope.tipoAnuncio = usuarioService.get('tipoAnuncio');
            definirFotoCapa();
        }

        init();

        function definirFotoCapa() {
            var indice;
            for (indice in $scope.anuncios) {
                $scope.anuncios[indice].fotoCapa = $scope.anuncios[indice].arquivos[0].enderecoArquivo;
            }
        }

        $scope.carregarDetalhesAnuncio = function (anuncio) {
            usuarioService.set('anuncioEscolhido', anuncio);
            routeService.mudarRota('/sempreufg/anuncio/detalhe');
        };

        $scope.editarAnuncio = function (anuncio) {
            usuarioService.set('anuncioEditar', anuncio);
            routeService.mudarRota('/sempreufg/anuncio/editar');
        };

        $scope.deletarAnuncio = function (anuncio, index) {
            var deletar = confirm('Deseja mesmo deletar o anúncio?');
            if (deletar) {
                configurarObjetoRequisicao(anuncio);
                requisicoesService.deletarAnuncio(anuncio)
                    .then(function (response) {
                        if (response.data.retorno) {
                            growl.success('Anúncio excluído com sucesso');
                            $scope.anuncios.splice(index, 1);
                        } else {
                            growl.erro('Falha ao excluir anúncio');
                        }
                    }, function (error) {
                        console.log(error);
                    });
            }
        };

        function configurarObjetoRequisicao(anuncio) {
            delete anuncio.fotoCapa;
            anuncio.usuario = {
                "idUsuario": anuncio.usuario
            };
            var index;
            for (index in anuncio.arquivos) {
                anuncio.arquivos[index].codAnuncio = anuncio.arquivos[index].anuncio;
                delete anuncio.arquivos[index].anuncio;
            }
            anuncio.datas[0].codAnuncio = anuncio.datas[0].anuncio;
            delete anuncio.datas[0].anuncio;
            anuncio.locais[0].codAnuncio = anuncio.locais[0].anuncio;
            delete anuncio.locais[0].anuncio;
        }
    }

})();