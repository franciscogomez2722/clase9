package com.app.app.ServicePayment;


import org.springframework.stereotype.Service;

import com.app.app.Models.PaymentRequest;

@Service
public class PayPalPaymentAdapter implements PaymentAdapter {

    /**
     * Implementación del método processPayment para procesar pagos mediante PayPal.
     * 
     * Este método simula la integración con la API de PayPal. En un escenario real,
     * aquí se incluirían las llamadas a la API de PayPal para procesar el pago.
     * 
     * @param paymentRequest El objeto que contiene los detalles del pago, como el monto.
     */

    @Override
    public void processPayment(PaymentRequest paymentRequest) {
        // Simulación de integración con la API de PayPal
        System.out.println("Procesando pago con PayPal: " + paymentRequest.getAmount());
    }
}