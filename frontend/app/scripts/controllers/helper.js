'use strict';

angular.module('dutymap')
    .controller('HelperCtrl', ['$scope', '$routeParams', 'LoginResources', 'NotificationService', 'passwordRecovered',
    function ($scope, $routeParams, LoginResources, NotificationService, responsePassword) {
        console.log(responsePassword.content  );
        console.log("Helper");
        // LoginResources.get($routeParams.email, function (response) {
        //     NotificationService.success('lalala')
        // }, function (error) {
        //     NotificationService.error('lalala')
        // });

    }]);
