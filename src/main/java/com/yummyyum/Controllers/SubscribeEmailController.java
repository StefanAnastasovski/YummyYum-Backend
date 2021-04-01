package com.yummyyum.Controllers;


import com.yummyyum.Model.SubscribeEmail;
import com.yummyyum.Services.SubscribeEmail.SubscribeEmailService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:8080")
public class SubscribeEmailController {

    private final SubscribeEmailService subscribeEmailService;


    public SubscribeEmailController(SubscribeEmailService subscribeEmailService) {
        this.subscribeEmailService = subscribeEmailService;
    }

    @GetMapping("/subscribe")
    public List<SubscribeEmail> getAllSubscribeEmails() {
        return subscribeEmailService.getAllSubscribeEmails();
    }

    @GetMapping("/subscribe/email/{email}")
    public Optional<SubscribeEmail> getSubscribeEmailByEmail(@PathVariable("email") String email) {
        return subscribeEmailService.getSubscribeEmailByEmail(email);
    }

    @PostMapping("/subscribe")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public SubscribeEmail createNewSubscribeEmail(@RequestBody SubscribeEmail subscribeEmail,
                                  HttpServletResponse response,
                                  UriComponentsBuilder builder) {

        SubscribeEmail subscribeEmail1 = subscribeEmailService.createNewSubscribeEmail(subscribeEmail.getEmail());
        System.out.println(subscribeEmail.getEmail().getEmail());
        response.setHeader("Location", builder.path("/api/subscribe/" + subscribeEmail1.getId()).
                buildAndExpand(subscribeEmail1.getId()).toUriString());

        return subscribeEmail1;
    }

}
