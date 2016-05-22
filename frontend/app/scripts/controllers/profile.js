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
          $scope.work = profileSelected.work;
          console.log($scope.profile);

    }]);
