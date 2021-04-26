package com.yummyyum.Services.Payment.Impl;

import com.yummyyum.Model.Payment;
import com.yummyyum.Repositories.PaymentRepository;
import com.yummyyum.Services.Payment.PaymentService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    @Override
    public List<Payment> getPaymentsByName(String name) {
        return paymentRepository.getPaymentsByName(name);
    }

    @Override
    public List<Payment> getPaymentsByDate(String date) {
        return paymentRepository.getPaymentsByDate(date);
    }

    @Override
    public Payment createPayment(String nameOnCard, String cardNumber,
                                 String expirationDateMonth, String expirationDateYear, String securityCode) {

        Date paymentDate = new Date();
        Payment payment = new Payment(paymentDate, nameOnCard,
                cardNumber, expirationDateMonth, expirationDateYear, securityCode);
        return paymentRepository.save(payment);
    }

}
