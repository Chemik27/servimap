/**
 * Created by nico on 27/05/16.
 */
angular.module('dutymap')
  .controller('RegisterCtrl', ['$scope', '$http' , 'RegisterResources', 'addresses',
    function ($scope, $http, RegisterResources, addresses) {

    $scope.addreses = addresses;

    // $scope.userType = function(type) {
    //
    //   $scope.filter = type;
    //
    // };
    //
    // $scope.onlyNumbers= /^\d+$/;
    // $scope.onlyChar= /^[A-z]+$/;
    //
    // $scope.user={};
    //
    // $scope.validateForm=function(){
    //   alert("sdfsdf");
    //
    // }

    }]);

