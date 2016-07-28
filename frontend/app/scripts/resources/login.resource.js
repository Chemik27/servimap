'use strict';

angular.module('dutymap')
  .factory('LoginResources', ['$route',function LoginResources($route) {
    console.log($route.current.params.email);
    return {
      sendEmail : function($route, $resource){
        return $resource('/api/login/recoverPassword/:email', {email: $route.current.params.email});
      }
    };
  }]);
