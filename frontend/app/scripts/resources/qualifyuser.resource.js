/**
 * Created by Chemik on 27/07/2016.
 */
angular.module('dutymap')
  .factory('QualifyUserResources', ['$resource',function QualifyUserResources($resource) {
    return $resource('api/qualifyuser/:idtransaction', {idtransaction:'@idtransaction'}, {
      save:{method: "POST", url: "api/qualifyuser/save"}
    });
  }]);
