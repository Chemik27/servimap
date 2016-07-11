'use strict';

/**
 * @ngdoc function
 * @name tpfinal.controller:HomeCtrl
 * @description
 * # HomeCtrl
 * Controller of the dutymap
 */
angular.module('dutymap')
  .controller('ProfileCtrl', ['$scope', '$http', 'ProfileResources', 'NotificationService',
      function ($scope, $http, ProfileResources, NotificationService) {

          var id = angular.fromJson(sessionStorage.userService);

          ProfileResources.obtainProfile({id:id}, function(response){
            var profileSelected = response;
            $scope.profile = profileSelected;
            $scope.user = profileSelected.user;
            $scope.transactions = profileSelected.lastTransactions;
            $scope.works = profileSelected.works;
            $scope.mainWork = $scope.works[0];

            $scope.starRating = 4; //TODO Hardcodeado agregar a rating y sacar de la variable
            $scope.stars = _.range($scope.starRating);
            $scope.emptyStars = _.range(5 - $scope.starRating);
          },function(error){
            console.log(error);
            NotificationService.error("");
          })

    }]);
