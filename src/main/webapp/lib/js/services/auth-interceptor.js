angular.module('sportsgo')
  .factory('authInterceptor', authInterceptor);

function authInterceptor($q, $location, $rootScope) {
  return {
    request: function (config) {
      config.headers.Authorization = 'Bearer ' + localStorage.getItem('userToken');

      return config;
    },
    responseError: function (response) {
      if (response.status === 401 || response.status === 403) {
        $location.path('/sportsgo');
        console.log('Usuário não autenticado');
      }
      console.log('Usuário não autenticado');
      return $q.reject(response);
    }

  };
}