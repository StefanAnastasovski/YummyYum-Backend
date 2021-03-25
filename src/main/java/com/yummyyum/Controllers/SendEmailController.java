package com.yummyyum.Controllers;

import com.yummyyum.Model.DTO.SendEmailDTO;
import com.yummyyum.Model.SendEmail;
import com.yummyyum.Services.SendEmailToSubscribers.SendEmailToSubscribersService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:8080")
public class SendEmailController {

    private final SendEmailToSubscribersService sendEmailToSubscribersService;

    public SendEmailController(SendEmailToSubscribersService sendEmailToSubscribersService) {
        this.sendEmailToSubscribersService = sendEmailToSubscribersService;
    }

    @GetMapping("/subscribe/email/")
    public List<SendEmail> getAllEmails() {
        return sendEmailToSubscribersService.getAllSendEmails();
    }


    @GetMapping("/subscribe/email={email}")
    public Optional<SendEmail> getSendEmailByRecipient(@PathVariable("email") String email) {
        return sendEmailToSubscribersService.getSendEmailByEmail(email);
    }

    @PostMapping("/subscribe/email")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public SendEmailDTO createNewSendEmail(@RequestBody SendEmailDTO sendEmailDTO,
                                           HttpServletResponse response,
                                           UriComponentsBuilder builder) throws Exception {

        return sendEmailToSubscribersService.createNewSendEmail(sendEmailDTO.getSubject(), sendEmailDTO.getText(),
                sendEmailDTO.getRecipients());
    }


}
