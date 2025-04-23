package com.app.app.ServiceNototifications;

/**
 * Fábrica que crea notificaciones por SMS.
 * Parte del patrón Factory Method.
 */
public class SmsNotificationFactory extends NotificationFactory {

    /**
     * Crea y devuelve una notificación de tipo SMS.
     * 
     * @return una nueva instancia de SmsNotification.
     */
    @Override
    public Notification createNotification() {
        return new SmsNotification();
    }
}
