/**
 * Created by nico on 30/06/16.
 */
angular.module('dutymap')
  .controller('HireCtrl', ['$scope', '$http' ,'$resource','profileSelected','$rootScope','NotificationService','HireResources', 'NgMap','$location',
    function ($scope, $http, $resource, profileSelected,$rootScope,NotificationService,HireResources, NgMap) {

      //Elimino estilos de modal manualmente cuando redirijo
      $scope.removeModal= function(){
        $('#myModal').modal('hide');
        $('body').removeClass('modal-open');
        $('body').css('padding-right','0px');
        $('.modal-backdrop').remove();
      };

       $scope.profile = profileSelected;
       $scope.toUser = profileSelected.toUser;
       $scope.transactions = profileSelected.lastTransactions;
       $scope.works = profileSelected.works;
       $scope.mainWork = $scope.works[0];


<<<<<<< Updated upstream
      $scope.today=new Date();
      $scope.time = $scope.transactions.agreedDate;
      $scope.confirm=false;
      $scope.domicilio = profileSelected.transaction[0].fromUser.idAddress.street +' '+ profileSelected.transaction[0].fromUser.idAddress.number;
=======
       $scope.today=new Date();
       $scope.unixDate = new Date().getTime();
       $scope.time = $scope.transactions.agreedDate;
       $scope.confirm=false;
>>>>>>> Stashed changes


      $scope.confirmTransaction = function(){
        $scope.dateConfirmation = new Date($scope.date).getTime();

        if($scope.date == undefined)
        {
          NotificationService.error("Debe seleccionar la fecha en la que se concrete el servicio");
          return false;
        }

        if($scope.dateConfirmation  < Date.now()){

          $scope.dateConfirmation = Date.now();
          NotificationService.error("No puede ingresar una fecha pasada");
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
            'idWork': $scope.mainWork.idWork,
            'textProblem':$scope.textProblem,
            'address': $scope.domicilio

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
