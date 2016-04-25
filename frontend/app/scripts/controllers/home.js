'use strict';

/**
 * @ngdoc function
 * @name tpfinal.controller:HomeCtrl
 * @description
 * # HomeCtrl
 * Controller of the dutymap
 */
angular.module('dutymap')
    .controller('HomeCtrl', ['$scope', '$http' ,
    function ($scope, $http) {

    var url = "/api/services/";
    $http.post(url)
        .success(function(response) {
            $scope.productos = response.content;
        })
        .error(function(error){
            console.log("lpm")
        });

  }]);
