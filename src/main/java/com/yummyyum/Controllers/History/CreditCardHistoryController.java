package com.yummyyum.Controllers.History;

import com.yummyyum.Model.History.CreditCardHistory;
import com.yummyyum.Services.History.CreditCardHistory.CreditCardHistoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:8080")
public class CreditCardHistoryController {

    private final CreditCardHistoryService creditCardHistoryService;

    public CreditCardHistoryController(CreditCardHistoryService creditCardHistoryService) {
        this.creditCardHistoryService = creditCardHistoryService;
    }

    @GetMapping("/credit-card/history/username={username}")
    public List<CreditCardHistory> getAllCreditCardHistoriesByUsername(@PathVariable("username") String username) {
        return creditCardHistoryService.getAllCreditCardHistoriesByUsername(username);
    }

    @PostMapping("/credit-card/history/username={username}")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public CreditCardHistory createNewCreditCardHistory(@RequestBody CreditCardHistory creditCardHistory,
                                                                  @PathVariable("username") String username,
                                                                  HttpServletResponse response,
                                                                  UriComponentsBuilder builder) throws Exception {

        return creditCardHistoryService.createNewCreditCardHistory(creditCardHistory.getNameOnCard(),
                creditCardHistory.getCardNumber(), creditCardHistory.getExpirationDateMonth(),
                creditCardHistory.getExpirationDateYear(), username);

    }

}
