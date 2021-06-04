package com.yummyyum.Controllers;

import com.yummyyum.Model.DTO.UserOrderInfoPaymentDTO;
import com.yummyyum.Model.OrderInfo;
import com.yummyyum.Model.OrderMeals;
import com.yummyyum.Model.Payment;
import com.yummyyum.Model.TernaryRelationships.UserOrderPaymentRelationship.UserOrderInfoPayment;
import com.yummyyum.Model.User;
import com.yummyyum.Services.OrderInfo.OrderInfoService;
import com.yummyyum.Services.OrderMeals.OrderMealsService;
import com.yummyyum.Services.Payment.PaymentService;
import com.yummyyum.Services.User.UserService;
import com.yummyyum.Services.UserOrderInfoPayment.UserOrderInfoPaymentService;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:8080")
public class OrderInvoiceController {

    private final UserService userService;
    private final OrderInfoService orderInfoService;
    private final OrderMealsService orderMealsService;
    private final PaymentService paymentService;
    private final UserOrderInfoPaymentService userOrderInfoPaymentService;

    public OrderInvoiceController(UserService userService,
                                  OrderInfoService orderInfoService, OrderMealsService orderMealsService,
                                  PaymentService paymentService,
                                  UserOrderInfoPaymentService userOrderInfoPaymentService) {
        this.userService = userService;
        this.orderInfoService = orderInfoService;
        this.orderMealsService = orderMealsService;
        this.paymentService = paymentService;
        this.userOrderInfoPaymentService = userOrderInfoPaymentService;
    }

    @GetMapping("/user-order-invoice/username={username}/order-date={orderDate}")
    public List<UserOrderInfoPaymentDTO> getUserOrderInvoiceByUsernameAndOrderDate(@PathVariable("username") String username,
                                                                                   @PathVariable("orderDate") String orderDate) {

        Optional<User> user = userService.getUserByUsername(username);
        List<UserOrderInfoPayment> paymentInfo =
                userOrderInfoPaymentService.getUserOrderInfoPaymentByUsernameAndOrderDate(username, orderDate);

        List<UserOrderInfoPaymentDTO> invoices = new ArrayList<>();


        for (UserOrderInfoPayment userOrderInfoPayment : paymentInfo) {
            UserOrderInfoPaymentDTO obj = new UserOrderInfoPaymentDTO();
            Optional<OrderInfo> orderInfo = orderInfoService.findOrderInfoByID(userOrderInfoPayment.getId().getOrderInfoId());
            List<OrderMeals> orderMeals = orderMealsService.getOrderMealsByOrderId(orderInfo.get().getOrderId());
            Optional<Payment> payment = paymentService.findPaymentById(userOrderInfoPayment.getId().getPaymentId());

            obj.setFirstName(user.get().getFirstName());
            obj.setLastName(user.get().getLastName());
            obj.setUsername(user.get().getUsername());
            obj.setAddress("address");
            obj.setZipCode("zipCOde");
            obj.setOrderInfo(orderInfo.get());
            obj.setOrderMeals(orderMeals);
            obj.setPayment(payment.get());

            invoices.add(obj);
        }

        return invoices;
    }

}
