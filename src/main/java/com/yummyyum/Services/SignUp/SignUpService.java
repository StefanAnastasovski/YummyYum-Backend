package com.yummyyum.Services.SignUp;

import com.yummyyum.Model.SignUp;

import java.util.List;
import java.util.Optional;

public interface SignUpService {

    List<SignUp> getAllSignUps();

    Optional<SignUp> getSignUpByUsername(String username);

    SignUp createNewSignUp(String firstName, String lastName,
                           String username, String password,
                           String email, String signUpDate);

}
