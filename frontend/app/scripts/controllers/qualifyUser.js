/**
 * Created by redbee on 25/07/16.
 */
'use strict';


angular.module('dutymap')
  .controller('QualifyUserCtrl', ['$scope','QualifyUserResources','NotificationService','$location','profileSelected','$rootScope', '$routeParams',
    function ($scope , QualifyUserResources,NotificationService,$location,profileSelected,$rootScope, $routeParams) {



      //tomo los datos
      $scope.tran = profileSelected.transaction;
      $scope.profile = profileSelected;
      $scope.user = profileSelected.toUser;
      $scope.rating = profileSelected.rating;
      $scope.tx = profileSelected.tx;

      //Calificaciones 4
      $scope.rating1 = 1;
      $scope.rating2 = 1;
      $scope.rating3 = 1;
      $scope.rating4 = 1;
      $scope.resultRating = 0;
      $scope.review_text="";




      $scope.addQualifyUser = function(){

        $scope.resultRating = Math.round(($scope.rating1 + $scope.rating2 + $scope.rating3 + $scope.rating4)/4);

        var calificar = {'reliability': $scope.rating1,
          'performance': $scope.rating2,
          'consideration': $scope.rating3,
          'recommendation': $scope.rating4,
          'idProvider':  $rootScope.idUser,
          'reviewText': $scope.review_text,
          'generalAverage':  $scope.resultRating,
          'idUser':$scope.user.idUser ,
          'idTransaction': $routeParams.idTrx
        };

        QualifyUserResources.save(calificar, function(){
          NotificationService.success('Se ha calificado correctamente al cliente.');
          $location.url('/perfil/'+ $rootScope.idUser)
        }, function(error){
          NotificationService.error('No se ha podido calificar al cliente');
        });

      };


    }]);
