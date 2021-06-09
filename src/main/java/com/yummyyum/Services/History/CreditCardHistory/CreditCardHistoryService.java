package com.yummyyum.Services.History.CreditCardHistory;

import com.yummyyum.Model.History.CreditCardHistory;

import java.util.List;

public interface CreditCardHistoryService {

    List<CreditCardHistory> getAllCreditCardHistoriesByUsername(String username);

    CreditCardHistory createNewCreditCardHistory(String nameOnCard, String cardNumber, String expirationDateMonth,
                                                 String expirationDateYear, String username);

}
