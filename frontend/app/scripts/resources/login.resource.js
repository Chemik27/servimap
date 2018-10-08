'use strict';

angular.module('servimap')
  .factory('LoginResources', ['$resource',function LoginResources($resource) {

        return $resource('/api/login/recoverPassword/:email', {email:'@email'},{
          recover: {method: 'POST', url: 'api/login/recoverPassword'},
          updatePassword: {method: 'POST', url: 'api/login/changePassword'}
        });
      }]);
