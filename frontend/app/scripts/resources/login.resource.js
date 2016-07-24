'use strict';

angular.module('dutymap')
  .factory('LoginResources', ['$resource',function LoginResources($resource) {
    return $resource('/api/login/recoverPassword/:email');
  }]);
