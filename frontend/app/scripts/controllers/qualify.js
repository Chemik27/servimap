/**
 * Created by redbee on 01/07/16.
 */
'use strict';


angular.module('dutymap')
  .controller('QualifyUserCtrl', ['$scope','QualifyResources','NotificationService','$location','profileSelected','$rootScope',
    function ($scope , QualifyResources,NotificationService,$location,profileSelected,$rootScope) {

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

        $scope.resultRating = Math.round(($scope.rating1 + $scope.rating2 + $scope.rating3 + $scope.rating4)/4);

        var calificar = {'reliability': $scope.rating1,
          'performance': $scope.rating2,
          'consideration': $scope.rating3,
          'recommendation': $scope.rating4,
          'idProvider':  $scope.toUser.idUser ,
          'reviewText': $scope.review_text,
          'generalAverage':  $scope.resultRating,
          'idUser': $rootScope.idUser,
          'idTransaction': 1
        };

          QualifyResources.save(calificar, function(){
          NotificationService.success('Se ha calificado correctamente al proveedor.');
          $location.url('/perfil/'+ $rootScope.idUser)
        }, function(error){
          NotificationService.error('No se ha podido calificar al proveedor');
        });

      };




    }]);
