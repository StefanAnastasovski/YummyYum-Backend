package com.yummyyum.Repositories;

import com.yummyyum.Model.Email;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmailRepository extends JpaRepository<Email, Long> {

    Optional<Email> findEmailByEmail(String email);

    Boolean existsEmailByEmail(String email);

    Optional<Email> getEmailByEmailAndIsUser(String email, Boolean isUser);

    List<Email> getEmailsByIsUser(Boolean isUser);

    int countEmailByIsUser(Boolean isUser);

}
