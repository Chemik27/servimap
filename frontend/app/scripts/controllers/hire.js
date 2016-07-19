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
        if($scope.date == undefined)
        {
          NotificationService.error("Debe seleccionar la fecha en la que se concrete el servicio");
          return false;
        }

        if($rootScope.idUser != undefined){
          if($rootScope.idUser == $scope.toUser.idUser){
            NotificationService.error("No puede contratar su propio servicio");
            return false;
          }
          var time = $scope.date;
          time = time + ':00';

          HireResources.save({
            'creationDate': new Date(),
            'toUser':$scope.toUser.idUser,
            'fromUser': $rootScope.idUser,
            'agreedDate': new Date(time),
            'done':false,
            'idWork': $scope.mainWork.idWork
          }, function(response){
            $scope.confirm=true;
          },function(error){
            NotificationService.error("Se ha producido un error en la transacción, intentá de nuevo o contactanos")
          });
        }else
            NotificationService.error("Debe loguearse para poder contratar un servicio");

      };

      NgMap.getMap().then(function(map) {
        console.log(map.getCenter());
        console.log('markers', map.markers);
        console.log('shapes', map.shapes);
      });

    }]);
