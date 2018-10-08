'use strict';

angular.module('servimap')
  .factory('ProfileResources', ['$resource',function ProfileResources($resource) {
    return $resource('api/profile/:id', {id:'@id'},{
      getProfile: {method: 'GET', url: 'api/profile/:id', params:{id: '@id'}},      // TODO Verificar si se puede hacer de otra manera sin repetir
    });
  }]);

