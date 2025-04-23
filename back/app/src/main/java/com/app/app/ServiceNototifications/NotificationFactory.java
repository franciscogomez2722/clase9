package com.app.app.ServiceNototifications;

/**
 * Clase abstracta que define el método de fábrica para crear notificaciones.
 * 
 * Forma parte del patrón Factory Method. Las subclases deben implementar
 * el método {@code createNotification()} para devolver una instancia concreta
 * de {@link Notification}, como {@code EmailNotification} o {@code SmsNotification}.
 */
public abstract class NotificationFactory {

    /**
     * Método de fábrica que debe ser implementado por las subclases para
     * crear un tipo específico de notificación.
     *
     * @return una instancia concreta de {@link Notification}.
     */
    public abstract Notification createNotification();
}
