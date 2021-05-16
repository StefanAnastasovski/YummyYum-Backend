package com.yummyyum.Services.OrderMeals;

import com.yummyyum.Model.DTO.OrderMealsDTO;
import com.yummyyum.Model.OrderMeals;

import java.util.List;

public interface OrderMealsService {

    List<OrderMeals> getOrderMealsByOrderId(String orderId);

    OrderMealsDTO createNewOrderMeals(List<OrderMeals> orderMeals, String orderId);

}
