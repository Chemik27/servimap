/**
 * Created by nico on 30/06/16.
 */
angular.module('dutymap')
  .controller('HireCtrl', ['$scope', '$http' ,'HireResources','profileSelected',
    function ($scope, $http, HireResources, profileSelected) {
   
      $scope.today = new Date();
      $scope.confirmation={};

      $scope.confirmService =function(confirmation){

        console.log(confirmation);
      };
      $scope.profile = profileSelected;
      $scope.toUser = profileSelected.toUser;
      $scope.works = profileSelected.works;
      $scope.mainWork = $scope.works[0];

      console.log($scope.profile);
    }]);
