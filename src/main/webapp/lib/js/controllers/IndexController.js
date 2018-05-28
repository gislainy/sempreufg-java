(function () {
    angular.module('sempreufg').controller('IndexController', IndexController);

    function IndexController($scope, requisicoesService, growl, usuarioService, routeService) {


        function init() {
            carregarAnuncios();
        }

        init();

        $scope.carouselInitializer = function () {
            $(".about-carousel").owlCarousel({
                items: 3,
                navigation: true,
                pagination: false,
                navigationText: ["<i class='fa fa-angle-left'></i>", "<i class='fa fa-angle-right'></i>"]
            });
        };


        function carregarAnuncios() {
            requisicoesService.carregarAnunciosPublicados()
                .then(function (response) {
                    if (response.data.length > 0) {
                        $scope.anuncios = response.data;
                        definirFotoCapa();
                    } else {
                        console.log('Nenhum anúncio cadastrado');
                    }
                }, function (error) {
                    console.log(error);
                });
        }

        function definirFotoCapa() {
            var indice;
            for (indice in $scope.anuncios) {
                $scope.anuncios[indice].fotoCapa = $scope.anuncios[indice].arquivos[0].enderecoArquivo;
            }
            console.log($scope.anuncios);
        }

        $scope.carregarDetalhesAnuncio = function(anuncio) {
            usuarioService.set('anuncioEscolhido', anuncio);
            routeService.mudarRota('/sempreufg/anuncio/detalhe');
        };


        $scope.categorias = [
            {
                categoria: 'Futebol', imageUrl: 'lib/img/bola.png', viewUrl: '#/sempreufg/Futebol'
            },
            {
                categoria: 'Voleibol', imageUrl: 'lib/img/volei.png', viewUrl: '#/sempreufg/Voleibol'
            },
            {
                categoria: 'Basquetebol', imageUrl: 'lib/img/basquete.png', viewUrl: '#/sempreufg/Basquetebol'
            },
            {
                categoria: 'Natação', imageUrl: 'lib/img/natacao.png', viewUrl: '#/sempreufg/Natação'
            },
            {
                categoria: 'Tênis', imageUrl: 'lib/img/tenis.png', viewUrl: '#/sempreufg/Tênis'
            },
            {
                categoria: 'Atletismo', imageUrl: 'lib/img/corrida.png', viewUrl: '#/sempreufg/Atletismo'
            },
            {
                categoria: 'Skate', imageUrl: 'lib/img/skate.png', viewUrl: '#/sempreufg/Skate'
            },
            {
                categoria: 'Airsoft', imageUrl: 'lib/img/airsoft.png', viewUrl: '#/sempreufg/Airsoft'
            },
        ];

    }
})();