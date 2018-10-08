/**
 * Created by Kari on 03/07/2016.
 */
angular.module('servimap')
  .directive('profileServimap', function () {
    return {

      templateUrl:'views/directives/profile.html',
      restrict: 'E',
      replace:true
    };
  });
