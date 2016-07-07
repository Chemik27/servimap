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
                        //'username': $scope.provider.username,
                        'email': $scope.provider.email,
                        'phone': $scope.provider.telephone,
                        'dni': $scope.provider.document,
                        'password': $scope.provider.password};

            UserResources.save(user, function(){
                NotificationService.success('Se ha registrado correctamente. Inicie sesión.');
                $location.url('/login')
            }, function(error){
                NotificationService.error(error);
            });
        };

        $scope.zonas = [{idDistrict: 1, name: "asd"}];

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
    }]);


