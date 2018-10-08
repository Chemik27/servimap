'use strict';

angular.module('servimap')
  .factory('WorkResources', ['$resource',function WorkResources($resource) {
      return $resource('api/work/named/:serviceRequest', {wordOfSearchTyped:'@serviceRequest'},{
          save:{method: "POST", url: "api/work/create"},
          searchByDistrict: {method: 'GET', url: 'api/work/district/:id', params:{id: '@id'}},
          searchByCategory: {method: 'GET', url: 'api/work/category/:id', params:{id: '@id'}},
          update: {method: 'PUT', url: 'api/work/update'}
      });
  }]);
