'use strict';

angular.module('dutymap')
  .factory('ProfileResources', ['$resource',function ProfileResources($resource) {
    return $resource('api/profile/:id', {id:'@id'},{
      getProfile: {method: 'GET', url: 'api/profile/:id', params:{id: '@id'}},      // TODO Verificar si se puede hacer de otra manera sin repetir
      update:{method: 'PUT', url: 'api/profile/update/:id', params:{id: '@id'}}
    });
  }]);

