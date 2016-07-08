/**
 * Created by redbee on 01/07/16.
 */
'use strict';


angular.module('dutymap')
  .controller('QualifyUserCtrl', ['$scope','QualifyResources','NotificationService','$location',
    function ($scope , QualifyResources,NotificationService,$location) {

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
          'id_provider': 1,
          'review_text': $scope.review_text
        };

          QualifyResources.save(calificar, function(){
          NotificationService.success('Se ha calificado correctamente al proveedor.');
          $location.url('/perfil/{{id}}')
        }, function(error){
          NotificationService.error(error);
        });

      };
      $scope.calcularRating= function(){
        $scope.resultRating = Math.round(($scope.rating1 + $scope.rating2 + $scope.rating3 + $scope.rating4)/4);
      };

    }]);
