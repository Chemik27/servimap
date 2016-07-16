angular.module('dutymap')
  .factory('HireResources', ['$resource',function HireResources($resource) {
    return $resource('api/hire/:idTrx', {id:'@idTrx'},{

      save: { method:'POST', url: 'api/hire/create'}

    });
  }]);
