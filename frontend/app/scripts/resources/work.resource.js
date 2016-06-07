/**
 * Created by tino on 02/06/2016.
 */
'use strict';

angular.module('dutymap')
  .factory('WorkResources', ['$resource',function WorkResources($resource) {
    return $resource('api/work/worksByCategory/:idCategory', {idCategory:'@idCategory'},{
      // method: 'GET',
      // url: 'api/work/worksByCategory/:id',
      // isArray : true
    });
  }]);

// angular.module('dutymap')
//     .factory('WorkResources', ['$resource',function WorkResources($resource) {
//       return{
//         getWorksByCategory : function(){
//           return $http({
//             url: 'api/work/worksByCategory/:id',
//             method: 'GET'
//           })
//         }
//       }
//
//   }]);
// angular.module('dutymap')
//     .factory('WorkResources', ['$resource',
//       function($resource) {
//         return $resource('api/work/worksByCategory/:id', {}, {
//         query: { method:'GET', params:{ doc: undefined }, isArray:true }
//     });
//   }]);

// angular.module('dutymap')
//   .factory('WorkResources', ['$resource',function WorkResources($resource) {
//     return $resource('api/work/worksByCategory/:id', {id:'@id'},{
//       'query': {
//         method: 'GET',
//         url: 'api/work/worksByCategory/:id',
//         isArray : true
//       }
//     });
//   }]);

// angular.module('dutymap')
//   .factory('workResources', ['$resource', '$routeParams', function($resource, $routeParams) {
//     console.log('factory id: ' + $routeParams.id);
//     return{
//       lala: $resource('api/work/worksByCategory/:id', {id:$routeParams.id}, {
//         // query: {
//         //   method: 'GET',
//         //   url: 'api/work/worksByCategory/'+$routeParams.id,
//         //   isArray: true
//         // }
//       })
//     }
//   }]);
