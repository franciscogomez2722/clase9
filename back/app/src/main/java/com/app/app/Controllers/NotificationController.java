package com.app.app.Controllers;

import org.springframework.web.bind.annotation.*;

import com.app.app.ServiceNototifications.EmailNotificationFactory;
import com.app.app.ServiceNototifications.Notification;
import com.app.app.ServiceNototifications.NotificationFactory;
import com.app.app.ServiceNototifications.SmsNotificationFactory;

/**
 * Controlador REST que maneja solicitudes para enviar notificaciones.
 * Utiliza el patrón Factory Method para crear instancias del tipo de notificación solicitado.
 */
@RestController
@RequestMapping("/api/notify")
@CrossOrigin(origins = "*") // Permite solicitudes CORS desde cualquier origen
public class NotificationController {

    /**
     * Endpoint para enviar una notificación basada en el tipo proporcionado.
     * 
     * @param type El tipo de notificación a enviar ("email" o "sms").
     * @return Un mensaje indicando que la notificación fue enviada, o un error si el tipo no es soportado.
     */
    @GetMapping("/{type}")
    public String sendNotification(@PathVariable String type) {
        NotificationFactory factory;

        // Selecciona la fábrica correspondiente según el tipo de notificación
        if ("email".equalsIgnoreCase(type)) {
            factory = new EmailNotificationFactory();
        } else if ("sms".equalsIgnoreCase(type)) {
            factory = new SmsNotificationFactory();
        } else {
            // Si el tipo no es reconocido, retorna un mensaje de error
            return "Tipo de notificación no soportado";
        }

        // Crea una instancia de la notificación mediante la fábrica seleccionada
        Notification notification = factory.createNotification();

        // Llama al método para notificar al usuario
        return notification.notifyUser();
    }
}
