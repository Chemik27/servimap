/**
 * Created by tino on 15/06/2016.
 */
'use strict';

angular.module('dutymap')
  .factory('RegisterResources', ['$resource',
    function RegisterResources($resource) {
      var obtenerLocalidades = function() {
        return $resource('api/register/dates', {});
      };


      return {
        localidades: obtenerLocalidades
      };
  }]);

