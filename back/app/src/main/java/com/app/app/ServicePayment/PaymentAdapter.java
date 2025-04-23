package com.app.app.ServicePayment;

import com.app.app.Models.PaymentRequest;

public interface PaymentAdapter {

    /**
     * Método para procesar un pago.
     * 
     * Este método debe ser implementado por cualquier clase que se encargue de procesar
     * los pagos. El objetivo es recibir una solicitud de pago (PaymentRequest) y
     * manejar la lógica de procesamiento del pago.
     *
     * @param paymentRequest La solicitud de pago que contiene los detalles del pago.
     */
    void processPayment(PaymentRequest paymentRequest);
}

