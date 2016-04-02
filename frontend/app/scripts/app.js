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
        templateUrl: 'views/main.html',
        controller: 'MainCtrl',
        controllerAs: 'main'
      })
      .otherwise({
        redirectTo: '/'
      });
  });
