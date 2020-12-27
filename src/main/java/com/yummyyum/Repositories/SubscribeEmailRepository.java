package com.yummyyum.Repositories;

import com.yummyyum.Model.SubscribeEmail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface SubscribeEmailRepository extends JpaRepository<SubscribeEmail, Long> {

    @Query(value = "SELECT * FROM subscribe_email as se join email e on e.id = se.email_id",
            nativeQuery = true)
    Optional<SubscribeEmail> getSubscribeEmailByEmail(String email);

}
