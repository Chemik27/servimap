'use strict';

/**
 * @ngdoc function
 * @name tpfinal.controller:HomeCtrl
 * @description
 * # HomeCtrl
 * Controller of the dutymap
 */
angular.module('dutymap')
  .controller('WordOfSearchCtrl', ['$scope', '$http', 'WordOfSearchResources','wordOfSearchTyped',
    function ($scope, $http, WordOfSearchResources, wordOfSearchTyped) {
      $scope.lala = wordOfSearchTyped;
    }]);
