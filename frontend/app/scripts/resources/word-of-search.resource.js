/**
 * Created by tino on 07/06/2016.
 */
/**
 * Created by tino on 02/06/2016.
 */
'use strict';

angular.module('dutymap')
  .factory('WordOfSearchResources', ['$resource',function WordOfSearchResources($resource) {
    return $resource('api/work/worksByWordOfSearch/:wordOfSearchTyped', {wordOfSearchTyped:'@wordOfSearchTyped'},{
      // method: 'GET',
      // url: 'api/work/worksByCategory/:id',
      // isArray : true
    });
  }]);

