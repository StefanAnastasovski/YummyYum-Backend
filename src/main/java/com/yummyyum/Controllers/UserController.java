package com.yummyyum.Controllers;

import com.yummyyum.Model.User;
import com.yummyyum.Services.User.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.util.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:8080")
public class UserController {

    private final UserService userService;

    public UserController(UserService UserService) {
        this.userService = UserService;

    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/users/username/{username}")
    public Optional<User> getUserByUsername(@PathVariable String username) {
        return userService.getUserByUsername(username);
    }

    @GetMapping("/users/email/{email}")
    public Optional<User> getUserByEmail(@PathVariable("email") String email) {
        return userService.findUserByEmail(email);
    }

    @GetMapping("/users/username={username}")
    @ResponseBody
    public Map<String, Boolean> existsUserByUsername(@PathVariable String username) {
        Map<String, Boolean> resultMap = new HashMap<>();
        if (userService.existsUserByUsername(username)) {
            resultMap.put("success", true);
        } else {
            resultMap.put("success", false);
        }
        return resultMap;
    }

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public User createNewUser(@RequestBody User user,
                              HttpServletResponse response,
                              UriComponentsBuilder builder) {

        response.setHeader("Location", builder.path("/api/users/" + user.getId()).
                buildAndExpand(user.getId()).toUriString());

        return userService.createNewUser(user.getFirstName(), user.getLastName(),
                user.getUsername(), user.getPassword(), user.getSignUpDate(), user.getEmail());
    }

}
