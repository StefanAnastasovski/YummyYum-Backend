package com.yummyyum.Controllers;

import com.yummyyum.Model.DTO.SubscriptionDTO;
import com.yummyyum.Model.DTO.UserSubscriptionPaymentDTO;
import com.yummyyum.Model.Subscription;
import com.yummyyum.Services.Subscription.SubscriptionService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:8080")
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    public SubscriptionController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @GetMapping("/subscription")
    public List<Subscription> getAllSubscriptions() {
        return subscriptionService.getAllSubscriptions();
    }

    @GetMapping("/subscription/username={username}")
    public SubscriptionDTO getSubscriptionByUsername(@PathVariable("username") String username) {
        return subscriptionService.getSubscriptionByUsername(username);
    }

    @GetMapping("/subscription/subscription-plan-name={name}")
    public SubscriptionDTO getSubscriptionBySubscriptionPlanName(@PathVariable("name") String subscriptionPlanName) {
        return subscriptionService.getSubscriptionBySubscriptionPlanName(subscriptionPlanName);
    }

    @GetMapping("/subscription/id/subscription-plan-name={name}")
    public Long getSubscriptionIdBySubscriptionPlanName(@PathVariable("name") String subscriptionPlanName) {
        return subscriptionService.getSubscriptionIdBySubscriptionPlanName(subscriptionPlanName);
    }

    @GetMapping("/subscription/is-canceled={isCanceled}")
    public List<Subscription> getAllSubscriptionsByIsCanceled(@PathVariable("isCanceled") Boolean isCanceled) {
        return subscriptionService.getAllSubscriptionsByIsCanceled(isCanceled);
    }

    @GetMapping("/subscription/activation-date={activationDate}")
    public List<Subscription> getAllSubscriptionsByActivationDate(@PathVariable("activationDate")
                                                                  @DateTimeFormat(pattern = "yyyy-MM-dd")
                                                                          LocalDate activationDate) {
        return subscriptionService.getAllSubscriptionsByActivationDate(activationDate);
    }

    @GetMapping("/subscription/canceled-date={canceledDate}")
    public List<Subscription> getAllSubscriptionsByCanceledDate(@PathVariable("canceledDate")
                                                                @DateTimeFormat(pattern = "yyyy-MM-dd")
                                                                        LocalDate canceledDate) {
        return subscriptionService.getAllSubscriptionsByCanceledDate(canceledDate);
    }

    @PostMapping("/subscription")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Subscription createNewSubscription(@RequestBody UserSubscriptionPaymentDTO userSubscriptionPaymentDTO,
                                              HttpServletResponse response,
                                              UriComponentsBuilder builder) {

        return subscriptionService.createNewSubscription(userSubscriptionPaymentDTO.getSubscription(),
                userSubscriptionPaymentDTO.getSubscriptionPlan(), userSubscriptionPaymentDTO.getUsername(),
                userSubscriptionPaymentDTO.getCardNumber(), userSubscriptionPaymentDTO.getTotalAmount(),
                userSubscriptionPaymentDTO.getAddress(), userSubscriptionPaymentDTO.getZipCode());
    }

//    @Override
//    public PaymentInfoDTO createNewPayment(String paymentID, String cardNumber, Date paymentDate, Float totalAmount,
//                                           String address, String zipCode,
//                                           String username, String orderInfoId, String couponName) {
//
//        Payment payment = new Payment(paymentID, cardNumber, paymentDate, totalAmount);
//        DeliveryAddress deliveryAddress = new DeliveryAddress(address, zipCode);
//
//
//        Optional<User> user = userRepository.getUserByUsername(username);
//
//        Optional<OrderInfo> orderInfo = orderInfoRepository.getOrderInfoByOrderId(orderInfoId);
//
//        PaymentInfoDTO newPaymentInfoDTO = new PaymentInfoDTO(cardNumber, totalAmount, address,
//                zipCode, username, orderInfoId, paymentID, couponName);
//
//        if (couponName != null) {
//            Optional<Coupon> coupon = couponRepository.getCouponByCouponName(couponName);
//            payment.setCoupon(coupon.get());
//
//            newPaymentInfoDTO.setCouponName(coupon.get().getCouponName());
//        }
//
//        paymentRepository.save(payment);
//
//        Optional<Payment> createdPayment = paymentRepository.getPaymentByPaymentNumberID(paymentID);
//        UserOrderInfoPaymentId userOrderInfoPaymentId = new UserOrderInfoPaymentId(user.get().getId(),
//                orderInfo.get().getId(),
//                createdPayment.get().getId());
//        UserOrderInfoPayment userOrderInfoPayment = new UserOrderInfoPayment();
//        userOrderInfoPayment.setId(userOrderInfoPaymentId);
//        userOrderInfoPaymentRepository.save(userOrderInfoPayment);
//        deliveryAddress.setPayment(createdPayment.get());
//        deliveryAddressRepository.save(deliveryAddress);
//
//        return newPaymentInfoDTO;
//
//    }

    @PutMapping("/subscription/subscription-plan-name={name}")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Subscription updateSubscription(@RequestBody Subscription subscription,
                                           @PathVariable("name") String subscriptionPlanName,
                                           HttpServletResponse response,
                                           UriComponentsBuilder builder) {


        return subscriptionService.updateSubscription(subscription.getNumberOfWeeklyMeals(),
                subscription.getServingsPerMeal(),
                subscription.getSubscriptionType(),
                subscription.getWeeklyDeliveryDay(),
                subscription.getWeeklyDeliveryTime(),
                subscription.getIsCanceled(),
                subscription.getActivationDate(),
                subscription.getCanceledDate(), subscriptionPlanName);
    }
}
