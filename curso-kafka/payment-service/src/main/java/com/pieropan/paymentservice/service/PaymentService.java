package com.pieropan.paymentservice.service;

import com.pieropan.paymentservice.model.Payment;

public interface PaymentService {
    void sendPayment(Payment payment);
}