'use strict';

/**
 * @ngdoc function
 * @name tpfinal.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the tpfinal
 */
angular.module('dutymap')
  .controller('MainCtrl', ['$scope', '$http' ,function ($scope, $http) {

    var url = "/api/services/";
    $http.post(url)
      .success(function(response) {
        $scope.productos = response.content;
      })
      .error(function(error){
        console.log("lpm")
      });

    //*MENU*
    // Closes the sidebar menu
    $("#menu-close").click(function(e) {
      e.preventDefault();
      $("#sidebar-wrapper").toggleClass("active");
    });

    // Opens the sidebar menu
    $("#menu-toggle").click(function(e) {
      e.preventDefault();
      $("#sidebar-wrapper").toggleClass("active");
    });

    // Scrolls to the selected menu item on the page
    $(function() {
      $('a[href*=\\#]:not([href=\\#])').click(function() {
        if (location.pathname.replace(/^\//, '') == this.pathname.replace(/^\//, '') || location.hostname == this.hostname) {

          var target = $(this.hash);
          target = target.length ? target : $('[name=' + this.hash.slice(1) + ']');
          if (target.length) {
            $('html,body').animate({
              scrollTop: target.offset().top
            }, 1000);
            return false;
          }
        }
      });
    });


  }]);
