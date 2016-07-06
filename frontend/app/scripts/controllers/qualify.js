/**
 * Created by redbee on 01/07/16.
 */
angular.module('dutymap')
  .controller('QualifyUserCtrl', ['$scope','$http','$resource','QualifyResources',
    function ($scope,$http,$resource,QualifyResources) {

      //Calificaciones 4
      $scope.rating1 = 1;
      $scope.rating2 = 1;
      $scope.rating3 = 1;
      $scope.rating4 = 1;
      $scope.resultRating = 0;

      $scope.calificar=[];

      console.log($scope.profile);
      console.log($scope.toUser);

    $scope.addQualify =function(){

      $scope.calificar.push({ 'reliability':$scope.rating1,'performance': $scope.rating2, 'consideration': $scope.rating3, 'recommendation' : $scope.rating4 });

      var Qualify = $resource('api/qualify/create');

      Qualify.save({
        'reliability':$scope.rating1,
        'performance': $scope.rating2,
        'consideration': $scope.rating3,
        'recommendation' : $scope.rating4
      }, function(response){
        console.log(response.message);
        $scope.message = response.message;
      });
      };

      $scope.rateFunction = function(rating) {
        //alert('Rating selected - ' + rating);
      };
      $scope.calcularRating= function(){
        $scope.resultRating = Math.round(($scope.rating1 + $scope.rating2 + $scope.rating3 + $scope.rating4)/4);
      };

    }]);
