(function () {
    angular.module('sempreufg').controller('PrincipalController', PrincipalController);

    function PrincipalController($scope, usuarioService, growl, $location, requisicoesService, logoutService, routeService) {

        function init() {
            $scope.admin = false;
        }

        init();

        $scope.$on('usuarioLogado', function (event, args) {
            growl.success('Bem vindo ' + args.usuario + '!');
            usuarioService.set('logado', args.logado);
            usuarioService.set('admin', args.admin);
            usuarioService.set('usuarioLogado', args.usuario);
            usuarioService.set('id', args.id);
            usuarioService.set('imagemPerfil', args.imagem);
            $scope.logado = args.logado;
            $scope.admin = args.admin;
            if (args !== undefined && args !== null && args.logado) {
                $scope.nomeUsuario = args.usuario;
            }
        });

        $scope.routeBack = function () {
            window.history.back();
        }

        $scope.modalidades = [
            {
                categoria: 'Futebol', viewUrl: '#/sempreufg/anuncio/futebol'
            },
            {
                categoria: 'Voleibol', viewUrl: '#/home/anuncio/voleibol'
            },
            {
                categoria: 'Basquetebol', viewUrl: '#/anuncio/basquetebol'
            },
            {
                categoria: 'Natação', viewUrl: '#/home/anuncio/natacao'
            },
            {
                categoria: 'Tênis', viewUrl: '#/home/anuncio/tenis'
            },
            {
                categoria: 'Atletismo', viewUrl: '#/home/anuncio/atletismo'
            },
            {
                categoria: 'Skate', viewUrl: '#/home/anuncio/skate'
            },
            {
                categoria: 'Airsoft', viewUrl: '#/home/anuncio/airsoft'
            },
        ];


        $scope.carregarAnunciosPorCategoria = function (modalidade) {
            var mod = formatarModalidade(modalidade.categoria);
            requisicoesService.carregarAnunciosPorModalidade(mod)
                .then(function (response) {
                    if (response.data.length > 0) {
                        usuarioService.set('anuncios', response.data);
                        usuarioService.set('modalidade', mod);
                        $location.path("/sempreufg/anuncio/" + mod);
                    } else {
                        growl.info('Não foi encontrado evento cadastrado para a modalidade selecionada');
                    }
                }, function (error) {
                    console.log('Falha na requisição ' + error);
                });
        };

        $scope.carregarAnunciosEmAnalise = function () {
            requisicoesService.carregarAnunciosEmAnalise()
                .then(function (response) {
                    if (response.data.length > 0) {
                        usuarioService.set('anuncios', response.data);
                        $location.path('/sempreufg/anuncios/pendentes');
                    } else {
                        growl.info('Nenhum anúncio em análise');
                    }
                }, function (error) {
                    console.log(error);
                });
        };

        $scope.carregarAnunciosBloqueados = function () {
            requisicoesService.carregarAnunciosBloqueados()
                .then(function (response) {
                    if (response.data.length > 0) {
                        usuarioService.set('anuncios', response.data);
                        $location.path('/sempreufg/anuncios/bloqueados');
                        $scope.$emit('meusAnuncios', null);
                    } else {
                        growl.info('Nenhum anúncio bloqueado');
                    }
                }, function (error) {
                    console.log(error);
                });
        };


        $scope.carregarAnunciosPublicados = function () {
            requisicoesService.carregarAnunciosPublicados()
                .then(function (response) {
                    if (response.data.length > 0) {
                        usuarioService.set('anuncios', response.data);
                        $location.path("/sempreufg/anuncio/todos");
                    } else {
                        growl.info('Nenhum anúncio cadastrado!!');
                    }
                }, function (error) {
                    console.log(error);
                });
        };

        $scope.carregarAnunciosPublicadosPorUsuario = function () {
            var idusuario = usuarioService.get('id');
            requisicoesService.carregarAnunciosPublicadosPorUsuario(idusuario)
                .then(function (response) {
                    if (response.data.length > 0) {
                        usuarioService.set('anuncios', response.data);
                        usuarioService.set('tipoAnuncio', 'publicados');
                        $location.path("/sempreufg/anuncios/publicados-usuario");
                    } else {
                        growl.info('Nenhum anúncio publicado!!');
                    }
                }, function (error) {
                    console.log(error);
                });
        };

        $scope.carregarAnunciosEmAnalisePorUsuario = function () {
            var idusuario = usuarioService.get('id');
            requisicoesService.carregarAnunciosEmAnalisePorUsuario(idusuario)
                .then(function (response) {
                    if (response.data.length > 0) {
                        usuarioService.set('anuncios', response.data);
                        usuarioService.set('tipoAnuncio', 'em análise');
                        $location.path("/sempreufg/anuncios/pendentes-usuario");
                    } else {
                        growl.info('Nenhum anúncio pendente!!');
                    }
                }, function (error) {
                    console.log(error);
                });
        };


        function formatarModalidade(modalidade) {
            var mod = modalidade.toLowerCase();
            if (mod === 'tênis') {
                mod = 'tenis';
            } else if (mod === 'natação') {
                mod = 'natacao';
            }
            return mod;
        }

        $scope.logout = function () {
            var sair = confirm('Deseja mesmo sair?');
            if (sair) {
                logoutService.logout();
                delete $scope.logado;
                delete $scope.nomeUsuario;
                delete $scope.admin;
                usuarioService.set('logado', null);
                usuarioService.set('admin', null);
                usuarioService.set('usuarioLogado', null);
                usuarioService.set('id', null);
            }
        };

        $scope.verificarCadastroUsuario = function () {
            var id = usuarioService.get('id');
            requisicoesService.buscarUsuarioID(id)
                .then(function (response) {
                    var usuario = response.data;
                    if (usuario !== '' && usuario !== null) {
                        var cadastroIncompleto = usuario.cpfcnpj === null && usuario.enderecos === null && usuario.redesSociais === null && usuario.telefones === null;
                        if (cadastroIncompleto) {
                            usuarioService.set('usuarioCadastroCompleto', usuario);
                            growl.info('Cadastro de usuário incompleto, será redirecionado para a tela de cadastro');
                            routeService.mudarRotaTimeout('/sempreufg/usuario/cadastro');
                        } else {
                            routeService.mudarRota('sempreufg/anuncio/novo');
                        }
                    }
                }, function (error) {
                    console.log('Falha na requisição' + error);
                });
        };


    }
})();