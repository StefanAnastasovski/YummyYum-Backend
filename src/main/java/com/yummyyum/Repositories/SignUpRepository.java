package com.yummyyum.Repositories;
import com.yummyyum.Model.SignUp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SignUpRepository extends JpaRepository<SignUp, Long> {
    Optional<SignUp> getSignUpByUsername(String username);
}
