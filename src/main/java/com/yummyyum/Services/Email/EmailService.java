package com.yummyyum.Services.Email;

import com.yummyyum.Model.Email;

import java.util.List;
import java.util.Optional;

public interface EmailService {

    List<Email> getAllEmails();

    Optional<Email> getEmailByEmail(String email);

    List<Email> getEmailsByIsAccount(Boolean isAccount);

    Email createNewEmail(String email, Boolean isAccount);
    
}
