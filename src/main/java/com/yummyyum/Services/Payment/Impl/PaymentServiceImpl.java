package com.yummyyum.Services.Payment.Impl;

import com.yummyyum.Model.*;
import com.yummyyum.Model.DTO.PaymentInfoDTO;
import com.yummyyum.Model.EmbeddedIDs.UserOrderInfoPaymentId;
import com.yummyyum.Model.TernaryRelationships.UserOrderPaymentRelationship.UserOrderInfoPayment;
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
    private final CouponRepository couponRepository;


    public PaymentServiceImpl(PaymentRepository paymentRepository, UserRepository userRepository,
                              OrderInfoRepository orderInfoRepository,
                              UserOrderInfoPaymentRepository userOrderInfoPaymentRepository,
                              DeliveryAddressRepository deliveryAddressRepository, CouponRepository couponRepository) {
        this.paymentRepository = paymentRepository;
        this.userRepository = userRepository;
        this.orderInfoRepository = orderInfoRepository;
        this.userOrderInfoPaymentRepository = userOrderInfoPaymentRepository;
        this.deliveryAddressRepository = deliveryAddressRepository;
        this.couponRepository = couponRepository;
    }


    @Override
    public Optional<Payment> findPaymentById(Long id) {
        return paymentRepository.findById(id);
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
                                           String username, String orderInfoId, String couponName) {

        Payment payment = new Payment(paymentID, cardNumber, paymentDate, totalAmount);
        DeliveryAddress deliveryAddress = new DeliveryAddress(address, zipCode);


        Optional<User> user = userRepository.getUserByUsername(username);

        Optional<OrderInfo> orderInfo = orderInfoRepository.getOrderInfoByOrderId(orderInfoId);

        PaymentInfoDTO newPaymentInfoDTO = new PaymentInfoDTO(cardNumber, totalAmount, address,
                zipCode, username, orderInfoId, paymentID, couponName);

        if (couponName != null) {
            Optional<Coupon> coupon = couponRepository.getCouponByCouponName(couponName);
            payment.setCoupon(coupon.get());

            newPaymentInfoDTO.setCouponName(coupon.get().getCouponName());
        }

        paymentRepository.save(payment);

        Optional<Payment> createdPayment = paymentRepository.getPaymentByPaymentNumberID(paymentID);
        UserOrderInfoPaymentId userOrderInfoPaymentId = new UserOrderInfoPaymentId(user.get().getId(),
                orderInfo.get().getId(),
                createdPayment.get().getId());
        UserOrderInfoPayment userOrderInfoPayment = new UserOrderInfoPayment();
        userOrderInfoPayment.setId(userOrderInfoPaymentId);
        userOrderInfoPaymentRepository.save(userOrderInfoPayment);
        deliveryAddress.setPayment(createdPayment.get());
        deliveryAddressRepository.save(deliveryAddress);

        return newPaymentInfoDTO;

    }
}
