/**
 * Created by nico on 27/05/16.
 */
angular.module('dutymap')
  .controller('RegisterCtrl', ['$scope', '$http' , 'RegisterResources', 'addresses',
    function ($scope, $http, RegisterResources, addresses) {

    $scope.addreses = addresses;
    $scope.zonas = [];
    //$scope.zonas = {id:[],descripcion:[]};
    var descripcion2 = [];

     //$scope.zonas = $scope.addreses.district;

      angular.forEach($scope.addreses, function(value, key){
        $scope.zonas.push(value.district);
      });


    $scope.userType = function(type) {

      $scope.filter = type;
    };

    $('#pass, #cpass').on('keyup', function () {
      if ($('#pass').val() == $('#cpass').val()) {
        $scope.providerForm.passwordConfirmation.$setValidity('noMatchea', true);
       }
      else
        $scope.providerForm.passwordConfirmation.$setValidity('noMatchea', false);
    });

    $scope.onlyNumbers= /^\d+$/;
    $scope.document=/^(\d{8})$/;
    $scope.onlyChar=/^[a-zA-Z-,]+(\s{0,1}[a-zA-Z-, ])*$/;
    $scope.charAndNumbers=/^[A-Za-z0-9 _]*[A-Za-z0-9][A-Za-z0-9 _]*$/;

    // al menos una letra, un número y 8 caracteres
    $scope.passwordRegex=/^(?=.*[a-z])(?=.*\d)[a-zA-Z\d]{8,}$/;

    $scope.user={};
    $scope.provider={};
      
      $scope.userRegister=false;

      $scope.tipoUsuario=function(){
        $scope.userRegister=true;
        $scope.userProveedor=false;
      };

      $scope.userProveedor=false;

      $scope.tipoProveedor=function(){
        $scope.userRegister=false;
        $scope.userProveedor=true;
      };


      $scope.registerUser=function(user){
      console.log(user);
    };

    $scope.registerProvider =function(provider){
      console.log(provider);
    }
    }]);

