/**
 * Created by Chemik on 28/07/2016.
 */
'use strict';


angular.module('dutymap')
  .controller('QualifyUserCtrl', ['$scope','QualifyResources','NotificationService','$location','profileSelected','$rootScope', '$routeParams',
    function ($scope , QualifyResources,NotificationService,$location,profileSelected,$rootScope, $routeParams) {
      var idUserCalificar;
      //tomo los datos
      $scope.tran = profileSelected.transaction;

      $scope.profile = profileSelected;
      $scope.user = profileSelected.tx.fromUser;
      $scope.toUser = profileSelected.toUser;
      $scope.fromUser = profileSelected.fromUser;

      if($rootScope.idUser == $scope.user.idUser){
        idUserCalificar = $scope.fromUser.idUser;
      }else{
        idUserCalificar = $scope.user.idUser;
      }
      $scope.fullname= profileSelected.tx.fromUser.fullName;
      $scope.transactions = profileSelected.lastTransactions;
      $scope.rating = profileSelected.rating;
      $scope.tx = profileSelected.tx;
      //Calificaciones 4
      $scope.rating1 = 1;
      $scope.rating2 = 1;
      $scope.rating3 = 1;
      $scope.rating4 = 1;
      $scope.resultRating = 0;
      $scope.review_text="";

      $scope.rateFunction = function(rating) {
        //alert('Rating selected - ' + rating);
      };
      $scope.calificacion={};


      $scope.addQualify = function(){

        var calificar = {'reliability': $scope.rating1,
          'performance': $scope.rating2,
          'consideration': $scope.rating3,
          'recommendation': $scope.rating4,
          'idProvider':  idUserCalificar,
          'reviewText': $scope.review_text,
          'generalAverage':  $scope.resultRating,
          'idUser': $scope.user.idUser,
          'idTransaction': $routeParams.idTrx
        };

        QualifyResources.save(calificar, function(){
          NotificationService.success('Se ha calificado correctamente al proveedor.');
          $location.url('/perfil/'+ $rootScope.idUser)
        }, function(error){
          NotificationService.error('No se ha podido calificar al proveedor');
        });
        $scope.resultRating = Math.round(($scope.rating1 + $scope.rating2 + $scope.rating3 + $scope.rating4)/4);





      };




    }]);
