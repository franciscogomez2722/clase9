package com.app.app.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.app.Models.PaymentRequest;
import com.app.app.ServicePayment.PaymentService;

import java.util.Set;

@RestController
@RequestMapping("/api/payment")
@CrossOrigin(origins = "http://localhost:5173")
public class PaymentController {

    private final PaymentService paymentService;

    // Métodos válidos
    private final Set<String> validMethods = Set.of("paypal", "stripe");


    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    /**
     * Método para procesar pagos.
     * 
     * Este método recibe una solicitud de pago con los detalles de la transacción
     * y verifica si el método de pago es válido (Paypal o Stripe). Si el método
     * no es válido, devuelve un error. Si es válido, procesa el pago.
     *
     * @param paymentRequest Solicitud de pago con los detalles del pago.
     * @return Respuesta con el estado del pago.
     */
    @PostMapping
    public ResponseEntity<String> processPayment(@RequestBody PaymentRequest paymentRequest) {
        // Verifica si el método de pago es válido.
        if (!validMethods.contains(paymentRequest.getMethod())) {
            // Si el método no es válido, devuelve un error con código 405 (Método no permitido).
            return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED)
                    .body("Método de pago no soportado");
        }

        // Si el método es válido, procesa el pago usando el servicio PaymentService.
        paymentService.processPayment(paymentRequest);

        // Devuelve una respuesta con un mensaje de éxito.
        return ResponseEntity.ok("Pago procesado con éxito");
    }
}
