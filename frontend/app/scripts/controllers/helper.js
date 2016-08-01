'use strict';

angular.module('dutymap')
    .controller('HelperCtrl', ['$scope', '$routeParams', 'LoginResources', 'NotificationService',
    function ($scope, $routeParams, LoginResources, NotificationService) {

          $scope.recover = function() {
              LoginResources.recover($scope.email, function (response) {
                NotificationService.success('Recupera tu password desde el email que te enviamos a tu correo');
              }, function (error) {
                NotificationService.error('Se produjo un error, intentelo de nuevo mas tarde');
              });
          }
    }]);
