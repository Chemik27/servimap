/**
 * Created by nico on 27/05/16.
 */

'use strict';


angular.module('dutymap')
  .controller('RegisterCtrl', ['$scope', '$http' , 'RegisterResources', '$resource',
    function ($scope, $http, RegisterResources, $resource) {

      /**
       * GUARDA EL USUARIO
       */
      $scope.users = [

      ];

      $scope.saveUser = function(){
        console.log($scope.provider.password);
        $scope.users.push({ 'name':$scope.provider.firstName, 'surname': $scope.provider.surName, 'email' : $scope.provider.email, 'phone': $scope.provider.telephone});

        var User = $resource('/api/register/create');

        User.save({ 'name':$scope.provider.firstName,
                    'surname': $scope.provider.surName,
                    'email': $scope.provider.email,
                    'phone': $scope.provider.telephone,
                    'dni': $scope.provider.document,
                    'password': $scope.provider.password,
                    'version': "0"}, function(response){
                      console.log(response.message);
                      $scope.message = response.message;
        });
      }

      var localidades = RegisterResources.localidades();
      $scope.localidades = localidades.query();
      

      $scope.zonas = [];
      //$scope.zonas = {id:[],descripcion:[]};
      var descripcion2 = [];

      //$scope.zonas = $scope.addreses.district;

      angular.forEach($scope.localidades, function(value, key){
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


