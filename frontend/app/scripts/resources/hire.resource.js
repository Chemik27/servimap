angular.module('dutymap')
  .factory('HireResources', ['$resource',function HireResources($resource) {
    return $resource('api/hire/:id', {id:'@id'},{
     
    });
  }]);
