(function(){
    angular.module('sportsgo').controller('AnuncioCadastroController', AnuncioCadastroController);

    function AnuncioCadastroController($scope) {

        $scope.modalidadesEsportivas = [
            "Futebol",
            "Natação",
            "Atletismo",
            "Tênis",
            "Basquetebol",
            "Voleibol",
            "Skate",
            "Airsoft"
        ];


    }
})();