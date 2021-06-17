package com.yummyyum.Services.OrderInfo;

import com.yummyyum.Model.DTO.OrderInfoMeals;
import com.yummyyum.Model.OrderInfo;
import com.yummyyum.Model.User;

import java.util.List;
import java.util.Optional;

public interface OrderInfoService {

    Optional<OrderInfo> findOrderInfoByID(Long id);

    Optional<OrderInfo> getOrderInfoByOrderId(String orderId);

    List<OrderInfo> getOrderInfoByOrderDate(String date);

    List<OrderInfo> getOrderInfoBetweenStartAndEndDate(String startDate, String endDate);

    OrderInfoMeals getOrderInfoAndOrderMealsByOrderId(String orderId);

    OrderInfo createNewOrder(String orderId, int mealNumber,
                             int servingNumber, float subtotal,
                             float shippingCost, float total, User user);

}
