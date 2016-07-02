/**
 * Created by nico on 30/06/16.
 */
angular.module('dutymap')
  .controller('HireCtrl', ['$scope', '$http' ,'HireResources','profileSelected',
    function ($scope, $http, HireResources, profileSelected) {

      $scope.today = new Date();
      var self = this;
      self.transaction={id:null,toUser:'',fromUser:'',agreedDate:''};
      self.transactions=[];

      $scope.profile = profileSelected;
      $scope.toUser = profileSelected.toUser;
      $scope.works = profileSelected.works;
      $scope.mainWork = $scope.works[0];

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

    }]);
