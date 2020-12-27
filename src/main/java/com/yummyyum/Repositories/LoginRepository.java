package com.yummyyum.Repositories;

import com.yummyyum.Model.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface LoginRepository extends JpaRepository<Login, Long> {

    @Query(value = "SELECT *" +
            " FROM login as l " +
            "JOIN email e ON e.id = l.email_id " +
            "WHERE e.email = :email",
            nativeQuery = true)
    List<Login> findLoginsByEmail(String email);

    @Query(value = "SELECT *" +
            " FROM login as l " +
            "JOIN email e ON e.id = l.email_id " +
            "WHERE e.email = :email and l.login_date like :loginDate%",
            nativeQuery = true)
    Optional<Login> findLoginByEmailAndLoginDateContains(String email, String loginDate);
}
