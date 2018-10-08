'use strict';

angular.module('servimap')
    .controller('HelperCtrl', ['$scope', '$routeParams', 'LoginResources', 'NotificationService', '$location',
    function ($scope, $routeParams, LoginResources, NotificationService, $location) {

          $scope.recover = function() {
              LoginResources.recover($scope.email, function (response) {
                NotificationService.success('Recupera tu password desde el email que te enviamos a tu correo');
                $location.path("/");
              }, function (error) {
                NotificationService.error('Se produjo un error, intentelo de nuevo mas tarde');
              });
          }
    }]);
