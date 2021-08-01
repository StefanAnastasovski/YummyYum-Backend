package com.yummyyum.Services.UserOrderInfoPayment.Impl;

import com.yummyyum.Model.EmbeddedIDs.UserOrderInfoPaymentId;
import com.yummyyum.Model.OrderInfo;
import com.yummyyum.Model.TernaryRelationships.UserOrderPaymentRelationship.UserOrderInfoPayment;
import com.yummyyum.Model.TernaryRelationships.UserSubscriptionPaymentRelationship.UserSubscriptionPayment;
import com.yummyyum.Model.User;
import com.yummyyum.Repositories.OrderInfoRepository;
import com.yummyyum.Repositories.UserOrderInfoPaymentRepository;
import com.yummyyum.Repositories.UserRepository;
import com.yummyyum.Repositories.UserSubscriptionPaymentRepository;
import com.yummyyum.Services.UserOrderInfoPayment.UserOrderInfoPaymentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserOrderInfoPaymentServiceImpl implements UserOrderInfoPaymentService {

    private final UserOrderInfoPaymentRepository userOrderInfoPaymentRepository;
    private final UserRepository userRepository;
    private final UserSubscriptionPaymentRepository userSubscriptionPaymentRepository;
    private final OrderInfoRepository orderInfoRepository;

    public UserOrderInfoPaymentServiceImpl(UserOrderInfoPaymentRepository userOrderInfoPaymentRepository,
                                           UserRepository userRepository,
                                           UserSubscriptionPaymentRepository userSubscriptionPaymentRepository,
                                           OrderInfoRepository orderInfoRepository) {
        this.userOrderInfoPaymentRepository = userOrderInfoPaymentRepository;
        this.userRepository = userRepository;
        this.userSubscriptionPaymentRepository = userSubscriptionPaymentRepository;
        this.orderInfoRepository = orderInfoRepository;
    }

    @Override
    public List<UserOrderInfoPayment> getUserOrderInfoPaymentByUsernameAndOrderDate(String username, String orderDate) {
        return userOrderInfoPaymentRepository.getUserOrderInfoPaymentByUsernameAndOrderDate(username, orderDate);
    }

    @Override
    public List<UserOrderInfoPayment> getUserOrderInfoPaymentByUsernameBetweenDates(String username,
                                                                                    String startDate, String endDate) {
        return userOrderInfoPaymentRepository.getUserOrderInfoPaymentByUsernameBetweenDates(username, startDate, endDate);
    }

    @Override
    public List<UserOrderInfoPayment> getUserOrderInfoPaymentByBetweenDates(String startDate, String endDate) {
        return null;
    }

    @Override
    public List<UserOrderInfoPayment> getUserOrderInfoPaymentByOrderDate(String orderDate) {
        return userOrderInfoPaymentRepository.getUserOrderInfoPaymentByOrderDate(orderDate);
    }

    @Override
    public List<UserOrderInfoPayment> getUserOrderInfoPaymentBetweenDates(String startDate, String endDate) {
        return userOrderInfoPaymentRepository.getUserOrderInfoPaymentBetweenDates(startDate, endDate);
    }

    @Override

    public Optional<UserOrderInfoPayment> getUserOrderInfoPaymentByOrderId(String orderId) {
        return userOrderInfoPaymentRepository.getUserOrderInfoPaymentByOrderId(orderId);
    }

    @Override
    public Optional<UserOrderInfoPayment> getUserOrderInfoPaymentByPaymentId(String paymentNumberId) {
        return userOrderInfoPaymentRepository.getUserOrderInfoPaymentByPaymentId(paymentNumberId);
    }

    @Override
    public UserOrderInfoPayment createNewUserOrderInfoPayment(String username, String orderId) {


        List<UserSubscriptionPayment> userSubscriptionPayment =
                userSubscriptionPaymentRepository.getUserSubscriptionPaymentByUsername(username);
        Optional<User> user = userRepository.getUserByUsername(username);
        Optional<OrderInfo> orderInfo1 = orderInfoRepository.getOrderInfoByOrderId(orderId);

        UserOrderInfoPaymentId userOrderInfoPaymentId = new UserOrderInfoPaymentId(user.get().getId(),
                orderInfo1.get().getId(),
                userSubscriptionPayment.get(userSubscriptionPayment.size() - 1).getId().getPaymentId());

        UserOrderInfoPayment userOrderInfoPayment = new UserOrderInfoPayment();

        userOrderInfoPayment.setId(userOrderInfoPaymentId);


        return userOrderInfoPaymentRepository.save(userOrderInfoPayment);
    }

}
