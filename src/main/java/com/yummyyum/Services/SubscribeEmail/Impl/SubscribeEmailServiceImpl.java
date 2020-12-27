package com.yummyyum.Services.SubscribeEmail.Impl;

import com.yummyyum.Model.Email;
import com.yummyyum.Model.SubscribeEmail;
import com.yummyyum.Repositories.EmailRepository;
import com.yummyyum.Repositories.SubscribeEmailRepository;
import com.yummyyum.Services.SubscribeEmail.SubscribeEmailService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class SubscribeEmailServiceImpl implements SubscribeEmailService {

    private final SubscribeEmailRepository subscribeEmailRepository;
    private final EmailRepository emailRepository;

    public SubscribeEmailServiceImpl(SubscribeEmailRepository subscribeEmailRepository, EmailRepository emailRepository) {
        this.subscribeEmailRepository = subscribeEmailRepository;
        this.emailRepository = emailRepository;
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
    public SubscribeEmail createNewSubscribeEmail(Timestamp subscribeDate, Email email) {

        SubscribeEmail subscribeEmail = new SubscribeEmail(subscribeDate);
        Email email1 = new Email(email.getEmail(), false);
        emailRepository.save(email1);
        subscribeEmail.setEmail(email1);
        return subscribeEmailRepository.save(subscribeEmail);
    }

}
