package com.yummyyum.Repositories;

import com.yummyyum.Model.SubscribeEmail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SubscribeEmailRepository extends JpaRepository<SubscribeEmail, Long> {
    Optional<SubscribeEmail> getSubscribeEmailByEmail(String email);
}
