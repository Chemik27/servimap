/**
 * Created by nico on 30/06/16.
 */
angular.module('dutymap')
  .controller('HireCtrl', ['$scope', '$http' ,'$resource','profileSelected','$rootScope','NotificationService','HireResources',
    function ($scope, $http, $resource, profileSelected,$rootScope,NotificationService,HireResources) {

       $scope.profile = profileSelected;
       $scope.toUser = profileSelected.toUser;
       $scope.transactions = profileSelected.lastTransactions;
       $scope.works = profileSelected.works;
       $scope.mainWork = $scope.works[0];

      $scope.today=new Date();
      $scope.time = $scope.transactions.agreedDate;
      $scope.confirm=false;

      $scope.confirmTransaction =function(){

        HireResources.save({
          'toUser':$scope.toUser.idUser,
          'fromUser': $rootScope.idUser,
          'agreedDate': $scope.transaction.agreedDate,
          'done':false
        }, function(response){
          $scope.confirm=true;
        },function(error){
          NotificationService.error("Se ha producido un error en la transacción, intentá de nuevo o contactanos")
        });
      };
    }]);
