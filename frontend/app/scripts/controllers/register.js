'use strict';

angular.module('dutymap')
    .controller('RegisterCtrl', ['$scope', '$http', 'UserResources', 'NotificationService', '$location', 'WorkResources','$rootScope',
    function ($scope, $http, UserResources, NotificationService, $location, WorkResources,$rootScope) {

        $scope.onlyNumbers= /^\d+$/;
        $scope.document=/^(\d{8})$/;

        $scope.onlyChar=/^[a-zA-Z-\u00C0-\u017F,]+(\s{0,1}[a-zA-Z-\u00C0-\u017F, ])*$/;
        $scope.charAndNumbers=/^[A-Za-z0-9 _]*[A-Za-z0-9][A-Za-z0-9 _]*$/;
        $scope.charAndNumbersNoSpace=/^\S[a-z\S]*$/
        $scope.passwordRegex=/^(?=.*[a-z])(?=.*\d)[a-zA-Z\d]{8,}$/;
        $scope.replicate = '';
        $scope.provider={};
        $scope.work = {};
        $scope.confirmation=false;
        $scope.userRegister=false;
        $scope.userProveedor=false;
        $scope.createWork = false;
        $scope.validUser = "";

        $scope.saveUser = function(){

          var formData = new FormData();


          var user = {'name':$scope.provider.name,
                        'surname': $scope.provider.surname,
                        'username': $scope.provider.username,
                        'email': $scope.provider.email,
                        'phone': $scope.provider.telephone,
                        'street': $scope.provider.street,
                        'number': $scope.provider.number,
                        'idDistrict': $scope.provider.district.id,
                        'password': $scope.provider.password,
                        'type': $scope.userRegister ? 'comprador' : 'proveedor'}


          formData.append('user', angular.toJson(user,true));
          formData.append('file', file.files[0]);

          $http({
            method: 'POST',
            url: '/api/user/create',
            headers: {'Content-Type': undefined},
            data: formData,
            transformRequest:angular.identity

          }).success(function(response) {
            if(user.type == 'proveedor') {
              NotificationService.success('Se ha registrado correctamente. Ingrese los datos de su servicio.');
              $scope.work.idUser = response.idUser;
              $scope.createWork = true;
              $scope.confirmation=false;
            }else{
              $scope.confirmation=true;
            }
          }).error(function(error) {
              console.log(error);
              NotificationService.error(error.message);
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


        $scope.categories = [
          {id: 1, name: 'Hogar'},
          {id: 2, name: 'Educación'},
          {id: 3, name: 'Salud'},
          {id: 4, name: 'Estética'},
          {id: 5, name: 'Entretenimiento'},
          {id: 6, name: 'Profesional'},
          {id: 7, name: 'Técnico'},
          {id: 8, name: 'Automotriz'},
          {id: 9, name: 'Otros'}
        ];

        $scope.userType = function(type) {
            $scope.filter = type;
        };

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
          $scope.confirmation=false;
          $scope.createWork=false;
        };

        $scope.saveWork = function(){
            var newWork = {
              'name':$scope.work.name,
              'idUser': $scope.work.idUser == null ? $rootScope.idUser: $scope.work.idUser,
              'description': $scope.work.description,
              'idCategory': $scope.work.category != '' && $scope.work.category != undefined ? $scope.work.category.id : null,
              'price': $scope.work.price,
              'street': $scope.work.street,
              'number': $scope.work.number,
              'typeAddress' : $scope.replicate,
              'idDistrict': $scope.work.district != '' && $scope.work.district != undefined ? $scope.work.district.id : null};

            WorkResources.save(newWork, function(){
              //NotificationService.success('Ha creado un servicio correctamente.');
              //$location.url('/register')

              $scope.confirmation=true;
            }, function(error){
              console.log()
              NotificationService.error(error);
            });
        };

        $(document).on('change', ':file', function() {
            var input = $(this),
              numFiles = input.get(0).files ? input.get(0).files.length : 1,
              label = input.val().replace(/\\/g, '/').replace(/.*\//, '');
              input.trigger('fileselect', [numFiles, label]);
        });

        $(document).ready( function() {
            $(':file').on('fileselect', function(event, numFiles, label) {

              var input = $(this).parents('.input-group').find(':text'),
                log = numFiles > 1 ? numFiles + ' files selected' : label;

              if( input.length ) {
                input.val(log);
              } else {
                if( log ) alert(log);
              }

            });
        });


    }]);


