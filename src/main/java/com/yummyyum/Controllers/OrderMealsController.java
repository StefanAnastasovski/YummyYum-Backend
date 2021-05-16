package com.yummyyum.Controllers;


import com.yummyyum.Model.DTO.OrderMealsDTO;
import com.yummyyum.Model.OrderMeals;
import com.yummyyum.Services.OrderMeals.OrderMealsService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.util.List;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:8080")
public class OrderMealsController {

    private final OrderMealsService orderMealsService;

    public OrderMealsController(OrderMealsService orderMealsService) {
        this.orderMealsService = orderMealsService;
    }

    @GetMapping("/order-meals/orderId={orderId}")
    public List<OrderMeals> getOrderMealsByOrderId(@PathVariable("orderId") String orderId) {
        return orderMealsService.getOrderMealsByOrderId(orderId);
    }

    @PostMapping("/order-meals/orderId={orderId}")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public OrderMealsDTO createNewOrderMeals(@RequestBody OrderMealsDTO orderMealsDTO,
                                        @PathVariable("orderId") String orderId,
                                        HttpServletResponse response,
                                        UriComponentsBuilder builder) {

        OrderMealsDTO orderMealsDTO1 = orderMealsService.createNewOrderMeals(orderMealsDTO.getOrderMeals(),
                orderId);

        return orderMealsDTO1;
    }

}
