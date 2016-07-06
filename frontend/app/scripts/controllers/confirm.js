/**
 * Created by nico on 30/06/16.
 */
angular.module('dutymap')
  .controller('ConfirmCtrl', ['$scope', '$http','NotificationService','$resource',
    function ($scope, $http, NotificationService,$resource) {



      $scope.transactions=[

      ];

      $scope.confirmTransaction =function(){
        $scope.transactions.push({

          creation_date:new Date(),
          comment:'asd',
          toUser:1,
          fromUser:1,
          idState:3
        });
        var Transaction = $resource('/api/confirm');


        Transaction.save({
          'creation_date': new Date(),
          'comment': 'asd',
          'toUser': 1,
          'fromUser': 1,
          'idState': 3
        }, function(response){
          console.log(response.message);
          $scope.message = response.message;
        });

      };

      $scope.saveUser = function(){
        console.log($scope.provider.password);
        $scope.users.push({ 'name':$scope.provider.firstName, 'surname': $scope.provider.surName, 'email' : $scope.provider.email, 'phone': $scope.provider.telephone});

        var User = $resource('/api/register/create');

        User.save({ 'name':$scope.provider.firstName,
          'surname': $scope.provider.surName,
          'email': $scope.provider.email,
          'phone': $scope.provider.telephone,
          'dni': $scope.provider.document,
          'password': $scope.provider.password,
          'version': "0"}, function(response){
          console.log(response.message);
          $scope.message = response.message;
        });
      }



    }]);
