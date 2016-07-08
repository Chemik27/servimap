'use strict';

angular.module('dutymap')
    .controller('RegisterCtrl', ['$scope', '$http', 'UserResources', 'NotificationService', '$location',
    function ($scope, $http, UserResources, NotificationService, $location) {

        $scope.onlyNumbers= /^\d+$/;
        $scope.document=/^(\d{8})$/;
        $scope.onlyChar=/^[a-zA-Z-,]+(\s{0,1}[a-zA-Z-, ])*$/;
        $scope.charAndNumbers=/^[A-Za-z0-9 _]*[A-Za-z0-9][A-Za-z0-9 _]*$/;
        $scope.passwordRegex=/^(?=.*[a-z])(?=.*\d)[a-zA-Z\d]{8,}$/;

        $scope.provider={};

        $scope.userRegister=false;
        $scope.userProveedor=false;

        $scope.saveUser = function(){
            var user = {'name':$scope.provider.name,
                        'surname': $scope.provider.surname,
                        'username': $scope.provider.username,
                        'email': $scope.provider.email,
                        'phone': $scope.provider.telephone,
                        'street': $scope.provider.street,
                        'number': $scope.provider.number,
                        'password': $scope.provider.password,
                        'type': $scope.userRegister ? 'comprador' : 'proveedor'};

            UserResources.save(user, function(){
                NotificationService.success('Se ha registrado correctamente. Inicie sesión.');
                $location.url('/login')
            }, function(error){
                NotificationService.error(error);
            });
        };

        $scope.zonas = [{id:1 ,name: '20 de Junio'},
          {id:2 ,name: 'Aldo Bonzi'},
          {id:3 ,name: 'Ciudad Evita'},
          {id:4 ,name: 'González Catán'},
          {id:5 ,name: 'Gregorio de Laferrere'},
          {id:6 ,name: 'Isidro Casanova'},
          {id:7 ,name: 'La Tablada'},
          {id:8 ,name: 'Lomas del Mirador'},
          {id:9 ,name: 'Rafael Castillo'},
          {id:10 ,name: 'Ramos Mejía'},
          {id:11 ,name: 'San Justo'},
          {id:12 ,name: 'Tapiales'},
          {id:13 ,name: 'Villa Luzuriaga'},
          {id:14 ,name: 'Villa Madero'},
          {id:15 ,name: 'Virrey del Pino'}];

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

        $scope.tipoUsuario=function(){
            $scope.userRegister=true;
            $scope.userProveedor=false;
        };

        $scope.tipoProveedor=function(){
            $scope.userRegister=false;
            $scope.userProveedor=true;
        };

        $scope.back = function(){
          $scope.userRegister=false;
          $scope.userProveedor=false;
        }
    }]);


