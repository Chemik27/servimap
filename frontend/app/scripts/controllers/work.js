'use strict';

/**
 * @ngdoc function
 * @name tpfinal.controller:HomeCtrl
 * @description
 * # HomeCtrl
 * Controller of the dutymap
 */
angular.module('dutymap')
  .controller('WorkCtrl', ['$scope', '$http', 'WorkResources','categorySelected',
    function ($scope, $http, WorkResources, categorySelected) {

      $scope.lala = categorySelected;
      console.log($scope.lala);

    }]);
