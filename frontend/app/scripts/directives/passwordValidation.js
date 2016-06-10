/**
 * Created by nico on 09/06/16.
 */
angular.module('dutymap')
  .directive('passwordValidation', function () {
    return {

      require: 'ngModel',
      link: function(scope, elm, attrs, ctrl) {

        ctrl.$parsers.unshift(function(viewValue, $scope) {
          var noMatch = viewValue != scope.registerForm.password.$viewValue;
          console.log("noMatch: " + noMatch);
          ctrl.$setValidity('noMatch', !noMatch);
      
        })
      }
    }
  });
