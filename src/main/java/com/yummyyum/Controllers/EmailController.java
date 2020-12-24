package com.yummyyum.Controllers;

import com.yummyyum.Model.Email;
import com.yummyyum.Services.Email.EmailService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:8080")
public class EmailController {

    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping("/getallemails")
    public List<Email> getAllEmails() {
        return emailService.getAllEmails();
    }

    @GetMapping("/getemailbyemail/{email}")
    public Optional<Email> getEmailByEmail(@PathVariable("email") String email) {
        return emailService.getEmailByEmail(email);
    }

    @GetMapping("/getemailbyisaccount/{isaccount}")
    public List<Email> getEmailsByIsAccount(@PathVariable("isaccount") Boolean isAccount) {
        return emailService.getEmailsByIsAccount(isAccount);
    }


    @PostMapping("/createemail")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Email createNewEmail(@RequestBody Email email,
                                HttpServletResponse response,
                                UriComponentsBuilder builder) {

        Email email1 = emailService.createNewEmail(email.getEmail(), email.getIsAccount());

        response.setHeader("Location", builder.path("/api/createemail/" + email.getId()).
                buildAndExpand(email.getId()).toUriString());

        return email1;
    }

}
