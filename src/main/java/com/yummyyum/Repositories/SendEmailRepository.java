package com.yummyyum.Repositories;

import com.yummyyum.Model.SendEmail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SendEmailRepository extends JpaRepository<SendEmail, Long> {

    Optional<SendEmail> getSendEmailByRecipient(String recipient);


}
