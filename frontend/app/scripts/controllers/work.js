'use strict';

/**
 * @ngdoc function
 * @name tpfinal.controller:HomeCtrl
 * @description
 * # HomeCtrl
 * Controller of the dutymap
 */
angular.module('dutymap')
    .controller('WorkCtrl', ['$scope', '$routeParams', 'WorkResources','works',
        function ($scope, $routeParams, WorkResources, works) {
            $scope.worksFound = works;
            if($routeParams.serviceRequest != null)
                $scope.toFind = $routeParams.serviceRequest;


    }]);
