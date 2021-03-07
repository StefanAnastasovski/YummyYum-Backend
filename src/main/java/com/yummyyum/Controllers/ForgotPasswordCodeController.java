package com.yummyyum.Controllers;

import com.yummyyum.Model.Email;
import com.yummyyum.Model.ForgotPasswordCode;
import com.yummyyum.Repositories.EmailRepository;
import com.yummyyum.Services.ForgotPasswordCode.ForgotPasswordCodeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:8080")
public class ForgotPasswordCodeController {

    private final ForgotPasswordCodeService forgotPasswordCodeService;
    private final EmailRepository emailRepository;

    public ForgotPasswordCodeController(ForgotPasswordCodeService forgotPasswordCodeService,
                                        EmailRepository emailRepository) {
        this.forgotPasswordCodeService = forgotPasswordCodeService;
        this.emailRepository = emailRepository;
    }


    @GetMapping("/forgot-password/codes")
    public List<ForgotPasswordCode> getAllCodes() {
        return forgotPasswordCodeService.getAllCodes();
    }

    @GetMapping("/forgot-password/codes/email={email}")
    public HashMap<String, String> getAllCodes(@PathVariable("email") String email) {
        HashMap<String, String> map = new HashMap<>();
        Optional<ForgotPasswordCode> forgotPasswordCode = forgotPasswordCodeService.getCodeByEmail(email);
        map.put("code", forgotPasswordCode.get().getCode());
        map.put("email", forgotPasswordCode.get().getEmail());
        return map;
    }

    @PostMapping("/forgot-password")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ForgotPasswordCode createNewForgotPasswordCode(@RequestBody ForgotPasswordCode forgotPasswordCode,
                                                          HttpServletResponse response,
                                                          UriComponentsBuilder builder) throws Exception, IOException {

        Optional<ForgotPasswordCode> forgotPasswordCode2 =
                forgotPasswordCodeService.getCodeByEmail(forgotPasswordCode.getEmail());

        Optional<Email> email = emailRepository.findEmailByEmail(forgotPasswordCode.getEmail());

        ForgotPasswordCode forgotPasswordCode1 = null;

        if (!email.isEmpty()) {
            if (forgotPasswordCode2.isEmpty()) {

                forgotPasswordCode1 = forgotPasswordCodeService.createNewForgotPasswordCode(
                        forgotPasswordCode.getEmail(), forgotPasswordCode.getCodeSentDate(), false);

            } else {

                Timestamp timestamp = new Timestamp(System.currentTimeMillis());

                forgotPasswordCode1 = forgotPasswordCodeService.createNewForgotPasswordCode(
                        forgotPasswordCode2.get().getEmail(), timestamp, true);

            }

        } else {
            System.out.println("Email is not existing");
        }

        return forgotPasswordCode1;

    }

}
