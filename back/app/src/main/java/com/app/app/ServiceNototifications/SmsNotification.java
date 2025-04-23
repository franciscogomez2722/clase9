package com.app.app.ServiceNototifications;

/**
 * Implementación de notificación por SMS.
 */
public class SmsNotification implements Notification {

    /**
     * Envía una notificación por SMS.
     * 
     * @return Mensaje indicando que la notificación fue enviada por SMS.
     */
    public String notifyUser() {
        return "Notificación enviada por SMS";
    }
}
