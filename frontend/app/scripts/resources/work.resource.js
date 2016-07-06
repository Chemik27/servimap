/**
 * Created by tino on 02/06/2016.
 */
'use strict';

angular.module('dutymap')
  .factory('WorkResources', ['$resource',function WorkResources($resource) {
      return $resource('api/work/named/:serviceRequest', {wordOfSearchTyped:'@serviceRequest'},{

          searchByDistrict: {method: 'GET', url: 'api/work/district/:id', params:{id: '@id'}},
          searchByCategory: {method: 'GET', url: 'api/work/category/:id', params:{id: '@id'}}
      });
  }]);
