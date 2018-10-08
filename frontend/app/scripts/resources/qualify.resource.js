/**
 * Created by redbee on 08/07/16.
 */

angular.module('servimap')
  .factory('QualifyResources', ['$resource',function QualifyResources($resource) {
    return $resource('api/qualify/:idtransaction', {idtransaction:'@idtransaction'}, {
      save:{method: "POST", url: "api/qualify/save"},
      qualifyTransaction: {method:'PUT', url: 'api/qualify/proveedor/:idTrx'}
    });
  }]);
