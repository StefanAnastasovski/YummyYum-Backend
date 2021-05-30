package com.yummyyum.Controllers;

import com.yummyyum.Model.CreditCard;
import com.yummyyum.Services.Payment.CreditCardService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:8080")
public class CreditCardController {

    private final CreditCardService creditCardService;

    public CreditCardController(CreditCardService creditCardService) {
        this.creditCardService = creditCardService;
    }

    @GetMapping("/credit-card")
    public List<CreditCard> getAllCreditCards() {
        return creditCardService.getAllCreditCards();
    }

    @GetMapping("/credit-card/name/{name}")
    public List<CreditCard> getCreditCardByName(@PathVariable("name") String name) {
        return creditCardService.getCreditCardByName(name);
    }

    @GetMapping("/credit-card/cardNumber/{cardNumber}")
    public Optional<CreditCard> getCreditCardBCardNumber(@PathVariable("cardNumber")
                                                                 String cardNumber) {
        return creditCardService.getCreditCardByCardNumber(cardNumber);
    }

    @GetMapping("/credit-card/username/{username}")
    public Optional<CreditCard> getCreditCardByUsername(@PathVariable("username") String username) {
        return creditCardService.getCreditCardByUsername(username);
    }

    @PostMapping("/credit-card/username/{username}")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public CreditCard createNewCreditCard(@RequestBody CreditCard creditCard,
                                          @PathVariable("username") String username,
                                          HttpServletResponse response,
                                          UriComponentsBuilder builder) {

        CreditCard creditCard1 = creditCardService.createCreditCard(creditCard.getNameOnCard(),
                creditCard.getCardNumber(), creditCard.getExpirationDateMonth(),
                creditCard.getExpirationDateYear(), creditCard.getSecurityCode(),
                creditCard.getIsActive(), username);
        response.setHeader("Location", builder.path("/api/credit-card/" + creditCard.getId()).
                buildAndExpand(creditCard.getId()).toUriString());

        return creditCard1;
    }

}
