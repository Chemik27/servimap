angular.module('dutymap')
  .factory('HireResources', ['$resource',function HireResources($resource) {
    return $resource('api/hire/:id', {id:'@id'},{

      createTransaction: { method:'POST', url: 'api/hire/:id/confirm' , params: {id:'@id'}}

    });
  }]);



//$scope.tx = {
//      idUser : $scope.lala,
//
//}
//
//HireResources.create(tx, function(response){
//  NotificationService.success("salio ok")
//}, function(error){
//  NotificationService.error(error)
//
//})
