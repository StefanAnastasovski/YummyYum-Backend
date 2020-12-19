package com.yummyyum.Services.SubscribeEmail.Impl;

import com.yummyyum.Model.SubscribeEmail;
import com.yummyyum.Repositories.SubscribeEmailRepository;
import com.yummyyum.Services.SubscribeEmail.SubscribeEmailService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class SubscribeEmailServiceImpl implements SubscribeEmailService {

    private final SubscribeEmailRepository subscribeEmailRepository;

    public SubscribeEmailServiceImpl(SubscribeEmailRepository subscribeEmailRepository) {
        this.subscribeEmailRepository = subscribeEmailRepository;
    }

    @Override
    public List<SubscribeEmail> getAllSubscribeEmails() {
        return subscribeEmailRepository.findAll();
    }

    @Override
    public Optional<SubscribeEmail> getSubscribeEmailByEmail(String email) {
        return subscribeEmailRepository.getSubscribeEmailByEmail(email);
    }

    @Override
    public SubscribeEmail createNewSubscribeEmail(String email, Timestamp subscribeDate) {

        SubscribeEmail subscribeEmail = new SubscribeEmail(email, subscribeDate);

        return subscribeEmailRepository.save(subscribeEmail);
    }

}
