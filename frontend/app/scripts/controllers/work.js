'use strict';

/**
 * @ngdoc function
 * @name tpfinal.controller:HomeCtrl
 * @description
 * # HomeCtrl
 * Controller of the dutymap
 */
angular.module('dutymap')
  .controller('WorkCtrl', ['$scope', '$http', '$resource', 'WorkResources',
    function ($scope, $http, $resource, WorkResources) {

      var lala = WorkResources.lala();
      $scope.lala = lala.query();


    }]);
