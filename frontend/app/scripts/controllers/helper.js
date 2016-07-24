'use strict';

angular.module('dutymap')
  .controller('HelperCtrl', ['$scope', '$http', 'LoginResources','responsePassword',
    function ($scope, $http, LoginResources, responsePassword) {
        console.log("Helper");
        console.log(responsePassword);
    }]);
