package com.yummyyum.Services.Email.Impl;

import com.yummyyum.Model.Email;
import com.yummyyum.Repositories.EmailRepository;
import com.yummyyum.Services.Email.EmailService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmailServiceImpl implements EmailService {

    private final EmailRepository emailRepository;

    public EmailServiceImpl(EmailRepository emailRepository) {
        this.emailRepository = emailRepository;
    }


    @Override
    public List<Email> getAllEmails() {
        return emailRepository.findAll();
    }

    @Override
    public Optional<Email> getEmailByEmail(String email) {
        return emailRepository.getEmailByEmail(email);
    }

    @Override
    public List<Email> getEmailsByIsAccount(Boolean isAccount) {
        return emailRepository.getEmailsByIsAccount(isAccount);
    }


    @Override
    public Email createNewEmail(String email, Boolean isAccount) {

        Email email1 = new Email(email, isAccount);

        return emailRepository.save(email1);
    }

}
