(function () {
    'use strict';
    var myApp = angular.module('sportsgo');
    myApp.service('fileUploadService', function ($http, $q) {

        function filesArray(files) {
             var fileFormData = new FormData();
             var file;
            for (var i = 0; i < files.length; i++) {
                file = files.item(i);
                fileFormData.append('file', file);
            }
            return fileFormData;
        }

        this.uploadFileToUrl = function (anuncio, file, uploadUrl) {
            var fileFormData = filesArray(file);
            fileFormData.append('anuncio', JSON.stringify(anuncio));

            var deffered = $q.defer();
            $http.post(uploadUrl, fileFormData, {
                transformRequest: angular.identity,
                headers: { 'Content-Type': undefined }

            }).success(function (response) {
                deffered.resolve(response);

            }).error(function (response) {
                deffered.reject(response);
            });

            return deffered.promise;
        };
    });
})();