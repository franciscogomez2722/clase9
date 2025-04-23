package com.app.app.Models;


public class PaymentRequest {
    private String amount;
    private String method;

    // Getters y setters
    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
