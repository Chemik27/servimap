/**
 * Created by nico on 27/05/16.
 */
angular.module('dutymap')
  .controller('RegisterCtrl', ['$scope', '$http' , function ($scope, $http) {

    $scope.userType = function(type) {

      $scope.filter = type;

    };

    $scope.onlyNumbers= /^\d+$/;
    $scope.onlyChar=/^[a-zA-Z-,]+(\s{0,1}[a-zA-Z-, ])*$/
    //^[A-Za-z']+( [A-Za-z']+)*$/;
    $scope.user={};


    $scope.userForm=function(user){
     /* if($scope.registerForm.cellphone.$pristine) {
        alert("usuario");
      }

      */
      if(user.password == user.passwordConfirmation){
        alert("bien");
      }
      else{
        return;
      }
      console.log(user);


   formData = $scope.registerForm;
      console.log(formData);


     /*if($scope.filter == 'user'){
          if($scope.registerForm.firstName.$valid){
            alert("usuario");
          }
      }
      if($scope.filter == 'provider'){
        if($scope.registerForm.cellphone.$valid){
          alert("proveedor");
        }
      }

*/
    }

    $scope.providerRegister =function(){
      alert("proveedor")
    }

    }]);

