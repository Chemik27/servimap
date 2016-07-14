'use strict';

/**
 * @ngdoc function
 * @name tpfinal.controller:HomeCtrl
 * @description
 * # HomeCtrl
 * Controller of the dutymap
 */
angular.module('dutymap')
  .controller('ProfileCtrl', ['$scope', '$http', 'ProfileResources', '$rootScope', 'NotificationService', '$location',
        function ($scope, $http, ProfileResources, $rootScope, NotificationService, $location) {
              var id = null;
              if($rootScope.idProvider == undefined || $rootScope.idProvider == null){
                  id = angular.fromJson(sessionStorage.userService);
              }else{
                  id = $rootScope.idProvider;
              }


            ProfileResources.getProfile({id:id}, function(response){
              var profileSelected = response;
              $scope.profile = profileSelected;
              $scope.user = profileSelected.user;
              $scope.transactions = profileSelected.lastTransactions;
              //$scope.transaciones = profileSelected.transactions;
              $scope.works = profileSelected.works;
              $scope.mainWork = $scope.works[0];
              $scope.rating = profileSelected.rating;


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

            },function(error){
              console.log(error);
              NotificationService.error("");
            });

            $scope.saveIdProvider = function(id){
              $rootScope.idProvider = id;
              $location.path("/perfil");
            };

            ProfileResources.getProfile(id);
            $rootScope.idProvider = null;

    }]);
