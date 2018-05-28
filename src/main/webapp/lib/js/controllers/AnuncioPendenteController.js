(function () {

    angular.module('sempreufg').controller('AnuncioPendenteController', AnuncioPendenteController);

    function AnuncioPendenteController($scope, growl, usuarioService, routeService, requisicoesService) {

        function init() {
            $scope.anuncios = usuarioService.get('anuncios');
            $scope.tipoAnuncio = 'em análise';
            definirFotoCapa();
            configurarObjetoAnuncio();
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

        $scope.publicarAnuncio = function (anuncio, index) {
            anuncio.status = 'PUBLICADO';
            anuncio.usuario = {
                "idUsuario": anuncio.usuario
            };
            var publicar = confirm('Deseja publicar o anúncio?');
            if (publicar) {
                requisicoesService.publicarAnuncio(anuncio)
                    .then(function (response) {
                        if (response.data.retorno) {
                            growl.success('Anúncio publicado com sucesso');
                            $scope.anuncios.splice(index, 1);
                            verificarArrayAnuncios();
                        } else {
                            growl.error('Falha ao tentar bloquear anúncio');
                        }
                    }, function (error) {
                        console.log(error);
                    });
            }
        };

        $scope.bloquearAnuncio = function (anuncio, index) {
            anuncio.status = 'BLOQUEADO';
            anuncio.usuario = {
                "idUsuario": anuncio.usuario
            };
            var bloquear = confirm('Deseja bloquear o anúncio?');
            if (bloquear) {
                requisicoesService.bloquearAnuncio(anuncio)
                    .then(function (response) {
                        if (response.data.retorno) {
                            growl.success('Anúncio bloqueado com sucesso');
                            $scope.anuncios.splice(index, 1);
                            verificarArrayAnuncios();
                        } else {
                            growl.error('Falha ao tentar bloquear anúncio');
                        }
                    }, function (error) {
                        console.log(error);
                    });
            }
        };

        function verificarArrayAnuncios() {
            if($scope.anuncios.length === 0) {
                routeService.mudarRota('/sempreufg');
            }
        }

        function configurarObjetoAnuncio() {
            var i;
            var j;
            for (i in $scope.anuncios) {
                for (j in $scope.anuncios[i].arquivos) {
                    $scope.anuncios[i].arquivos[j].codAnuncio = $scope.anuncios[i].arquivos[j].anuncio;
                    delete $scope.anuncios[i].arquivos[j].anuncio;
                }
                for (j in $scope.anuncios[i].datas) {
                    $scope.anuncios[i].datas[j].codAnuncio = $scope.anuncios[i].datas[j].anuncio;
                    delete $scope.anuncios[i].datas[j].anuncio;
                }
                for (j in $scope.anuncios[i].locais) {
                    $scope.anuncios[i].locais[j].codAnuncio = $scope.anuncios[i].locais[j].anuncio;
                    delete $scope.anuncios[i].locais[j].anuncio;
                }
            }
        }

    }

})();