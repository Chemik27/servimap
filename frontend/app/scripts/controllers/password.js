'use strict';

angular.module('dutymap')
  .controller('PasswordCtrl', ['$scope', '$routeParams', 'LoginResources', 'NotificationService', '$rootScope', '$location',
    function ($scope, $routeParams, LoginResources, NotificationService, $rootScope, $location) {
      $scope.changePasswordValidator = true;
      $rootScope.emailHashed = $routeParams.hash;

      $scope.saveNewPassword = function(){
          $rootScope.newPassowrd = $scope.password;
          var user = {email: $rootScope.emailHashed, password: $scope.newPassword}
          LoginResources.updatePassword(user,  function (response) {
            NotificationService.success('Su contraseña ha sido modificada satisfactoriamente');
            $location.path("/");
          }, function (error) {
            NotificationService.error('Se produjo un error al modificar su password, intentelo nuevamente mas tarde');
          });
      }
      console.log($routeParams.hash);
      console.log("Helper");
      // LoginResources.get($routeParams.email, function (response) {
      //     NotificationService.success('lalala')
      // }, function (error) {
      //     NotificationService.error('lalala')
      // });

    }]);
