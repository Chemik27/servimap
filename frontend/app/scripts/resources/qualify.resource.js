/**
 * Created by redbee on 08/07/16.
 */

angular.module('dutymap')
  .factory('QualifyResources', ['$resource',function QualifyResources($resource) {
    return $resource('api/qualify/:idUser', {idUser:'@idUser'}, {
      save:{method: "POST", url: "api/qualify/save"}
      
    });
  }]);
