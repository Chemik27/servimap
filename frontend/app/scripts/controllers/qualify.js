/**
 * Created by redbee on 01/07/16.
 */
'use strict';


angular.module('dutymap')
  .controller('QualifyUserCtrl', ['$scope','QualifyResources','NotificationService','$location','ProfileResources',
    function ($scope , QualifyResources,NotificationService,$location,ProfileResources) {

      //tomo los datos
      $scope.profile = ProfileResources;
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
          'id_provider': 1,
          'general_average':  $scope.resultRating,
          'id_user': 1
        };

          QualifyResources.save(calificar, function(){
          NotificationService.success('Se ha calificado correctamente al proveedor.');
          $location.url('/perfil/{{id}}')
        }, function(error){
          NotificationService.error(error);
        });

      };




    }]);
