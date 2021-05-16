package com.yummyyum.Controllers;

import com.yummyyum.Model.DTO.OrderInfoMeals;
import com.yummyyum.Model.OrderInfo;
import com.yummyyum.Services.OrderInfo.OrderInfoService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:8080")
public class OrderInfoController {

    private final OrderInfoService orderInfoService;

    public OrderInfoController(OrderInfoService orderInfoService) {
        this.orderInfoService = orderInfoService;
    }

    @GetMapping("/order-info/orderId={orderId}")
    public Optional<OrderInfo> getOrderInfoByOrderId(@PathVariable("orderId") String orderId) {
        return orderInfoService.getOrderInfoByOrderId(orderId);
    }

    @GetMapping("/order-info/orderDate={orderDate}")
    public List<OrderInfo> getOrderInfoByOrderDate(@PathVariable("orderDate")
                                                   @DateTimeFormat(pattern = "yyyy-MM-dd") String orderDate) {
        return orderInfoService.getOrderInfoByOrderDate(orderDate);
    }

    @GetMapping("/order-info/order-meals/orderId={orderId}")
    public OrderInfoMeals getOrderInfoAndOrderMealsByOrderId(@PathVariable("orderId") String orderId) {
        return orderInfoService.getOrderInfoAndOrderMealsByOrderId(orderId);
    }

    @PostMapping("/order-info")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public OrderInfo createNewLogin(@RequestBody OrderInfo orderInfo,
                                    HttpServletResponse response,
                                    UriComponentsBuilder builder) {

        OrderInfo orderInfo1 = orderInfoService.createNewOrder(orderInfo.getOrderId(), orderInfo.getMealNumber(),
                orderInfo.getServingNumber(), orderInfo.getSubtotal(),
                orderInfo.getShippingCost(), orderInfo.getTotal());

        response.setHeader("Location", builder.path("/api/order-inf/" + orderInfo.getId()).
                buildAndExpand(orderInfo.getId()).toUriString());

        return orderInfo1;
    }

}
