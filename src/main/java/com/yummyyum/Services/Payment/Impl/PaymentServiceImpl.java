package com.yummyyum.Services.Payment.Impl;

import com.yummyyum.Model.DTO.PaymentInfoDTO;
import com.yummyyum.Model.DeliveryAddress;
import com.yummyyum.Model.EmbeddedIDs.UserOrderInfoPaymentId;
import com.yummyyum.Model.OrderInfo;
import com.yummyyum.Model.Payment;
import com.yummyyum.Model.TernaryRelationships.UserOrderPaymentRelationship.UserOrderInfoPayment;
import com.yummyyum.Model.User;
import com.yummyyum.Repositories.*;
import com.yummyyum.Services.Payment.PaymentService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final UserRepository userRepository;
    private final OrderInfoRepository orderInfoRepository;
    private final UserOrderInfoPaymentRepository userOrderInfoPaymentRepository;
    private final DeliveryAddressRepository deliveryAddressRepository;


    public PaymentServiceImpl(PaymentRepository paymentRepository, UserRepository userRepository,
                              OrderInfoRepository orderInfoRepository,
                              UserOrderInfoPaymentRepository userOrderInfoPaymentRepository,
                              DeliveryAddressRepository deliveryAddressRepository) {
        this.paymentRepository = paymentRepository;
        this.userRepository = userRepository;
        this.orderInfoRepository = orderInfoRepository;
        this.userOrderInfoPaymentRepository = userOrderInfoPaymentRepository;
        this.deliveryAddressRepository = deliveryAddressRepository;
    }


    @Override
    public Optional<Payment> getPaymentByPaymentNumberID(String paymentNumberId) {
        return paymentRepository.getPaymentByPaymentNumberID(paymentNumberId);
    }

    @Override
    public List<Payment> getAllPaymentsByPaymentDate(String date) {
        return paymentRepository.getALlPaymentsByPaymentDate(date);
    }

    @Override
    public PaymentInfoDTO createNewPayment(String paymentID, String cardNumber, Date paymentDate, Float totalAmount,
                                    String address, String zipCode,
                                    String username, String orderInfoId) {

        Payment payment = new Payment(paymentID, cardNumber, paymentDate, totalAmount);
        paymentRepository.save(payment);
        DeliveryAddress deliveryAddress = new DeliveryAddress(address, zipCode);
        Optional<Payment> createdPayment = paymentRepository.getPaymentByPaymentNumberID(paymentID);
        deliveryAddress.setPayment(createdPayment.get());
        deliveryAddressRepository.save(deliveryAddress);

        Optional<User> user = userRepository.getUserByUsername(username);

        Optional<OrderInfo> orderInfo = orderInfoRepository.getOrderInfoByOrderId(orderInfoId);
        System.out.println(createdPayment.get().getId());
        System.out.println(user.get().getId());
        System.out.println(orderInfo.get().getId());
        UserOrderInfoPaymentId userOrderInfoPaymentId = new UserOrderInfoPaymentId(user.get().getId(),
                orderInfo.get().getId(),
                createdPayment.get().getId());
        UserOrderInfoPayment userOrderInfoPayment = new UserOrderInfoPayment();
        userOrderInfoPayment.setId(userOrderInfoPaymentId);
        userOrderInfoPaymentRepository.save(userOrderInfoPayment);


        return new PaymentInfoDTO(cardNumber, totalAmount, address,
                zipCode, username, orderInfoId, paymentID);

    }
}
