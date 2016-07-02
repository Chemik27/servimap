/**
 * Created by redbee on 01/07/16.
 */
'use strict';


angular.module('dutymap')
  .controller('QualifyUserCtrl', ['$scope',
    function ($scope ) {

      $scope.rating = 5;
      $scope.rateFunction = function(rating) {
        alert('Rating selected - ' + rating);
      }
    }]);
