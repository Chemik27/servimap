angular.module('dutymap')
  .factory('HireResources', ['$resource',function HireResources($resource) {
    return $resource('api/hire/:id', {id:'@id'},{

      save: { method:'POST', url: 'api/hire/create'},
      getTransaction: { method:'GET', url: 'api/hire/transaction/:idTrx'}

    });
  }]);
