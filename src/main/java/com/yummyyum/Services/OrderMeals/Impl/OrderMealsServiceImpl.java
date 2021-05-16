package com.yummyyum.Services.OrderMeals.Impl;

import com.yummyyum.Model.DTO.OrderMealsDTO;
import com.yummyyum.Model.OrderInfo;
import com.yummyyum.Model.OrderMeals;
import com.yummyyum.Repositories.OrderInfoRepository;
import com.yummyyum.Repositories.OrderMealsRepository;
import com.yummyyum.Services.OrderMeals.OrderMealsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderMealsServiceImpl implements OrderMealsService {

    private final OrderMealsRepository orderMealsRepository;
    private final OrderInfoRepository orderInfoRepository;

    public OrderMealsServiceImpl(OrderMealsRepository orderMealsRepository,
                                 OrderInfoRepository orderInfoRepository) {
        this.orderMealsRepository = orderMealsRepository;
        this.orderInfoRepository = orderInfoRepository;
    }

    @Override
    public List<OrderMeals> getOrderMealsByOrderId(String orderId) {
        return orderMealsRepository.getOrderMealsByOrderId(orderId);
    }

    @Override
    public OrderMealsDTO createNewOrderMeals(List<OrderMeals> orderMeals, String orderId) {

        Optional<OrderInfo> orderInfo = orderInfoRepository.getOrderInfoByOrderId(orderId);

        OrderMealsDTO orderMealsDTO = new OrderMealsDTO();

        List<OrderMeals> orderMealsList = new ArrayList<>();

        for (OrderMeals orderMeal : orderMeals) {
            OrderMeals orderMeals1 =
                    new OrderMeals(orderMeal.getMealName(), orderMeal.getMenuName(),
                            orderMeal.getServings(), orderMeal.getCustomizeIt(),
                            orderMeal.getPrice(), orderMeal.getDeliveryDate(),
                            orderMeal.getDeliveryTime());
            orderMeals1.setOrderInfo(orderInfo.get());
            orderMealsList.add(orderMeals1);
        }

        orderMealsDTO.setOrderMeals(orderMealsList);

        orderMealsRepository.saveAll(orderMealsList);

        return orderMealsDTO;
    }

}
