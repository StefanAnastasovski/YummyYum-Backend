package com.yummyyum.Controllers;

import com.yummyyum.Model.SubscriptionPlan;
import com.yummyyum.Services.SubscriptionPlan.SubscriptionPlanService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:8080")
public class SubscriptionPlanController {

    private final SubscriptionPlanService subscriptionPlanService;


    public SubscriptionPlanController(SubscriptionPlanService subscriptionPlanService) {
        this.subscriptionPlanService = subscriptionPlanService;
    }

    @GetMapping("/subscription-plan")
    public List<SubscriptionPlan> getAllSubscriptionPlans() {
        return subscriptionPlanService.getAllSubscriptionPlans();
    }

    @GetMapping("/subscription-plan/name={name}")
    public Optional<SubscriptionPlan> getSubscriptionPlanByName(@PathVariable("name") String name) {
        return subscriptionPlanService.getSubscriptionPlanByName(name);
    }

    @GetMapping("/subscription-plan/is-active={isActive}")
    public List<SubscriptionPlan> getAllSubscriptionPlansByIsActive(@PathVariable("isActive") Boolean isActive) {
        return subscriptionPlanService.getAllSubscriptionPlansByIsActive(isActive);
    }

    @PostMapping("/subscription-plan")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public SubscriptionPlan createNewSubscriptionPlan(@RequestBody SubscriptionPlan subscriptionPlan,
                                                      HttpServletResponse response,
                                                      UriComponentsBuilder builder) {

        return subscriptionPlanService.createNewSubscriptionPlan(subscriptionPlan.getName(),
                subscriptionPlan.getIsActive());
    }

    @PutMapping("/subscription-plan/name={name}")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public SubscriptionPlan updateSubscriptionPlan(@RequestBody SubscriptionPlan subscriptionPlan,
                                                   @PathVariable("name") String name,
                                                   HttpServletResponse response,
                                                   UriComponentsBuilder builder) {

        return subscriptionPlanService.updateSubscriptionPlan(subscriptionPlan.getName(),
                subscriptionPlan.getIsActive(), name);
    }

}
