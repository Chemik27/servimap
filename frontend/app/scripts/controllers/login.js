'use strict';

angular.module('dutymap')
    .controller('NavigationCtrl', ['$scope', '$rootScope', '$http', '$location' ,
    function ($scope, $rootScope, $http, $location) {

        $scope.authenticate = function(credentials, callback) {

            $scope.headers = credentials ? {authorization : "Basic "
                              + btoa(credentials.username + ":" + credentials.password)
                              } : {};

            $http.get('/api/user', {headers : $scope.headers}).then(function(response) {
                if (response.data.name) {
                    $rootScope.authenticated = true;
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
                  $location.path("/login");
                  $scope.error = true;
                }
            });
        };

        $scope.logout = function() {
            $http.post('/api/logout', {}).finally(function() {
              $rootScope.authenticated = false;
              $location.path("/");
            });
        }

    }]);
