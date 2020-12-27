package com.yummyyum.Services.Email;

import com.yummyyum.Model.Email;

import java.util.List;
import java.util.Optional;

public interface EmailService {

    List<Email> getAllEmails();

    Optional<Email> findEmailByEmail(String email);

    List<Email> getEmailsByIsUser(Boolean isUser);

    Optional<Email> getEmailByEmailAndIsUser(String email, Boolean isUser);

    Boolean existsEmailByEmail(String email);

    Email createNewEmail(String email, Boolean isUser);

}
