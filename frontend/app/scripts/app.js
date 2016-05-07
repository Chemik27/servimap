'use strict';

/**
 * @ngdoc overview
 * @name tpfinal
 * @description
 * # tpfinal
 *
 * Main module of the application.
 */
angular
  .module('tpfinal', [
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
        controller: 'MainCtrl',

      })
      .when('/service', {
        templateUrl: 'views/service.html',
        controller: 'ServiceCtrl',

      })

      .when('/provider-profile', {
        templateUrl: 'views/provider-profile.html',
        controller: 'profileCtrl',

      })

      .otherwise({
        redirectTo: '/'
      });
  });



