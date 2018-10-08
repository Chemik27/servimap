'use strict';

angular.module('servimap')
    .service('NotificationService',[function NotificationService() {

        PNotify.prototype.options.mouse_reset = false;

        return{
            success: function(mensaje){
                new PNotify({
                  title: 'Bien hecho!',
                  text: mensaje,
                  type: 'success'
                });
            },
            error: function(mensaje){
                new PNotify({
                    title: 'Upss..',
                    text: mensaje,
                    type: 'error'
              });
            },
            info: function(mensaje){
                new PNotify({
                    title: 'Atención',
                    text: mensaje
                });
            }
        }

    }]);
