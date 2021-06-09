package com.yummyyum.Services.Payment;

import com.yummyyum.Model.DTO.PaymentInfoDTO;
import com.yummyyum.Model.Payment;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface PaymentService {

    Optional<Payment> findPaymentById(Long id);

    Optional<Payment> getPaymentByPaymentNumberID(String paymentNumberId);

    List<Payment> getAllPaymentsByPaymentDate(String date);

    PaymentInfoDTO createNewPayment(String paymentID, String cardNumber, Date paymentDate, Float totalAmount,
                                    String address, String zipCode,
                                    String username, String orderInfoId, String couponName);

}
