package com.app.app.ServicePayment;

import org.springframework.stereotype.Service;

import com.app.app.Models.PaymentRequest;

@Service
public class StripePaymentAdapter implements PaymentAdapter {

    @Override
    public void processPayment(PaymentRequest paymentRequest) {
        // Simulación de integración con la API de Stripe
        System.out.println("Procesando pago con Stripe: " + paymentRequest.getAmount());
    }
}