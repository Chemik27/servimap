/**
 * Created by redbee on 01/07/16.
 */
'use strict';


angular.module('dutymap')
  .controller('QualifyUserCtrl', ['$scope',
    function ($scope ) {

      //Calificaciones 4
      $scope.rating1 = 1;
      $scope.rating2 = 1;
      $scope.rating3 = 1;
      $scope.rating4 = 1;
      $scope.resultRating = 0;
      $scope.rateFunction = function(rating) {
        //alert('Rating selected - ' + rating);
      };
      $scope.calcularRating= function(){
        $scope.resultRating = Math.round(($scope.rating1 + $scope.rating2 + $scope.rating3 + $scope.rating4)/4);
      };

    }]);
