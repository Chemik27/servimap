/**
 * Created by redbee on 01/07/16.
 */
angular.module('dutymap')
  .controller('QualifyUserCtrl', ['$scope','$http','QualifyResources','profileSelected',
    function ($scope,$http,QualifyResources,profileSelected) {

      $scope.profile = profileSelected;
      $scope.toUser = profileSelected.toUser;
      $scope.works = profileSelected.works;
      $scope.mainWork = $scope.works[0];
      console.log(profileSelected);
      console.log($scope.profile);

      self.fetchAllUsers = function(){
        HireResources.fetchAllUsers()
          .then(
            function(d) {
              self.users = d;
            },
            function(errResponse){
              console.error('Error while fetching Currencies');
            }
          );
      };

      self.createUser = function(user){
        HireResources.createUser(user)
          .then(
            self.fetchAllUsers,
            function(errResponse){
              console.error('Error while creating User.');
            }
          );
      };

      $scope.confirmTransaction =function(transaction){

        console.log(transaction);
      };

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
