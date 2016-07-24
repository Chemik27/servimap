'use strict';

angular.module('dutymap')
    .controller('HelperCtrl', ['$scope', '$routeParams', 'LoginResources', 'NotificationService',
    function ($scope, $routeParams, LoginResources, NotificationService) {
        console.log($routeParams.email);

        LoginResources.recover($routeParams.email, function (response) {
            NotificationService.success('lalala')
        }, function (error) {
            NotificationService.error('lalala')
        });

    }]);
