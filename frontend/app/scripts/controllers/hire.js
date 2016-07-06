/**
 * Created by nico on 30/06/16.
 */
angular.module('dutymap')
  .controller('HireCtrl', ['$scope', '$http' ,'HireResources','profileSelected','NotificationService','$resource',
    function ($scope, $http, HireResources, profileSelected, NotificationService,$resource) {

      $scope.today = new Date();
      $scope.profile = profileSelected;
      $scope.toUser = profileSelected.toUser;
      $scope.works = profileSelected.works;
      $scope.mainWork = $scope.works[0];
      // var self = this;
      // self.transaction={id:null,toUser:'',fromUser:'',agreedDate:''};
      // self.transactions=[];

      console.log($scope.profile);

      console.log($scope.toUser);

      $scope.transaction= {

        id_transaction: 5,
        comment: 'asd',
        toUser: $scope.toUser.idUser,
        fromUser: 1,
        idState: 1

        // fromUser: $rootScope.transaction.fromUser.getEma
        // agreedDate: $scope.agreedDate

      };


      console.log($scope.profile);

      console.log($scope.toUser);

      $scope.transaction= {


        // fromUser: $rootScope.transaction.fromUser.getEma
        // agreedDate: $scope.agreedDate

      };

      // self.fetchAllUsers = function(){
      //   HireResources.fetchAllUsers()
      //     .then(
      //       function(d) {
      //         self.users = d;
      //       },
      //       function(errResponse){
      //         console.error('Error while fetching Currencies');
      //       }
      //     );
      // };
      //
      // self.createUser = function(user){
      //   HireResources.createUser(user)
      //     .then(
      //       self.fetchAllUsers,
      //       function(errResponse){
      //         console.error('Error while creating User.');
      //       }
      //     );
      // };

      $scope.transaction=[

      ];

      $scope.confirmTransaction =function(){
        $scope.transaction.push({

          id_transaction:5,
          creation_date:'2016-05-12 15:11:57',
          comment:'asd',
          toUser:1,
          fromUser:1,
          idState:3
        });
        var transaction = $resource('api/hire/:id', {id:'@id'});


        transaction.save({ 'id_transaction':5,
          'creation_date': '2016-05-12 15:11:57',
          'comment': 'asd',
          'toUser': 1,
          'fromUser': 1,
          'idState': 3
        }, function(response){
          console.log(response.message);
          $scope.message = response.message;
        });
      };

      // HireResources.save(transaction, function(response){
      //    NotificationService.success("salio ok")
      //   }, function(error){
      //    NotificationService.error(error)
      //
      // });



    }]);
