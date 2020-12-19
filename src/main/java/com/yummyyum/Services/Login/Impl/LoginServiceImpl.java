package com.yummyyum.Services.Login.Impl;

import com.yummyyum.Model.Login;
import com.yummyyum.Repositories.LoginRepository;
import com.yummyyum.Services.Login.LoginService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {

    private final LoginRepository loginRepository;

    public LoginServiceImpl(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @Override
    public List<Login> getAllLogins() {

        return loginRepository.findAll();
    }

    @Override
    public Optional<Login> getLoginByEmail(String email) {
        return loginRepository.getLoginByEmail(email);
    }

    @Override
    public Login createNewLogin(String email, Timestamp loginDate) {

        Login login = new Login(email, loginDate);

        return loginRepository.save(login);

    }
}
