'use strict';

angular.module('dutymap')
    .controller('HelperCtrl', ['$scope', '$routeParams', 'LoginResources', 'NotificationService',
    function ($scope, $routeParams, LoginResources, NotificationService) {

          $scope.recover = function() {
              LoginResources.recover($scope.email, function (response) {
                NotificationService.success('lololo');
              }, function (error) {
                NotificationService.error('lalala');
              });
          }
    }]);
