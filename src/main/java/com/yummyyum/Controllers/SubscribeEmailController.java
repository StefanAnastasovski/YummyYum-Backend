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

    @GetMapping("/getallsubscribeemails")
    public List<SubscribeEmail> getAllSubscribeEmails() {
        return subscribeEmailService.getAllSubscribeEmails();
    }

    @GetMapping("/getallsubscribeemails/{email}")
    public Optional<SubscribeEmail> getSubscribeEmailByEmail(@PathVariable String email) {
        return subscribeEmailService.getSubscribeEmailByEmail(email);
    }

    @PostMapping("/createsubscribeemail")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public SubscribeEmail createNewSubscribeEmail(@RequestBody SubscribeEmail subscribeEmail,
                                  HttpServletResponse response,
                                  UriComponentsBuilder builder) {

        SubscribeEmail subscribeEmail1 = subscribeEmailService.createNewSubscribeEmail(subscribeEmail.getEmail(), subscribeEmail.getSubscribeDate());

        response.setHeader("Location", builder.path("/api/createsubscribeemail/" + subscribeEmail1.getId()).
                buildAndExpand(subscribeEmail1.getId()).toUriString());

        return subscribeEmail1;
    }

}
