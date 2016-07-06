/**
 * Created by nico on 30/06/16.
 */
angular.module('dutymap')
  .controller('HireCtrl', ['$scope', '$http' ,'$resource',
    function ($scope, $http, $resource) {

      // $scope.today = new Date();
      // $scope.profile = profileSelected;
      // $scope.toUser = profileSelected.toUser;
      // $scope.works = profileSelected.works;
      // $scope.mainWork = $scope.works[0];


      $scope.transaction=[

      ];

      $scope.confirmTransaction =function(){

        var Transaction = $resource('api/hire/create');


        Transaction.save({
          'comment': "asd"
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
