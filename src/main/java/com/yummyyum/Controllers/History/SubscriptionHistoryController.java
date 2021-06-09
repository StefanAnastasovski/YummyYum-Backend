package com.yummyyum.Controllers.History;


import com.yummyyum.Model.History.SubscriptionHistory;
import com.yummyyum.Services.History.SubscriptionHistory.SubscriptionHistoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:8080")
public class SubscriptionHistoryController {

    private final SubscriptionHistoryService subscriptionHistoryService;

    public SubscriptionHistoryController(SubscriptionHistoryService subscriptionHistoryService) {
        this.subscriptionHistoryService = subscriptionHistoryService;
    }

    @GetMapping("/subscription/history/username={username}")
    public List<SubscriptionHistory> getAllSubscriptionHistoryHistoriesByUsername(@PathVariable("username") String username) {
        return subscriptionHistoryService.getAllSubscriptionHistoryHistoriesByUsername(username);
    }

    @PostMapping("/subscription/history/username={username}")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public SubscriptionHistory createNewSubscriptionHistory(@RequestBody SubscriptionHistory subscriptionHistory,
                                                            @PathVariable("username") String username,
                                                            HttpServletResponse response,
                                                            UriComponentsBuilder builder) throws Exception {

        return subscriptionHistoryService.createNewSubscriptionHistoryHistory(subscriptionHistory.getSubscriptionPlan(),
                subscriptionHistory.getNumberOfWeeklyMeals(), subscriptionHistory.getServingsPerMeal(),
                subscriptionHistory.getSubscriptionType(), subscriptionHistory.getWeeklyDeliveryDay(),
                subscriptionHistory.getWeeklyDeliveryTime(), username);

    }
}
