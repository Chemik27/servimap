angular.module('dutymap')
  .factory('HireResources', ['$resource',function HireResources($resource) {
    return $resource('api/hire/:id', {id:'@id'},{

      save: { method:'POST', url: 'api/hire/create'},
      getTransaction: { method:'GET', url: 'api/hire/transaction/:idTrx'},
      acceptTransaction: {method:'PUT', url: 'api/hire/accept/:idTrx'},
      rejectTransaction: {method:'PUT', url: 'api/hire/reject/:idTrx'},
      finishTransaction: {method:'PUT', url: 'api/hire/finish/:idTrx'}

    });
  }]);
