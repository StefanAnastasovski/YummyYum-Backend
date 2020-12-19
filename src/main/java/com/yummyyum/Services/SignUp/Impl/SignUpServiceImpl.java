package com.yummyyum.Services.SignUp.Impl;

import com.yummyyum.Model.SignUp;

import com.yummyyum.Repositories.SignUpRepository;
import com.yummyyum.Services.SignUp.SignUpService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SignUpServiceImpl implements SignUpService {

    private final SignUpRepository signUpRepository;

    public SignUpServiceImpl(SignUpRepository signUpRepository) {
        this.signUpRepository = signUpRepository;
    }

    @Override
    public List<SignUp> getAllSignUps() {

        return signUpRepository.findAll();
    }

    @Override
    public Optional<SignUp> getSignUpByUsername(String username) {
        return signUpRepository.getSignUpByUsername(username);
    }

    @Override
    public SignUp createNewSignUp(String firstName, String lastName,
                                  String username, String password,
                                  String email, String signUpDate) {

        SignUp signUp = new SignUp(firstName, lastName, username, password, email, signUpDate);

        return signUpRepository.save(signUp);

    }
}
