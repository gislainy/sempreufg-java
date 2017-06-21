(function () {
    angular.module('sportsgo').controller('PrincipalController', PrincipalController);

    function PrincipalController($scope, usuarioService, growl, $location, requisicoesService, logoutService) {

        $scope.$on('usuarioLogado', function (event, args) {
            growl.success('Bem vindo ' + args.usuario + '!');
            usuarioService.set('logado', args.logado);
            usuarioService.set('usuarioLogado', args.usuario);
            usuarioService.set('id', args.id);
            $scope.logado = args.logado;
            if (args !== undefined && args !== null && args.logado) {
                $scope.usuario = args.usuario;
            }
        });

        $scope.modalidades = [
            {
                categoria: 'Futebol', viewUrl: '#/sportsgo/anuncio/futebol'
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
                        $location.path("/sportsgo/anuncio/" + mod);
                    } else {
                        growl.info('Não foi encontrado evento cadastrado para a modalidade selecionada');
                    }
                }, function (error) {
                    console.log('Falha na requisição ' + error);
                });
        };

        $scope.carregarAnuncios = function () {
            requisicoesService.carregarAnuncios()
                .then(function (response) {
                    if (response.data.length > 0) {
                        usuarioService.set('anuncios', response.data);
                        $location.path("/sportsgo/anuncio/todos");
                    } else {
                        growl.info('Nenhum anúncio cadastrado!!');
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

        $scope.logout = function() {
            var sair = confirm('Deseja mesmo sair?');
            if(sair) {
                logoutService.logout();
                $scope.logado = null;
                $scope.usuario = null;
            }
        };

    }
})();