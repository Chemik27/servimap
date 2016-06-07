/**
 * Created by nico on 27/05/16.
 */
angular.module('dutymap')
  .controller('RegisterCtrl', ['$scope', '$http' , function ($scope, $http) {

    $scope.userType = function(type) {

      $scope.filter = type;

    };

    $scope.onlyNumbers= /^\d+$/;
    $scope.onlyChar= /^[A-z]+$/;

    $scope.user={};

    $scope.validateForm=function(){

      if($scope.filter == 'user'){
          if($scope.registerForm.firstName.$valid){
            alert("usuario");
          }
      }
      if($scope.filter == 'provider'){
        if($scope.registerForm.cellphone.$valid){
          alert("proveedor");
        }
      }

    }

    }]);

