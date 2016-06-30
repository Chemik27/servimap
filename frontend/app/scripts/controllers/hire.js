/**
 * Created by nico on 30/06/16.
 */
angular.module('dutymap')
  .controller('HireCtrl', ['$scope', '$http' ,'$rootScope', 
    function ($scope, $http, $rootScope) {
      $scope.today = new Date();
      $scope.confirmation={};

      $scope.confirmService =function(confirmation){

        console.log(confirmation);
      }
    }]);
