/**
 * Created by nico on 30/06/16.
 */
angular.module('servimap')
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


       $scope.today=new Date();
       $scope.time = $scope.transactions.agreedDate;
       $scope.confirm=false;
       $scope.unixDate = new Date().getTime();


      $scope.confirmTransaction = function(){
        $scope.dateConfirmation = new Date($scope.date).getTime();

        if($scope.date == undefined)
        {
          NotificationService.error("Debe seleccionar la fecha en la que se concrete el servicio");
          return false;
        }
        if($scope.textProblem == undefined){
          NotificationService.error("Debe escribir el problema para ayudar al proveedor a decidir si está apto para realizar el trabajo.");
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
      });

    }]);
