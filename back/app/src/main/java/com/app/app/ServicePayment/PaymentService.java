package com.app.app.ServicePayment;

import org.springframework.stereotype.Service;

import com.app.app.Models.PaymentRequest;

@Service
public class PaymentService {

    // Instancias de los adaptadores para PayPal y Stripe
    private final PayPalPaymentAdapter payPalPaymentAdapter;
    private final StripePaymentAdapter stripePaymentAdapter;

    /**
     * Constructor de la clase PaymentService.
     * 
     * Se inyectan los adaptadores de pago de PayPal y Stripe para poder procesar pagos
     * con ambos métodos.
     *
     * @param payPalPaymentAdapter El adaptador que maneja los pagos de PayPal.
     * @param stripePaymentAdapter El adaptador que maneja los pagos de Stripe.
     */

    public PaymentService(PayPalPaymentAdapter payPalPaymentAdapter, StripePaymentAdapter stripePaymentAdapter) {
        this.payPalPaymentAdapter = payPalPaymentAdapter;
        this.stripePaymentAdapter = stripePaymentAdapter;
    }

    /**
     * Método para procesar un pago.
     * 
     * Dependiendo del método de pago (PayPal o Stripe) especificado en el objeto
     * PaymentRequest, se utiliza el adaptador correspondiente para procesar el pago.
     *
     * @param paymentRequest Objeto que contiene los detalles del pago, como el método de pago y el monto.
     */

    public void processPayment(PaymentRequest paymentRequest) {
        if ("paypal".equalsIgnoreCase(paymentRequest.getMethod())) {
            payPalPaymentAdapter.processPayment(paymentRequest);
        } else if ("stripe".equalsIgnoreCase(paymentRequest.getMethod())) {
            stripePaymentAdapter.processPayment(paymentRequest);
        } else {
            System.out.println("Método de pago no soportado");
        }
    }
}