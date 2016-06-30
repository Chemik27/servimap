'use strict';

/**
 * @ngdoc function
 * @name tpfinal.controller:HomeCtrl
 * @description
 * # HomeCtrl
 * Controller of the dutymap
 */
angular.module('dutymap')
  .controller('WorkCtrl', ['$scope', '$http', 'WorkResources','works',
    function ($scope, $http, WorkResources, works) {
        $scope.worksFound = works;

    }]);
