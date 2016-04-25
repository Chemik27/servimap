'use strict';

/**
 * @ngdoc overview
 * @name dutymap
 * @description
 * # dutmyap
 *
 * Main module of the application.
 */
angular
    .module('dutymap', [
            'ngAnimate',
            'ngCookies',
            'ngResource',
            'ngRoute',
            'ngSanitize',
            'ngTouch'
    ])
    .config(function ($routeProvider) {
        $routeProvider
            .when('/', {
                templateUrl: 'views/home.html',
                controller: 'HomeCtrl'
            })
            .otherwise({
                redirectTo: '/'
            });
    });
