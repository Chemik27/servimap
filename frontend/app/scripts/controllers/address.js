'use strict';

/**
 * @ngdoc function
 * @name tpfinal.controller:HomeCtrl
 * @description
 * # HomeCtrl
 * Controller of the dutymap
 */
angular.module('dutymap')
  .controller('AddressCtrl', ['$scope', '$http', 'AddressResources','addressSelected',
    function ($scope, $http, AddressResources, addressSelected) {
      console.log("Controller");
      $scope.lala = addressSelected;
      console.log($scope.lala);

    }]);
