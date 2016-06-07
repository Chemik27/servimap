/**
 * Created by tino on 07/06/2016.
 */
/**
 * Created by tino on 02/06/2016.
 */
'use strict';

angular.module('dutymap')
  .factory('AddressResources', ['$resource',function AddressResources($resource) {
    return $resource('api/work/worksByAddress/:idAddress', {idAddress:'@idAddress'},{
      // method: 'GET',
      // url: 'api/work/worksByCategory/:id',
      // isArray : true
    });
  }]);

