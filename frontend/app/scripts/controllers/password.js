'use strict';

angular.module('dutymap')
  .controller('PasswordCtrl', ['$scope', '$routeParams', 'NotificationService', '$rootScope',
    function ($scope, $routeParams, NotificationService, $rootScope) {
      $scope.changePasswordValidator = true;
      $rootScope.emailHashed = $routeParams.hash;
      
      $scope.savePassword = function(){
        $rootScope.newPassowrd = $scope.password;
        // $location.path("/#/changePassword");

        // $scope.searchByDistrict = function(id){
        //   WorkResources.searchByDistrict({id:id}, function(response){
        //     $scope.worksFound = response.content;
        //     $scope.workerLength = $scope.worksFound.length;
        //     $scope.bestWorkers = _.first($scope.worksFound, 1);
        //     $scope.otherWorkers = _.last($scope.worksFound, $scope.workerLength - 1);
        //   },function(error){
        //     console.log(error);
        //     NotificationService.error("No se pudo realizar la busqueda");
        //   })
        // };

      }
      console.log($routeParams.hash);
      console.log("Helper");
      // LoginResources.get($routeParams.email, function (response) {
      //     NotificationService.success('lalala')
      // }, function (error) {
      //     NotificationService.error('lalala')
      // });

    }]);
