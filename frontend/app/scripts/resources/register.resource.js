/**
 * Created by tino on 15/06/2016.
 */
'use strict';

angular.module('dutymap')
  .factory('RegisterResources', ['$resource',function RegisterResources($resource) {
    return $resource('api/register/dates', {},{
      // method: 'GET',
      // url: 'api/work/worksByCategory/:id',
      // isArray : true
    });
  }]);