'use strict';

/**
 * @ngdoc overview
 * @name dutymap
 * @description
 * # tpfinal
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
        controller: 'MainCtrl'

      })
      .when('/servicio', {
        templateUrl: 'views/service.html',
        controller: 'ServiceCtrl'
      })

      .when('/perfil/:id', {
        templateUrl: 'views/profile.html',
        controller: 'ProfileCtrl',
        resolve: {profileSelected: ['$route','ProfileResources', function($route, ProfileResources) {
            return ProfileResources.get($route.current.pathParams).$promise;}]}
      })
      .otherwise({
        redirectTo: '/'
      });
  });



