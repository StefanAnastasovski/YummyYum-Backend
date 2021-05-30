package com.yummyyum.Services.Payment.Impl;

import com.yummyyum.Model.CreditCard;
import com.yummyyum.Model.User;
import com.yummyyum.Repositories.CreditCardRepository;
import com.yummyyum.Repositories.UserRepository;
import com.yummyyum.Services.Payment.CreditCardService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CreditCardServiceImpl implements CreditCardService {

    private final CreditCardRepository creditCardRepository;
    private final UserRepository userRepository;

    public CreditCardServiceImpl(CreditCardRepository creditCardRepository, UserRepository userRepository) {
        this.creditCardRepository = creditCardRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<CreditCard> getAllCreditCards() {
        return creditCardRepository.findAll();
    }

    @Override
    public List<CreditCard> getCreditCardByName(String name) {
        return creditCardRepository.getCreditCardByName(name);
    }

    @Override
    public Optional<CreditCard> getCreditCardByCardNumber(String cardNumber) {
         return creditCardRepository.getCreditCardByCardNumber(cardNumber);
    }

    @Override
    public Optional<CreditCard> getCreditCardByUsername(String username) {
        return creditCardRepository.getCreditCardByUsername(username);
    }

    @Override
    public CreditCard createCreditCard(String nameOnCard, String cardNumber,
                                    String expirationDateMonth, String expirationDateYear,
                                    String securityCode, Boolean isActive, String username) {

        Optional<User> user = userRepository.getUserByUsername(username);

        CreditCard creditCard = new CreditCard(nameOnCard,
                cardNumber, expirationDateMonth, expirationDateYear, securityCode, isActive);

        creditCard.setUser(user.get());

        return creditCardRepository.save(creditCard);
    }

}
