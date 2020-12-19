package com.yummyyum.Repositories;

import com.yummyyum.Model.Login;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoginRepository extends JpaRepository<Login, Long>{
    Optional<Login> getLoginByEmail(String email);
}
