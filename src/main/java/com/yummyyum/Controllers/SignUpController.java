package com.yummyyum.Controllers;

import com.yummyyum.Model.SignUp;
import com.yummyyum.Services.SignUp.SignUpService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:8080")
public class SignUpController {

    private final SignUpService signUpService;

    public SignUpController(SignUpService signUpService) {
        this.signUpService = signUpService;

    }

    @GetMapping("/getallsignups")
    public List<SignUp> getAllSignUps() {
        return signUpService.getAllSignUps();
    }

    @GetMapping("/getsignupbyusername/{username}")
    public Optional<SignUp> getSignUpByUsername(@PathVariable String username) {
        return signUpService.getSignUpByUsername(username);
    }

    @PostMapping("/createsignup")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public SignUp createNewSignUp(@RequestBody SignUp signUp,
                                  HttpServletResponse response,
                                  UriComponentsBuilder builder) {

        SignUp signUp1 = signUpService.createNewSignUp(signUp.getFirstName(), signUp.getLastName(),
                signUp.getUsername(), signUp.getPassword(), signUp.getEmail(), signUp.getSignUpDate());

        response.setHeader("Location", builder.path("/api/createsignup/" + signUp.getId()).
                buildAndExpand(signUp1.getId()).toUriString());

        return signUp1;
    }
}
