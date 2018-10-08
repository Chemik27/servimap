/**
 * Created by redbee on 15/06/16.
 */
angular.module('servimap')
  .directive('footerServimap', function () {
    return {

      templateUrl:'views/directives/footer.html',
      restrict: 'E',
      replace:true
    };
  });
