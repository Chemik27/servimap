/**
 * Created by tino on 02/06/2016.
 */
'use strict';

angular.module('dutymap')
  .factory('WorkResources', ['$resource',function WorkResources($resource) {
    return $resource('api/work/worksByCategory/:idCategory', {idCategory:'@idCategory'},{
    });
  }]);
