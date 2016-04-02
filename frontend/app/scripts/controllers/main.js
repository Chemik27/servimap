'use strict';

/**
 * @ngdoc function
 * @name tpfinal.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the tpfinal
 */
angular.module('tpfinal')
  .controller('MainCtrl', ['$scope', '$http' ,function ($scope, $http) {

    var url = "/api/services/";
    $http.post(url)
      .success(function(response) {
        $scope.productos = response.content;
      })
      .error(function(error){
        console.log("lpm")
      });

  }]);
