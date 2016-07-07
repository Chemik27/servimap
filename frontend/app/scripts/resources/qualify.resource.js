/**
 * Created by Kari on 03/07/2016.
 */
angular.module('dutymap')
  .factory('QualifyResources', ['$resource',function QualifyResources($resource) {
    return $resource('api/qualify/:id', {id:'@id'},{
      save: { method:'POST', url: 'api/qualify/:id' , params: {id:'@id'}}

    });
  }]);
