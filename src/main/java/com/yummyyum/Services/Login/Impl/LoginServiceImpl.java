package com.yummyyum.Services.Login.Impl;

import com.yummyyum.Model.Login;
import com.yummyyum.Model.User;
import com.yummyyum.Repositories.LoginRepository;
import com.yummyyum.Repositories.UserRepository;
import com.yummyyum.Services.Login.LoginService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {

    private final LoginRepository loginRepository;
    private final UserRepository userRepository;

    public LoginServiceImpl(LoginRepository loginRepository, UserRepository userRepository) {
        this.loginRepository = loginRepository;
        this.userRepository = userRepository;
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
        Optional<User> userData = userRepository.getUserByEmail(email);
        login.setUser(userData.get());

        return loginRepository.save(login);

    }
}
