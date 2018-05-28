(function () {
    'use strict';
    angular.module('sempreufg').service('fileUploadService', function () {

        function filesArray(files) {
            var fileFormData = new FormData();
            var file;
            for (var i = 0; i < files.length; i++) {
                file = files.item(i);
                fileFormData.append('file', file);
            }
            return fileFormData;
        }

        this.uploadFileToUrl = function (tipoObj, anuncio, file) {
            var fileFormData = filesArray(file);
            fileFormData.append(tipoObj, JSON.stringify(anuncio));
            return fileFormData;
        };
    });
})();