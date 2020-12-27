package com.yummyyum.Services.Login.Impl;

import com.yummyyum.Model.Email;
import com.yummyyum.Model.Login;
import com.yummyyum.Repositories.EmailRepository;
import com.yummyyum.Repositories.LoginRepository;
import com.yummyyum.Services.Login.LoginService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {

    private final LoginRepository loginRepository;
    private final EmailRepository emailRepository;

    public LoginServiceImpl(LoginRepository loginRepository,
                            EmailRepository emailRepository) {
        this.loginRepository = loginRepository;
        this.emailRepository = emailRepository;
    }

    @Override
    public List<Login> getAllLogins() {
        return loginRepository.findAll();
    }


    @Override
    public Login createNewLogin(Timestamp loginDate, Email email) {

        Login login = new Login(loginDate);
        Optional<Email> emailData = emailRepository.findEmailByEmail(email.getEmail());
        login.setEmail(emailData.get());

        return loginRepository.save(login);

    }

    @Override
    public List<Login> findLoginsByEmail(String email) {
        return loginRepository.findLoginsByEmail(email);
    }

    @Override
    public Optional<Login> findLoginByEmailAndLoginDateContains(String email, String loginDate) {
        return loginRepository.findLoginByEmailAndLoginDateContains(email, loginDate);
    }

}
