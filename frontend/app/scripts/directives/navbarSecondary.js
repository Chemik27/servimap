/**
 * Created by nico on 03/06/16.
 */
angular.module('servimap')
  .directive('navbarSecondary', function () {
    return {

      templateUrl:'views/directives/navbar-secondary.html',
      restrict: 'E',
      replace:true,
      controller: 'NavigationCtrl'
    };
  });
