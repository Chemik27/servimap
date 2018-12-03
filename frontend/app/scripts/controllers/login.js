'use strict';

angular.module('servimap')
    .controller('NavigationCtrl', ['$scope', '$rootScope', '$http', '$location' ,'NotificationService',
    function ($scope, $rootScope, $http, $location, NotificationService) {
      window.scrollTo(0, 0);

        $scope.authenticate = function(credentials, callback) {

            $scope.headers = credentials ? {authorization : "Basic "
                              + btoa(credentials.username + ":" + credentials.password)
                              } : {};

            $http.get('/api/user', {headers : $scope.headers}).then(function(response) {
                if (response.data.name) {
                    $rootScope.authenticated = true;
                    $rootScope.idUser = response.data.name; // Validar si hay que quitarlo
                } else {
                    $rootScope.authenticated = false;
                }
                callback && callback();
            }, function() {
                $rootScope.authenticated = false;
                callback && callback();
            });

        };

        $scope.authenticate();
        $scope.credentials = {};

        $scope.login = function() {
            $scope.authenticate($scope.credentials, function() {
                if ($rootScope.authenticated) {
                  $location.path("/");
                  $scope.error = false;
                } else {
                  NotificationService.error('Datos incorrectos. Intenta nuevamente');
                  $location.path("/login");
                  $scope.error = true;
                }
            });
        };

        $scope.logout = function() {
            $http.post('/api/logout', {}).finally(function() {
              $rootScope.idUser = null;
              $rootScope.authenticated = false;
              $location.path("/");
            });
        }


        /**
         * SUPER METODO PEOLA
         */


        // $scope.recoverPassword = function(){
        //   console.log("entro al metodo");
        //   $scope.authenticate2("asd", function() {
        //     if ($rootScope.mailEnviado) {
        //       $location.path("/");
        //       $scope.error = false;
        //     } else {
        //       NotificationService.error('Datos incorrectos. Intenta nuevamente');
        //       $location.path("/login");
        //       $scope.error = true;
        //     }
        //   });
        //
        // }

    }]);
