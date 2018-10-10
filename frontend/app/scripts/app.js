'use strict';

/**
 * @ngdoc overview
 * @name servimap
 * @description
 * # tpfinal
 *
 * Main module of the application.
 */
angular
  .module('servimap', [
    'ngAnimate',
    'ngCookies',
    'ngResource',
    'ngRoute',
    'ngSanitize',
    'ngTouch',
    'ngMessages',
    'ngMaterial',
    'ngMap',
    'noCAPTCHA'
  ])
  .config(function ($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'views/home.html',
        controller: 'MainCtrl'
      })
      .when('/servicio/:serviceRequest', {
        templateUrl: 'views/works.html',
        controller: 'WorkCtrl',
        resolve: {works: ['$route','WorkResources', function($route, WorkResources) {
          return WorkResources.get($route.current.pathParams).$promise;}]}
      })
      .when('/registro', {
        templateUrl: 'views/register.html',
        controller: 'RegisterCtrl'
      })
      .when('/login', {
        templateUrl: 'views/login.html',
        controller: 'NavigationCtrl'
      })
      .when('/contratar/:id', {
        templateUrl: 'views/hire.html',
        controller: 'HireCtrl',
        resolve: {profileSelected: ['$route','HireResources', function($route, HireResources) {
          return HireResources.get($route.current.pathParams).$promise;}]}
      })
      .when('/terminos', {
        templateUrl: 'views/terms.html'
      })
      .when('/faq', {
        templateUrl: 'views/faq.html'
      })
      .when('/acerca-de-servimap', {
        templateUrl: 'views/about.html'
      })
      .when('/politicas', {
        templateUrl: 'views/policies.html'
      })
      .when('/calificar/:idTrx', {
        templateUrl: 'views/qualify.html',
        controller: 'QualifyCtrl',
        resolve: {profileSelected: ['$route','HireResources', function($route, HireResources) {
          return HireResources.getTransaction($route.current.pathParams).$promise;}]}
      })
      .when('/calificar/usuario/:idTrx', {
        templateUrl: 'views/qualifyUser.html',
        controller: 'QualifyUserCtrl',
        resolve: {profileSelected: ['$route','HireResources', function($route, HireResources) {
          return HireResources.getTransaction($route.current.pathParams).$promise;}]}
      })
      .when('/perfil/:id', {
        templateUrl: 'views/profile.html',
        controller: 'ProfileCtrl',
        resolve: {profileSelected: ['$route','ProfileResources', function($route, ProfileResources) {
          return ProfileResources.get($route.current.pathParams).$promise;}]}
      })
      .when('/passwordRecovery', {
        templateUrl: 'views/passwordRecovery.html',
        controller: 'HelperCtrl'
      })
      .when('/passwordSecurity/:hash', {
        templateUrl: 'views/passwordRecovery.html',
        controller : 'PasswordCtrl'
      })
      // .when('/changePassword', {
      //   templateUrl: '/',
      //   controller : 'PasswordCtrl'
      // })
      .otherwise({
        redirectTo: '/'
      });
  })
  .config(function($httpProvider) {

    $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';

  });



