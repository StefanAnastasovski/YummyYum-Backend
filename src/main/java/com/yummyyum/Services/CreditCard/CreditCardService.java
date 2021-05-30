package com.yummyyum.Services.CreditCard;

import com.yummyyum.Model.CreditCard;

import java.util.List;
import java.util.Optional;

public interface CreditCardService {

    List<CreditCard> getAllCreditCards();

    List<CreditCard> getCreditCardByName(String name);

    Optional<CreditCard> getCreditCardByCardNumber(String cardNumber);

    Optional<CreditCard> getCreditCardByUsername(String username);

    CreditCard createCreditCard(String nameOnCard, String cardNumber,
                                String expirationDateMonth, String expirationDateYear,
                                String securityCode, Boolean isActive, String username);

    CreditCard updateCreditCard(String nameOnCard, String cardNumber,
                                String expirationDateMonth, String expirationDateYear,
                                String securityCode, Boolean isActive, String username);

}
