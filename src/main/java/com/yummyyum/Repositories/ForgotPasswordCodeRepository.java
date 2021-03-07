package com.yummyyum.Repositories;

import com.yummyyum.Model.ForgotPasswordCode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface ForgotPasswordCodeRepository extends JpaRepository<ForgotPasswordCode, Long> {

    Optional<ForgotPasswordCode> getForgotPasswordCodeByEmail(String email);

