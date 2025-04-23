package com.app.app.ServiceNototifications;

/**
 * Fábrica que crea notificaciones por correo electrónico.
 */
public class EmailNotificationFactory extends NotificationFactory {

    /**
     * Crea y devuelve una notificación de tipo Email.
     * 
     * @return una nueva instancia de EmailNotification.
     */
    @Override
    public Notification createNotification() {
        return new EmailNotification();
    }
}
