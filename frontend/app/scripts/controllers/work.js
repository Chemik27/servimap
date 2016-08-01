'use strict';

/**
 * @ngdoc function
 * @name tpfinal.controller:HomeCtrl
 * @description
 * # HomeCtrl
 * Controller of the dutymap
 */
angular.module('dutymap')
    .controller('WorkCtrl', ['$scope', '$routeParams', 'WorkResources','works', 'NotificationService','ProfileResources', 'NgMap',
        function ($scope, $routeParams, WorkResources, works, NotificationService, ProfileResources, NgMap) {

            $scope.worksFound = works.content;
            $scope.workerLength = $scope.worksFound.length;
            $scope.bestWorkers = _.first($scope.worksFound, 3);
            $scope.otherWorkers = _.last($scope.worksFound, $scope.workerLength - 3);


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
              {id:1, name: 'Hogar'},
              {id:2, name: 'Educación'},
              {id:3, name: 'Salud'},
              {id:4, name: 'Estética'},
              {id:5, name: 'Entretenimiento'},
              {id:6, name: 'Profesional'},
              {id:7, name: 'Técnico'},
              {id:8, name: 'Automotriz'},
              {id:9, name: 'Otros'}

            ];


            if($routeParams.serviceRequest != null)
                $scope.toFind = $routeParams.serviceRequest;

            $scope.searchByDistrict = function(id){
                WorkResources.searchByDistrict({id:id}, function(response){
                    $scope.worksFound = response.content;
                    $scope.workerLength = $scope.worksFound.length;
                  $scope.bestWorkers = _.first($scope.worksFound, 3);
                  $scope.otherWorkers = _.last($scope.worksFound, $scope.workerLength - 3);
                },function(error){
                    console.log(error);
                    NotificationService.error("No se pudo realizar la busqueda");
                })
            };

            $scope.searchByCategory = function(id){
                WorkResources.searchByCategory({id:id}, function(response){
                    $scope.worksFound = response.content;
                    $scope.workerLength = $scope.worksFound.length;
                    $scope.bestWorkers = _.first($scope.worksFound, 3);
                    $scope.otherWorkers = _.last($scope.worksFound, $scope.workerLength - 3);
                },function(error){
                    console.log(error);
                    NotificationService.error("No se pudo realizar la busqueda");
                })
            };


          NgMap.getMap().then(function(map) {
            $scope.map = map;
          });

          $scope.showCity = function(event, marker) {
            console.log(marker);
            $scope.worker = marker;
            $scope.map.showInfoWindow('myInfoWindow', this);
          };


        }]);
