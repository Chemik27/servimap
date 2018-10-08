/**
 * Created by nico on 02/06/16.
 */
angular.module('servimap')
  .directive('navbarHome', function () {
    return {

      templateUrl:'views/directives/navbar-home.html',
      restrict: 'E',
      replace:true,
      controller: 'NavigationCtrl'
    };
  });
