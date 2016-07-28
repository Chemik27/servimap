'use strict';

angular.module('dutymap')
    .controller('HelperCtrl', ['$scope', '$routeParams', 'NotificationService', 'passwordRecovered', '$location',
    function ($scope, $routeParams, NotificationService, responsePassword, $location) {
        console.log(responsePassword.content);
        console.log("Helper");
        $location.path('/');
        // LoginResources.get($routeParams.email, function (response) {
        //     NotificationService.success('lalala')
        // }, function (error) {
        //     NotificationService.error('lalala')
        // });

    }]);
