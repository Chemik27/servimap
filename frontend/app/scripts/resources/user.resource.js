'use strict';

angular.module('dutymap')
    .factory('UserResources', ['$resource',function UserResources($resource) {
    return $resource('api/user/:idUser', {idUser:'@idUser'}, {
      save:{method: "POST",  url: "api/user/create"},
      update:{method: 'PUT', url: "api/user/update"}
    });
  }]);
