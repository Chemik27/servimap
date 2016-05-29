/**
 * Created by nico on 27/05/16.
 */
angular.module('dutymap')
  .controller('RegisterCtrl', ['$scope', '$http' ,
    function ($scope, $http) {

      var url = "/api/services/";
      $http.post(url)
        .success(function(response) {
          $scope.productos = response.content;
        })
        .error(function(error){
          console.log("lpm")
        });

    }]);
