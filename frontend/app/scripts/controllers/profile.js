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
          $scope.transactions = profileSelected.lastTransactions;
          $scope.works = profileSelected.works;
          $scope.mainWork = $scope.works[0];



          console.log($scope.profile);

    }]);
