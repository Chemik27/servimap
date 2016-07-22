'use strict';

/**
 * @ngdoc function
 * @name tpfinal.controller:HomeCtrl
 * @description
 * # HomeCtrl
 * Controller of the dutymap
 */
angular.module('dutymap')
  .controller('ProfileCtrl', ['$scope', '$http', 'ProfileResources','profileSelected',
          function ($scope, $http, ProfileResources, profileSelected) {
            $scope.profile = profileSelected;
            $scope.user = profileSelected.user;
            $scope.myTransactions = profileSelected.lastTransactions;
            $scope.myServiceHistory = profileSelected.transactions;
            $scope.works = profileSelected.works;
            $scope.mainWork = $scope.works[0];
            $scope.today = new Date();


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

    }]);
