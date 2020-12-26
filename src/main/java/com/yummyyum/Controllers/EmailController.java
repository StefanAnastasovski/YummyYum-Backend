package com.yummyyum.Controllers;

import com.yummyyum.Model.Email;
import com.yummyyum.Services.Email.EmailService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:8080")
public class EmailController {

    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping("/emails")
    public List<Email> getAllEmails() {
        return emailService.getAllEmails();
    }

    @GetMapping("/emails/email={email}")
    @ResponseBody
    public Map<String, Boolean> existsEmailByEmail(@PathVariable String email) {
        Map<String, Boolean> resultMap = new HashMap<>();
        if (emailService.existsEmailByEmail(email)) {
            resultMap.put("success", true);
        } else {
            resultMap.put("success", false);
        }
        return resultMap;
    }

    @GetMapping("/emails/email/{email}")
    public Optional<Email> getEmailByEmail(@PathVariable("email") String email) {
        return emailService.getEmailByEmail(email);
    }

    @GetMapping("/emails/user/{isuser}")
    public List<Email> getEmailsByIsUser(@PathVariable("isuser") Boolean isUser) {
        return emailService.getEmailsByIsUser(isUser);
    }

    @GetMapping("/emails/email/{email}/isuser/{isuser}")
    public Optional<Email> getEmailByEmailAndIsUser(@PathVariable("email") String email,
                                                    @PathVariable("isuser") Boolean isUser) {
        return emailService.getEmailByEmailAndIsUser(email, isUser);
    }

    @PostMapping("/emails")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Email createNewEmail(@RequestBody Email email,
                                HttpServletResponse response,
                                UriComponentsBuilder builder) {

        Email email1 = emailService.createNewEmail(email.getEmail(), email.getIsUser());

        response.setHeader("Location", builder.path("/api/emails/" + email.getId()).
                buildAndExpand(email.getId()).toUriString());

        return email1;
    }

}
