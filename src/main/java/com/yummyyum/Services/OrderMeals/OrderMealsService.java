package com.yummyyum.Services.OrderMeals;

import com.yummyyum.Model.DTO.OrderMealsDTO;
import com.yummyyum.Model.OrderMeals;

import java.time.LocalDate;
import java.util.List;

public interface OrderMealsService {

    List<OrderMeals> getOrderMealsByOrderId(String orderId);


    List<OrderMeals> getOrderMealsBetweenDatesAndIsSubscription(LocalDate startDate, LocalDate endDate,
                                                                Boolean isSubscription);

    List<OrderMeals> getOrderMealsBetweenDates(LocalDate startDate, LocalDate endDate);

    OrderMealsDTO createNewOrderMeals(List<OrderMeals> orderMeals, String orderId);

}
