package com.yummyyum.Controllers;

import com.yummyyum.Model.DTO.SubscriptionDTO;
import com.yummyyum.Model.Subscription;
import com.yummyyum.Services.Subscription.SubscriptionService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.util.List;

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
        System.out.println(activationDate);
        return subscriptionService.getAllSubscriptionsByActivationDate(activationDate);
    }

    @GetMapping("/subscription/canceled-date={canceledDate}")
    public List<Subscription> getAllSubscriptionsByCanceledDate(@PathVariable("canceledDate")
                                                                @DateTimeFormat(pattern = "yyyy-MM-dd")
                                                                        LocalDate canceledDate) {
        return subscriptionService.getAllSubscriptionsByCanceledDate(canceledDate);
    }

    @PostMapping("/subscription/subscription-plan-name={name}")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Subscription createNewSubscription(@RequestBody Subscription subscription,
                                              @PathVariable("name") String subscriptionPlanName,
                                              HttpServletResponse response,
                                              UriComponentsBuilder builder) {

        return subscriptionService.createNewSubscription(subscription.getNumberOfWeeklyMeals(),
                subscription.getServingsPerMeal(),
                subscription.getSubscriptionType(),
                subscription.getWeeklyDeliveryDay(),
                subscription.getWeeklyDeliveryTime(),
                subscription.getIsCanceled(),
                subscription.getActivationDate(),
                subscription.getCanceledDate(), subscriptionPlanName);
    }

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
