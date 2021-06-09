package com.yummyyum.Services.History.CreditCardHistory.Impl;

import com.yummyyum.Model.History.CreditCardHistory;
import com.yummyyum.Model.User;
import com.yummyyum.Repositories.History.CreditCardHistoryRepository;
import com.yummyyum.Repositories.UserRepository;
import com.yummyyum.Services.History.CreditCardHistory.CreditCardHistoryService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CreditCardHistoryServiceImpl implements CreditCardHistoryService {

    private final CreditCardHistoryRepository creditCardHistoryRepository;
    private final UserRepository userRepository;

    public CreditCardHistoryServiceImpl(CreditCardHistoryRepository creditCardHistoryRepository,
                                        UserRepository userRepository) {
        this.creditCardHistoryRepository = creditCardHistoryRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<CreditCardHistory> getAllCreditCardHistoriesByUsername(String username) {
        return creditCardHistoryRepository.getCreditCardHistoriesByUsername(username);
    }

    @Override
    public CreditCardHistory createNewCreditCardHistory(String nameOnCard, String cardNumber, String expirationDateMonth,
                                                        String expirationDateYear, String username) {
        CreditCardHistory creditCardHistory = new CreditCardHistory(nameOnCard, cardNumber, expirationDateMonth,
                expirationDateYear, false, new Date());
        Optional<User> user = userRepository.getUserByUsername(username);
        creditCardHistory.setUser(user.get());

        return creditCardHistoryRepository.save(creditCardHistory);
    }

}
