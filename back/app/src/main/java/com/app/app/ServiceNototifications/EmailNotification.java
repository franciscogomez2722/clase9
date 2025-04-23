package com.app.app.ServiceNototifications;

/**
 * Implementación concreta de la interfaz Notification que representa
 * una notificación enviada por correo electrónico.
 *
 * Esta clase es parte del patrón Factory Method y se instancia a través
 * de la clase {@link EmailNotificationFactory}.
 */
public class EmailNotification implements Notification {

    /**
     * Método que simula el envío de una notificación por correo electrónico.
     *
     * @return Mensaje indicando que la notificación fue enviada por correo electrónico.
     */
    public String notifyUser() {
        return "Notificación enviada por correo electrónico";
    }
}
