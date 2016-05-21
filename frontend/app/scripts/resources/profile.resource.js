'use strict';

angular.module('dutymap')
    .factory('ProfileResources', ['$resource',function ProfileResources($resource) {
        return $resource('api/profile/:id', {id:'@id'},{
            //TODO: Crear los resources necesarios para profile
    });
  }]);
