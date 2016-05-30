/**
 * Created by nico on 30/05/16.
 */
angular.module('dutymap')
  .controller('LoginCtrl', ['$scope', '$http' ,
    function ($scope, $http) {

      document.getElementById ("closeWindow").addEventListener ("click", closeForgotPass);

      $(document).ready(function () {
        $('.forgot-pass').click(function(event) {
          $(".pr-wrap").toggleClass("show-pass-reset");
        });

        $('.pass-reset-submit').click(function(event) {
          $(".pr-wrap").removeClass("show-pass-reset");
        });
        
      });
      
      function closeForgotPass(){
        $(".pr-wrap").removeClass("show-pass-reset");
        };
    }]);
