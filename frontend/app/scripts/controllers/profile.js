'use strict';

/**
 * @ngdoc function
 * @name tpfinal.controller:HomeCtrl
 * @description
 * # HomeCtrl
 * Controller of the servimap
 */
angular.module('servimap')

  .controller('ProfileCtrl', ['$scope', '$http', 'UserResources','profileSelected', 'HireResources', 'NotificationService', '$route','$location','QualifyResources','$rootScope', 'WorkResources',
      function ($scope, $http, UserResources, profileSelected, HireResources, NotificationService, $route,$location,QualifyResources,$rootScope, WorkResources)  {
        window.scrollTo(0, 0);

            $scope.profile = profileSelected;
            $scope.user = profileSelected.user;
            $scope.myTransactions = profileSelected.lastTransactions;
            $scope.myServiceHistory = profileSelected.transactions;
            $scope.newServices = _.countBy($scope.myServiceHistory, function(serv){
              return serv.state == 1 ? 'newOne' : 'old'
            });
            $scope.works = profileSelected.works;
            $scope.mainWork = $scope.works[0];
            $scope.today = new Date();
            $scope.work = {};
            $scope.showJob =false;
            $scope.showSeccion= true;

            if($scope.mainWork != undefined || $scope.mainWork != null){
                $scope.showJob=true;
                $scope.work.details = $scope.mainWork.description;
                $scope.work.uprice = $scope.mainWork.price;
                $scope.work.name = $scope.mainWork.name;
            }

            if($scope.works==0){
               $scope.showSeccion=false;}


            $scope.updateUser={};
            $scope.onlyChar=/^[a-zA-Z-\u00C0-\u017F,]+(\s{0,1}[a-zA-Z-\u00C0-\u017F, ])*$/;
            $scope.onlyNumbers= /^\d+$/;
            $scope.passwordRegex=/^(?=.*[a-z])(?=.*\d)[a-zA-Z\d]{8,}$/;



        if(profileSelected.rating != undefined){
                $scope.rating = profileSelected.rating.finalRating;
                $scope.comments = profileSelected.rating.comments;
            }

            if($scope.rating != undefined){

              $scope.generalAverage= Math.round( ($scope.rating.reliability + $scope.rating.performance + $scope.rating.recommendation + $scope.rating.consideration)/4);
              $scope.starRating = $scope.generalAverage;
              $scope.stars = _.range($scope.starRating);
              $scope.emptyStars = _.range(5 - $scope.starRating);
              $scope.starReliability = _.range($scope.rating.reliability);
              $scope.emptyStarsReliability = _.range(5 - $scope.rating.reliability);
              $scope.starPerformance = _.range($scope.rating.performance);
              $scope.emptyStarsPerformance = _.range(5 - $scope.rating.performance);
              $scope.starConsideration = _.range($scope.rating.consideration);
              $scope.emptyStarsConsideration = _.range(5 - $scope.rating.consideration);
              $scope.starRecommendation = _.range($scope.rating.recommendation);
              $scope.emptyStarsRecommendation = _.range(5 - $scope.rating.recommendation);
            }

        $scope.zonas = [{id:1 ,name: '20 de Junio'},
          {id:2 ,name: 'Aldo Bonzi'},
          {id:3 ,name: 'Ciudad Evita'},
          {id:4 ,name: 'González Catán'},
          {id:5 ,name: 'Gregorio de Laferrere'},
          {id:6 ,name: 'Isidro Casanova'},
          {id:7 ,name: 'La Tablada'},
          {id:8 ,name: 'Lomas del Mirador'},
          {id:9 ,name: 'Rafael Castillo'},
          {id:10 ,name: 'Ramos Mejía'},
          {id:11 ,name: 'San Justo'},
          {id:12 ,name: 'Tapiales'},
          {id:13 ,name: 'Villa Luzuriaga'},
          {id:14 ,name: 'Villa Madero'},
          {id:15 ,name: 'Virrey del Pino'}];


         $scope.updateUser = function () {

            if ($scope.updateUser.oldPassword != undefined &&  $scope.updateUser.newPassword == undefined && $scope.updateUser.passwordConfirmation == undefined){
             NotificationService.error('Escribe las contraseñas.');
             return false;
           }else if($scope.updateUser.oldPassword != undefined  && $scope.updateUser.newPassword == undefined || $scope.updateUser.passwordConfirmation == undefined){
              NotificationService.error('Ingrese las nuevas contraseñas.');
              return false;
            }
           //else if ($scope.updateUser.oldPassword != undefined && $scope.updateUser.oldPassword == $scope.updateUser.newPassword) {
           //  NotificationService.error('La contraseña actual y la nueva son las mismas.');
           //  return false;
           //}
            else {

             var updateUser = {
               'idUser': $rootScope.idUser,
               'name': $scope.updateUser.firstName == null ? $scope.user.name : $scope.updateUser.firstName,
               'surname': $scope.updateUser.surname == null ? $scope.user.surname : $scope.updateUser.surname,
               'email': $scope.updateUser.email == null ? $scope.user.email : $scope.updateUser.email,
               'phone': $scope.updateUser.telephone == null ? $scope.user.phone : $scope.updateUser.telephone,
               'street': $scope.updateUser.street,
               'number': $scope.updateUser.number,
               'oldPassword': $scope.updateUser.oldPassword,
               'password': $scope.updateUser.newPassword
             };

           }
           UserResources.update(updateUser, function (response) {
             if($scope.updateUser.newPassword != undefined){
               NotificationService.success('Tus datos han sido actualizados correctamente! Recuerda iniciar sesión la próxima vez con tu nueva contraseña.');
             }else{
               NotificationService.success('Tus datos han sido actualizados correctamente!');
             }
             $route.reload();

           }, function (error) {
             NotificationService.error('Ha ocurrido un error inesperado');
           })
         };

          $scope.updateWork = function(){
            var updatedWork = {
              'name': $scope.work.name,
              'description' : $scope.work.details,
              'price': $scope.work.uprice,
              'idUser' : $rootScope.idUser
            };
            console.log(updatedWork);

            WorkResources.update(updatedWork, function (response) {
                NotificationService.success('Tus datos han sido actualizados correctamente!');
                $route.reload();

            }, function (error) {
              NotificationService.error('Ha ocurrido un error inesperado');
            })
          };

          $scope.rejectService = function(idTx, reject){
              var rejection={
                "idTrx": idTx,
                "rejection": reject};
              HireResources.rejectTransaction(rejection, function(){
                NotificationService.success('Se ha actualizado correctamente');
                $route.reload();
              },function(error){
                NotificationService.error('Ha ocurrido un error inesperado');
              })
          };

          $scope.acceptService = function(idTx){
            HireResources.acceptTransaction(idTx, function(){
              NotificationService.success('Se ha actualizado correctamente');
              $route.reload();
            },function(error){
              NotificationService.error('Ha ocurrido un error inesperado');
            })
          };

          $scope.finishService = function(idTx){
            HireResources.finishTransaction(idTx, function(){
              NotificationService.success('Se ha actualizado correctamente');
              $route.reload();
            },function(error){
              NotificationService.error('Ha ocurrido un error inesperado');
            })
          };

         $scope.qualifyService = function(idTx){

            $location.path('/calificar/'+idTx)

        };
        $scope.qualifyUserService = function(idTx){

            $location.path('/calificar/usuario/'+idTx)

        };
    }]);
