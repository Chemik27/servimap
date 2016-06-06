/**
 * Created by nico on 27/05/16.
 */
angular.module('dutymap',[])
  .controller('RegisterCtrl', ['$scope', '$http' , function ($scope, $http) {

    $scope.userType = function(type) {

      $scope.filter = type;

    };

    $scope.onlyNumbers= /^\d+$/;
    $scope.onlyChar= /^[A-z]+$/;

    $scope.user={};

    $scope.validateForm=function(){
      alert("sdfsdf");

    }

    }]);

