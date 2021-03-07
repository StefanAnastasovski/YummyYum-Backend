package com.yummyyum.Controllers;

import com.yummyyum.Model.Email;
import com.yummyyum.Model.ForgotPasswordCode;
import com.yummyyum.Repositories.EmailRepository;
import com.yummyyum.Repositories.ForgotPasswordCodeRepository;
import com.yummyyum.Services.ForgotPasswordCode.ForgotPasswordCodeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:8080")
public class ForgotPasswordCodeController {

    private final ForgotPasswordCodeService forgotPasswordCodeService;
    private final ForgotPasswordCodeRepository forgotPasswordCodeRepository;
    private final EmailRepository emailRepository;

    public ForgotPasswordCodeController(ForgotPasswordCodeService forgotPasswordCodeService,
                                        ForgotPasswordCodeRepository forgotPasswordCodeRepository,
                                        EmailRepository emailRepository) {
        this.forgotPasswordCodeService = forgotPasswordCodeService;
        this.forgotPasswordCodeRepository = forgotPasswordCodeRepository;
        this.emailRepository = emailRepository;
    }


    @GetMapping("/forgot-password/codes")
    public List<ForgotPasswordCode> getAllCodes() {
        return forgotPasswordCodeService.getAllCodes();
    }

    @GetMapping("/forgot-password/codes/email={email}")
    public Optional<ForgotPasswordCode> getAllCodes(@PathVariable("email") String email) {
        return forgotPasswordCodeService.getCodeByEmail(email);
    }

    @PostMapping("/forgot-password")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ForgotPasswordCode createNewForgotPasswordCode(@RequestBody ForgotPasswordCode forgotPasswordCode,
                                                          HttpServletResponse response,
                                                          UriComponentsBuilder builder) {

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

        response.setHeader("Location", builder.path("/api/forgot-password/" + forgotPasswordCode1.getId()).
                buildAndExpand(forgotPasswordCode1.getId()).toUriString());

        return forgotPasswordCode1;

    }

}
