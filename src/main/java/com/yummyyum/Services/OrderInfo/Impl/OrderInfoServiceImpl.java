package com.yummyyum.Services.OrderInfo.Impl;

import com.yummyyum.Model.DTO.OrderInfoMeals;
import com.yummyyum.Model.OrderInfo;
import com.yummyyum.Model.OrderMeals;
import com.yummyyum.Model.User;
import com.yummyyum.Repositories.OrderInfoRepository;
import com.yummyyum.Repositories.OrderMealsRepository;
import com.yummyyum.Repositories.UserRepository;
import com.yummyyum.Services.OrderInfo.OrderInfoService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OrderInfoServiceImpl implements OrderInfoService {

    private final OrderInfoRepository orderInfoRepository;
    private final OrderMealsRepository orderMealsRepository;
    private final UserRepository userRepository;

    public OrderInfoServiceImpl(OrderInfoRepository orderInfoRepository,
                                OrderMealsRepository orderMealsRepository, UserRepository userRepository) {
        this.orderInfoRepository = orderInfoRepository;
        this.orderMealsRepository = orderMealsRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Optional<OrderInfo> getOrderInfoByOrderId(String orderId) {
        return orderInfoRepository.getOrderInfoByOrderId(orderId);
    }

    @Override
    public List<OrderInfo> getOrderInfoByOrderDate(String date) {
        return orderInfoRepository.getOrderInfoByOrderDate(date);
    }

    @Override
    public OrderInfoMeals getOrderInfoAndOrderMealsByOrderId(String orderId) {

        Optional<OrderInfo> orderInfo = orderInfoRepository.getOrderInfoByOrderId(orderId);
        List<OrderMeals> orderMealsDTOs = orderMealsRepository.getOrderMealsByOrderId(orderId);

        OrderInfoMeals orderInfoMeals = new OrderInfoMeals();
        orderInfoMeals.setOrderId(orderInfo.get().getOrderId());
        orderInfoMeals.setMealNumber(orderInfo.get().getMealNumber());
        orderInfoMeals.setServingNumber(orderInfo.get().getServingNumber());
        orderInfoMeals.setSubtotal(orderInfo.get().getSubtotal());
        orderInfoMeals.setShippingCost(orderInfo.get().getShippingCost());
        orderInfoMeals.setTotal(orderInfo.get().getTotal());
        orderInfoMeals.setOrderDate(orderInfo.get().getOrderDate());
        orderInfoMeals.setOrderMeals(orderMealsDTOs);

        return orderInfoMeals;
    }

    @Override
    public OrderInfo createNewOrder(String orderId, int mealNumber,
                                    int servingNumber, float subtotal,
                                    float shippingCost, float total, User user) {

        Date date = new Date();

        Optional<User> user1 = userRepository.getUserByUsername(user.getUsername());


        OrderInfo orderInfo = new OrderInfo(orderId, mealNumber, servingNumber,
                subtotal, shippingCost, total, date);

        orderInfo.setUser(user1.get());

        return orderInfoRepository.save(orderInfo);
    }
}
