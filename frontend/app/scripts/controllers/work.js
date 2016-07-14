'use strict';

/**
 * @ngdoc function
 * @name tpfinal.controller:HomeCtrl
 * @description
 * # HomeCtrl
 * Controller of the dutymap
 */
angular.module('dutymap')
    .controller('WorkCtrl', ['$scope', '$routeParams', 'WorkResources','works', 'NotificationService','ProfileResources',
        function ($scope, $routeParams, WorkResources, works, NotificationService, ProfileResources) {

            $scope.worksFound = works.content;
            $scope.districts = [
              {id:1 ,name: '20 de Junio'},
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
              {id:1, name: 'Armar set de datos'}
            ];


            if($routeParams.serviceRequest != null)
                $scope.toFind = $routeParams.serviceRequest;

            $scope.searchByDistrict = function(id){
                WorkResources.searchByDistrict({id:id}, function(response){
                    $scope.worksFound = response.content;
                },function(error){
                    console.log(error);
                    NotificationService.error("No se pudo realizar la busqueda");
                })
            };

            $scope.searchByCategory = function(id){
                WorkResources.searchByCategory({id:id}, function(response){
                    $scope.worksFound = response.content;
                },function(error){
                    console.log(error);
                    NotificationService.error("No se pudo realizar la busqueda");
                })
            };

            $scope.goToProfile = function(id){
                ProfileResources
            }

    }]);
