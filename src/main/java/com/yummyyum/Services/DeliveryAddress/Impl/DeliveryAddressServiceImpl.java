package com.yummyyum.Services.DeliveryAddress.Impl;

import com.yummyyum.Model.DeliveryAddress;
import com.yummyyum.Model.Payment;
import com.yummyyum.Repositories.DeliveryAddressRepository;
import com.yummyyum.Repositories.PaymentRepository;
import com.yummyyum.Services.DeliveryAddress.DeliveryAddressService;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class DeliveryAddressServiceImpl implements DeliveryAddressService {

    private final DeliveryAddressRepository deliveryAddressRepository;
    private final PaymentRepository paymentRepository;

    public DeliveryAddressServiceImpl(DeliveryAddressRepository deliveryAddressRepository,
                                      PaymentRepository paymentRepository) {
        this.deliveryAddressRepository = deliveryAddressRepository;
        this.paymentRepository = paymentRepository;
    }

    @Override
    public Optional<DeliveryAddress> getDeliveryAddressByCardNumberId(String cardNumberId) {
        return deliveryAddressRepository.getDeliveryAddressByCardNumberId(cardNumberId);
    }

    @Override
    public DeliveryAddress createNewDeliveryAddress(String address, String zipCode, String cardNumberId) {

        DeliveryAddress deliveryAddress = new DeliveryAddress(address, zipCode);
        Optional<Payment> payment = paymentRepository.getPaymentByPaymentNumberID(cardNumberId);
        deliveryAddress.setPayment(payment.get());

        return deliveryAddressRepository.save(deliveryAddress);
    }

}
