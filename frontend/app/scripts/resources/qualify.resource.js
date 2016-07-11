/**
 * Created by redbee on 08/07/16.
 */

angular.module('dutymap')
  .factory('QualifyResources', ['$resource',function QualifyResources($resource) {
    return $resource('api/qualify/:idtransaction', {idtransaction:'@idtransaction'}, {
      save:{method: "POST", url: "api/qualify/save"}
    });
  }]);
