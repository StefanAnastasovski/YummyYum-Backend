package com.yummyyum.Bootstrap;

import com.yummyyum.Model.Login;
import com.yummyyum.Model.SignUp;
import com.yummyyum.Repositories.LoginRepository;
import com.yummyyum.Repositories.SignUpRepository;
import org.springframework.stereotype.Component;
import org.springframework.boot.CommandLineRunner;

import java.sql.Timestamp;

@Component
public class BootstrapData  implements CommandLineRunner {

    private final SignUpRepository signUpRepository;
    private final LoginRepository loginRepository;

    public BootstrapData(SignUpRepository signUpRepository, LoginRepository loginRepository) {
        this.signUpRepository = signUpRepository;
        this.loginRepository = loginRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        SignUp signup1 = new SignUp("Stefan", "Annnnnnn", "Stevo",
                "1234", "stefanA@mail.com", "today");
        signUpRepository.save(signup1);

        Login login1 = new Login("stefan@gmail.com", Timestamp.valueOf("2018-11-12 01:02:03.123456789"));
        loginRepository.save(login1);
    }

}
