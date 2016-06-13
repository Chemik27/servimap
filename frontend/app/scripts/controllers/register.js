/**
 * Created by nico on 27/05/16.
 */
angular.module('dutymap')
  .controller('RegisterCtrl', ['$scope', '$http' , function ($scope, $http) {

    $scope.userType = function(type) {

      $scope.filter = type;
    };

    $scope.onlyNumbers= /^\d+$/;
    $scope.document=/^(\d{8})$/;
    $scope.onlyChar=/^[a-zA-Z-,]+(\s{0,1}[a-zA-Z-, ])*$/
    //^[A-Za-z']+( [A-Za-z']+)*$/;

    // al menos una letra, un número y 8 caracteres
    $scope.passwordRegex=/^(?=.*[a-z])(?=.*\d)[a-zA-Z\d]{8,}$/;

    // al menos una mayuscula
    // (?=.*[A-Z])

    $scope.user={};
    $scope.provider={};

    $scope.compare=function(){
      if($scope.provider.password != $scope.provider.passwordConfirmation) {
        $scope.noMatchea = true;
        $scope.providerForm.passwordConfirmation.$setValidity('noMatchea', false);

      }
      else{
        $scope.noMatchea = false;
        $scope.providerForm.passwordConfirmation.$setValidity('noMatchea', true);
      }
    };

    $scope.registerUser=function(user){
      console.log(user);
    };

    $scope.registerProvider =function(provider){
      console.log(provider);
    }
    }]);

