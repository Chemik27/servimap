/**
 * Created by nico on 30/06/16.
 */
angular.module('dutymap')
  .controller('HireCtrl', ['$scope', '$http' ,'$resource','profileSelected','$rootScope','NotificationService','HireResources', 'NgMap',
    function ($scope, $http, $resource, profileSelected,$rootScope,NotificationService,HireResources, NgMap) {

       $scope.profile = profileSelected;
       $scope.toUser = profileSelected.toUser;
       $scope.transactions = profileSelected.lastTransactions;
       $scope.works = profileSelected.works;
       $scope.mainWork = $scope.works[0];


      $scope.today=new Date();
      $scope.time = $scope.transactions.agreedDate;
      $scope.confirm=false;


      $scope.confirmTransaction = function(){

        if($scope.transaction == null) {
          NotificationService.error('Debe indicar el dia a contratar');
        }
        HireResources.save({
          'toUser':$scope.toUser.idUser,
          'fromUser': $rootScope.idUser,
          'agreedDate': $scope.transaction.agreedDate,
          'done':false
        }
        , function(response){
          $scope.confirm=true;
        },function(error){
          NotificationService.error("Se ha producido un error en la transacción, intentá de nuevo o contactanos")
        });
      };

      NgMap.getMap().then(function(map) {
        console.log(map.getCenter());
        console.log('markers', map.markers);
        console.log('shapes', map.shapes);
      });

    }]);
