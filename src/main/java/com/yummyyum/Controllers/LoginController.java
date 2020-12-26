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
    public Object getLoginByEmail(@PathVariable String email){

        Optional<Login> login = loginService.getLoginByEmail(email);
        return login;
    }

    @PostMapping("/logins")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Login createNewLogin(@RequestBody Login login,
                                HttpServletResponse response,
                                UriComponentsBuilder builder) {

        Login login1 = loginService.createNewLogin(login.getEmail(), login.getLoginDate());

        response.setHeader("Location", builder.path("/api/createlogin/" + login.getId()).
                buildAndExpand(login.getId()).toUriString());

        return login1;
    }

}
