/**
 * Created by tino on 02/06/2016.
 */
'use strict';

angular.module('dutymap')
  .factory('WorkResources', ['$resource', '$routeParams',
    function WorkResources($resource, $routeParams) {
    // return {
    //   lala: $resource('api/work/worksByCategory/:idCategory', {idCategory:'@idCategory'})
    // }
      var method1Logic = function() {
        return $resource('api/work/worksByCategory/:idCategory', {idCategory: $routeParams.idCategory});
      };

      return {
        lala: method1Logic
      };
  }]);

