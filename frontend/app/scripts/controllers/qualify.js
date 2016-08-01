/**
 * Created by redbee on 01/07/16.
 */
'use strict';


angular.module('dutymap')
  .controller('QualifyCtrl', ['$scope','QualifyResources','NotificationService','$location','profileSelected','$rootScope', '$routeParams',
    function ($scope , QualifyResources,NotificationService,$location,profileSelected,$rootScope, $routeParams) {

      //tomo los datos
      $scope.tran = profileSelected.transaction;

      $scope.profile = profileSelected;
      $scope.user = profileSelected.toUser;
      $scope.mainWork = profileSelected.works[0];
      $scope.fullname= profileSelected.toUser.fullName;
      $scope.transactions = profileSelected.lastTransactions;
      $scope.works = profileSelected.works;
      $scope.jobname = profileSelected.works.description;
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

         QualifyResources.qualifyTransaction($scope.tx.idTransaction, function(){

          },function(error){
           NotificationService.error('Ha ocurrido un error inesperado');
          });

        var calificar = {'reliability': $scope.rating1,
          'performance': $scope.rating2,
          'consideration': $scope.rating3,
          'recommendation': $scope.rating4,
          'idProvider':  $scope.user.idUser ,
          'reviewText': $scope.review_text,
          'generalAverage':  $scope.resultRating,
          'idUser': $rootScope.idUser,
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
