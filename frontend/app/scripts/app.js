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
    'ngTouch',
    'ngMessages',
    'duScroll'

  ])
  .config(function ($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'views/home.html',
        controller: 'MainCtrl'
      })
      .when('/servicio/:idCategory', {
        templateUrl: 'views/service.html',
        controller: 'WorkCtrl',
        resolve: {categorySelected: ['$route','WorkResources', function($route, WorkResources) {
          return WorkResources.query($route.current.pathParams).$promise;}]}
      })
      .when('/servicioAddress/:idAddress', {
        templateUrl: 'views/service.html',
        controller: 'AddressCtrl',
        resolve: {addressSelected: ['$route','AddressResources', function($route, AddressResources) {
          return AddressResources.query($route.current.pathParams).$promise;}]}
      })
      .when('/servicioWord/:wordOfSearchTyped', {
        templateUrl: 'views/service.html',
        controller: 'WordOfSearchCtrl',
        resolve: {wordOfSearchTyped: ['$route','WordOfSearchResources', function($route, WordOfSearchResources) {
          return WordOfSearchResources.query($route.current.pathParams).$promise;}]}
      })
      .when('/registro', {
        templateUrl: 'views/register.html',
        controller: 'RegisterCtrl',
        resolve: {addresses: ['$route','RegisterResources', function($route, RegisterResources) {
          return RegisterResources.query($route.current.pathParams).$promise;}]}
      })
      .when('/login', {
        templateUrl: 'views/login.html',
        controller: 'NavigationCtrl'
      })
      .when('/terminos', {
        templateUrl: 'views/terms.html',
        controller: 'TermsCtrl'
      })


      .when('/faq', {
        templateUrl: 'views/faq.html',
        controller: 'FaqCtrl'
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
  })
  .config(function($httpProvider) {

    $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';

  });



