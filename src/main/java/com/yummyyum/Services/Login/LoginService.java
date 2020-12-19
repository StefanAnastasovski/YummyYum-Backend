package com.yummyyum.Services.Login;

import com.yummyyum.Model.Login;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

public interface LoginService {
    List<Login> getAllLogins();

    Optional<Login> getLoginByEmail(String email);

    Login createNewLogin(String email, Timestamp loginDate);

}
