package com.yummyyum.Services.Login;

import com.yummyyum.Model.Email;
import com.yummyyum.Model.Login;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

public interface LoginService {
    List<Login> getAllLogins();

    Login createNewLogin(Timestamp loginDate, Email email);

    List<Login> findLoginsByEmail(String email);

    Optional<Login> findLoginByEmailAndLoginDateContains(String email, String loginDate);

}
