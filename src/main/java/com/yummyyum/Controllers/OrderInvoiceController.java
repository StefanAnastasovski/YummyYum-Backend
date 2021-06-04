package com.yummyyum.Controllers;

import com.yummyyum.Model.*;
import com.yummyyum.Model.DTO.OrderInfoDTO;
import com.yummyyum.Model.DTO.OrderMealDTO;
import com.yummyyum.Model.DTO.PaymentInvoiceDTO;
import com.yummyyum.Model.DTO.UserOrderInfoPaymentDTO;
import com.yummyyum.Model.TernaryRelationships.UserOrderPaymentRelationship.UserOrderInfoPayment;
import com.yummyyum.Services.DeliveryAddress.DeliveryAddressService;
import com.yummyyum.Services.OrderInfo.OrderInfoService;
import com.yummyyum.Services.OrderMeals.OrderMealsService;
import com.yummyyum.Services.Payment.PaymentService;
import com.yummyyum.Services.User.UserService;
import com.yummyyum.Services.UserOrderInfoPayment.UserOrderInfoPaymentService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    private final DeliveryAddressService deliveryAddressService;

    public OrderInvoiceController(UserService userService,
                                  OrderInfoService orderInfoService, OrderMealsService orderMealsService,
                                  PaymentService paymentService,
                                  UserOrderInfoPaymentService userOrderInfoPaymentService, DeliveryAddressService deliveryAddressService) {
        this.userService = userService;
        this.orderInfoService = orderInfoService;
        this.orderMealsService = orderMealsService;
        this.paymentService = paymentService;
        this.userOrderInfoPaymentService = userOrderInfoPaymentService;
        this.deliveryAddressService = deliveryAddressService;
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
            Optional<DeliveryAddress> deliveryAddress =
                    deliveryAddressService.getDeliveryAddressByCardNumberId(payment.get().getPaymentNumberID());

            List<OrderMealDTO> orderMealsList = new ArrayList<>();

            // Order Meals
            for (OrderMeals orderMeal : orderMeals) {
                OrderMealDTO orderMealDTO = new OrderMealDTO();
                orderMealDTO.setDeliveryDate(orderMeal.getDeliveryDate());
                orderMealDTO.setDeliveryTime(orderMeal.getDeliveryTime());
                orderMealDTO.setMealName(orderMeal.getMealName());
                orderMealDTO.setMenuName(orderMeal.getMenuName());
                orderMealDTO.setCustomizeIt(orderMeal.getCustomizeIt());
                orderMealDTO.setServings(orderMeal.getServings());
                orderMealDTO.setPrice(orderMeal.getPrice());

                orderMealsList.add(orderMealDTO);
            }

            // Order Info
            OrderInfoDTO orderInfoDTO = new OrderInfoDTO();

            orderInfoDTO.setOrderDate(orderInfo.get().getOrderDate());
            orderInfoDTO.setOrderId(orderInfo.get().getOrderId());
            orderInfoDTO.setMealNumber(orderInfo.get().getMealNumber());
            orderInfoDTO.setServingNumber(orderInfo.get().getServingNumber());
            orderInfoDTO.setSubtotal(orderInfo.get().getSubtotal());
            orderInfoDTO.setTotal(orderInfo.get().getTotal());
            orderInfoDTO.setShippingCost(orderInfo.get().getShippingCost());

            // Payment
            PaymentInvoiceDTO paymentInvoiceDTO = new PaymentInvoiceDTO(
                    payment.get().getPaymentNumberID(), payment.get().getCardNumber(),
                    payment.get().getPaymentDate(), payment.get().getTotalAmount());

            //User OrderInfo Payment
            obj.setFirstName(user.get().getFirstName());
            obj.setLastName(user.get().getLastName());
            obj.setUsername(user.get().getUsername());
            obj.setDeliveryAddress(deliveryAddress.get().getAddress());
            obj.setDeliveryZipCode(deliveryAddress.get().getZipCode());
            obj.setOrderInfo(orderInfoDTO);
            obj.setOrderMeals(orderMealsList);
            obj.setPayment(paymentInvoiceDTO);

            invoices.add(obj);
        }

        return invoices;
    }

}
