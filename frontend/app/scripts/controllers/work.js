'use strict';

/**
 * @ngdoc function
 * @name tpfinal.controller:HomeCtrl
 * @description
 * # HomeCtrl
 * Controller of the dutymap
 */
angular.module('dutymap')
    .controller('WorkCtrl', ['$scope', '$routeParams', 'WorkResources','works', '$location',
        function ($scope, $routeParams, WorkResources, works, $location) {

            $scope.worksFound = works;
            $scope.filter = {};

            if($routeParams.serviceRequest != null)
                $scope.toFind = $routeParams.serviceRequest;

            $scope.search = function(){
              $scope.filter.page = 1;
              $location.search($scope.filter);
            }


    }]);
