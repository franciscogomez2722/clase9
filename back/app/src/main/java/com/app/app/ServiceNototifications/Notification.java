package com.app.app.ServiceNototifications;

/**
 * Interfaz base para todos los tipos de notificaciones.
 * 
 * Define el contrato que deben seguir las clases que representan
 * diferentes formas de notificar al usuario, como Email o SMS.
 */
public interface Notification {

    /**
     * Envía la notificación al usuario.
     *
     * @return Mensaje que indica cómo se envió la notificación.
     */
    String notifyUser();
}
