package com.yummyyum.Controllers;

import com.yummyyum.Model.Login;
import com.yummyyum.Services.Login.LoginService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:8080")
public class LoginController {

    private final LoginService loginService;


    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/logins")
    public List<Login> getAllLogins() {
        return loginService.getAllLogins();
    }

    @GetMapping("/logins/email/{email}")
    public List<Login> findLoginsByEmail(@PathVariable("email") String email) {
        return loginService.findLoginsByEmail(email);
    }

     @GetMapping("/logins/email/{email}/logindate/{logindate}")
    public Optional<Login> findLoginByEmailAndLoginDateContains(@PathVariable("email") String email,
                                                           @PathVariable("logindate") String loginDate) {
        return loginService.findLoginByEmailAndLoginDateContains(email, loginDate);
    }

    @PostMapping("/logins")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Login createNewLogin(@RequestBody Login login,
                                HttpServletResponse response,
                                UriComponentsBuilder builder) {

        Login login1 = loginService.createNewLogin(login.getLoginDate(), login.getEmail());
        response.setHeader("Location", builder.path("/api/logins/" + login.getId()).
                buildAndExpand(login.getId()).toUriString());

        return login1;
    }

}
