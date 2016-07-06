angular.module('dutymap')
  .factory('HireResources', ['$resource',function HireResources($resource) {
    return $resource('api/hire/:id', {id:'@id'},{

      save: { method:'POST', url: 'api/hire/:id' , params: {id:'@id'}}

    });
  }]);



//$scope.tx = {
//      idUser : $scope.lala,
//
//}
//

