(function () {

    angular.module('sempreufg').controller('AnuncioEditarController', AnuncioEditarController);

    function AnuncioEditarController($scope, growl, usuarioService, requisicoesService) {

        function init() {
            $scope.anuncio = usuarioService.get('anuncioEditar');
            formatarDatas();
        }

        init();

        $scope.modalidadesEsportivas = [
            "Futebol", "Natação", "Atletismo", "Tênis", "Basquetebol", "Voleibol", "Skate", "Airsoft"
        ];

        function formatarDatas() {
            var dataTermino = $scope.anuncio.dataTermino;
            var dataEvento = $scope.anuncio.datas[0].dataEvento;
            dataTermino = new Date(dataTermino);
            dataEvento = new Date(dataEvento);
            var mesTermino = dataTermino.getMonth() + 1;
            var mesInicio = dataEvento.getMonth() + 1;
            $scope.anuncio.dataTermino = dataTermino.getDate() + '/' + mesTermino + '/' + dataTermino.getFullYear();
            $scope.anuncio.datas[0].dataEvento = dataEvento.getDate() + '/' + mesInicio + '/' + dataEvento.getFullYear();
        }

    }

})();