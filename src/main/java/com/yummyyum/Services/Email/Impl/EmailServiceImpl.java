package com.yummyyum.Services.Email.Impl;

import com.yummyyum.Model.Email;
import com.yummyyum.Model.User;
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
    public List<Email> getEmailsByIsUser(Boolean isUser) {
        return emailRepository.getEmailsByIsUser(isUser);
    }

    @Override
    public Optional<Email> getEmailByEmailAndIsUser(String email, Boolean isUser) {
        return emailRepository.getEmailByEmailAndIsUser(email, isUser);
    }

    @Override
    public Boolean existsEmailByEmail(String email) {
        return emailRepository.existsEmailByEmail(email);
    }

    @Override
    public Email createNewEmail(String email, Boolean isUser) {

        Email email1 = new Email(email, isUser);

        return emailRepository.save(email1);
    }

}
