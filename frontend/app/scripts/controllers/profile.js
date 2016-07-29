'use strict';

/**
 * @ngdoc function
 * @name tpfinal.controller:HomeCtrl
 * @description
 * # HomeCtrl
 * Controller of the dutymap
 */
angular.module('dutymap')
  .controller('ProfileCtrl', ['$scope', '$http', 'ProfileResources','profileSelected', 'HireResources', 'NotificationService', '$route','$location','QualifyResources',
      function ($scope, $http, ProfileResources, profileSelected, HireResources, NotificationService, $route,$location,QualifyResources) {
            $scope.profile = profileSelected;
            $scope.user = profileSelected.user;
            $scope.myTransactions = profileSelected.lastTransactions;
            $scope.myServiceHistory = profileSelected.transactions;
            $scope.newServices = _.countBy($scope.myServiceHistory, function(serv){
              return serv.state == 1 ? 'newOne' : 'old'
            });
            $scope.works = profileSelected.works;
            $scope.mainWork = $scope.works[0];
            $scope.today = new Date();

            $scope.showSeccion= true;

            if($scope.works==0){
               $scope.showSeccion=false;}


            if(profileSelected.rating != undefined){
                $scope.rating = profileSelected.rating.finalRating;
                $scope.comments = profileSelected.rating.comments;
            }

            if($scope.rating != undefined){

              $scope.generalAverage= Math.round( ($scope.rating.reliability + $scope.rating.performance + $scope.rating.recommendation + $scope.rating.consideration)/4);
              $scope.starRating = $scope.generalAverage;
              $scope.stars = _.range($scope.starRating);
              $scope.emptyStars = _.range(5 - $scope.starRating);
              $scope.starReliability = _.range($scope.rating.reliability);
              $scope.emptyStarsReliability = _.range(5 - $scope.rating.reliability);
              $scope.starPerformance = _.range($scope.rating.performance);
              $scope.emptyStarsPerformance = _.range(5 - $scope.rating.performance);
              $scope.starConsideration = _.range($scope.rating.consideration);
              $scope.emptyStarsConsideration = _.range(5 - $scope.rating.consideration);
              $scope.starRecommendation = _.range($scope.rating.recommendation);
              $scope.emptyStarsRecommendation = _.range(5 - $scope.rating.recommendation);
            }

          $scope.rejectService = function(idTx){
              HireResources.rejectTransaction(idTx, function(){
                NotificationService.success('Se ha actualizado correctamente');
                $route.reload();
              },function(error){
                NotificationService.error('Ha ocurrido un error inesperado');
              })
          };

          $scope.acceptService = function(idTx){
            HireResources.acceptTransaction(idTx, function(){
              NotificationService.success('Se ha actualizado correctamente');
              $route.reload();
            },function(error){
              NotificationService.error('Ha ocurrido un error inesperado');
            })
          };

          $scope.finishService = function(idTx){
            HireResources.finishTransaction(idTx, function(){
              NotificationService.success('Se ha actualizado correctamente');
              $route.reload();
            },function(error){
              NotificationService.error('Ha ocurrido un error inesperado');
            })
          };

         $scope.qualifyService = function(idTx){

            $location.path('/calificar/'+idTx)

        };
        $scope.qualifyUserService = function(idTx){

            $location.path('/calificar/usuario/'+idTx)

        };
    }]);
