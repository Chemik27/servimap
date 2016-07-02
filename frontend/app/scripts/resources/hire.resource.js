angular.module('dutymap')
  .factory('HireResources', ['$resource','$q',function HireResources($resource,$q) {
    return $resource('api/hire/:id', {id:'@id'},{

      createTransaction: function(transaction){
        return $http.post('api/hire/:id/confirm',{id:'@id'})
          .then(
            function(response){
              return response.data;
            },
            function(errResponse){
              console.error('Error while creating transaction');
              return $q.reject(errResponse);
            }
          );
      },

    });
  }]);
