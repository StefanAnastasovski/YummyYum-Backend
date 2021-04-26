package com.yummyyum.Services.Payment;

import com.yummyyum.Model.Payment;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface PaymentService {

    List<Payment> getAllPayments();

    List<Payment> getPaymentsByName(String name);

    List<Payment> getPaymentsByDate(String date);

    Payment createPayment(String nameOnCard, String cardNumber,
                          String expirationDateMonth, String expirationDateYear,
                          String securityCode);

}
