(function () {
    angular.module('sportsgo').controller('AnuncioDetalheController', AnuncioDetalheController);

    function AnuncioDetalheController($scope, growl, usuarioService, requisicoesService) {

        function init() {
            $scope.logado = usuarioService.get('logado');
            $scope.anuncio = usuarioService.get('anuncioEscolhido');
            verificarComentariosNull();
            carregarComentariosAnuncio($scope.anuncio.codAnuncio);
            $scope.coment = {
                "texto": "",
                "autor": "",
                "idUsuario": ""
            };
            $scope.anuncio.usuario = {
                "idUsuario": $scope.anuncio.usuario
            };
            carregarAutor();
            verificarStatusAnuncio();
        }

        init();

        function verificarStatusAnuncio() {
            switch($scope.anuncio.status) {
                case 'EM_ANALISE': {
                    $scope.statusPublicado = false;
                    break;
                }
                case 'BLOQUEADO': {
                    $scope.statusPublicado = false;
                    break;
                }
                case 'PUBLICADO': {
                    $scope.statusPublicado = true;
                }
            }
        }

        function verificarComentariosNull() {
            if ($scope.anuncio.comentarios === null) {
                $scope.anuncio.comentarios = [];
            }
        }

        function carregarAutor() {
            requisicoesService.buscarUsuarioID(usuarioService.get('id'))
                .then(function (response) {
                    if (response.data !== null && response.data !== '') {
                        $scope.autor = response.data.nome + ' ' + response.data.sobrenome;
                        delete response.data;
                    } else {
                        growl.error('Falha ao buscar autor do anúncio');
                    }
                }, function (error) {
                    console.log(error);
                });
        }


        $scope.inserirComentario = function (textoComentario) {
            $scope.textoComentario = textoComentario.$modelValue;
            textoComentario.$modelValue = '';
            if ($scope.textoComentario.length > 0) {   
                configurarObjetoRequisicao();
                requisicoesService.inserirComentarioAnuncio($scope.anuncio)
                    .then(function (response) {
                        if (response.data.retorno) {
                            carregarComentariosAnuncio($scope.anuncio.codAnuncio);
                            $scope.anuncio.comentarios.pop();
                            $scope.textoComentario = null;
                        } else {
                            growl.error('Falha ao comentar anúncio');
                        }
                    }, function (error) {
                        console.log(error);
                    });
            }   
        };

        function carregarComentariosAnuncio(id) {
            requisicoesService.buscarComentariosAnuncio(id)
                .then(function (response) {
                    if (response.data.length > 0) {
                        $scope.comentarios = response.data;
                    } else {
                        console.log('Nenhum comentário encontrado');
                    }
                }, function (error) {
                    console.log(error);
                });
        }

        function configurarObjetoRequisicao() {
            var index;
            for (index in $scope.anuncio.arquivos) {
                $scope.anuncio.arquivos[index].codAnuncio = $scope.anuncio.arquivos[index].anuncio;
                delete $scope.anuncio.arquivos[index].anuncio;
            }
            for (index in $scope.anuncio.comentarios) {
                $scope.anuncio.comentarios[index].codAnuncio = $scope.anuncio.comentarios[index].anuncio;
                delete $scope.anuncio.comentarios[index].anuncio;
            }
            for (index in $scope.anuncio.datas) {
                $scope.anuncio.datas[index].codAnuncio = $scope.anuncio.datas[index].anuncio;
                delete $scope.anuncio.datas[index].anuncio;
            }
            for (index in $scope.anuncio.locais) {
                $scope.anuncio.locais[index].codAnuncio = $scope.anuncio.locais[index].anuncio;
                delete $scope.anuncio.locais[index].anuncio;
            }
            $scope.coment.autor = $scope.autor;
            $scope.coment.texto = $scope.textoComentario;
            $scope.coment.idUsuario = usuarioService.get('id');
            $scope.coment.dataInclusao = new Date();
            $scope.anuncio.comentarios.push($scope.coment);
        }

    }
})();