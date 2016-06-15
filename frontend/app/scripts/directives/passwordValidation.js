/**
 * Created by nico on 09/06/16.
 */
angular.module('dutymap')
  .directive('passwordValidation', function () {
    return {
      require: 'ngModel',
      link: function(scope, elem, attrs, ctrl) {


        ctrl.$parsers.unshift(function(viewValue, $scope) {

            scope.pwdValidLength = ( viewValue.length >= 8 ? 'valid' : undefined);

            scope.pwdHasLetter = (/[A-z]/.test(viewValue)) ? 'valid' : undefined;

            scope.pwdHasNumber = (/\d/.test(viewValue)) ? 'valid' : undefined;

            //valido contraseñas, si son diferentes noMatch=true, entonces a setValidity le seteo
            //!noMatch para que sea false y muestre el mensaje
            scope.$watch(attrs.passwordValidation, function (passwordConfirmation) {
              var noMatch = ctrl.$viewValue  != passwordConfirmation;
              scope.userForm.passwordConfirmation.$setValidity('noMatch', !noMatch);
            });
            return viewValue;
        })
      }
    }
  });
