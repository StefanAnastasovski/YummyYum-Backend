package com.yummyyum.Controllers;

import com.yummyyum.Model.User;
import com.yummyyum.Services.User.UserService;
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
public class UserController {

    private final UserService UserService;

    public UserController(UserService UserService) {
        this.UserService = UserService;

    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return UserService.getAllUsers();
    }

    @GetMapping("/users/username/{username}")
    public Optional<User> getUserByUsername(@PathVariable String username) {
        return UserService.getUserByUsername(username);
    }

    @GetMapping("/users/username={username}")
    @ResponseBody
    public Map<String, Boolean> existsUserByUsername(@PathVariable String username) {
        Map<String, Boolean> resultMap = new HashMap<>();
        if (UserService.existsUserByUsername(username)) {
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

        User user1 = UserService.createNewUser(user.getFirstName(), user.getLastName(),
                user.getUsername(), user.getPassword(), user.getSignUpDate());

        response.setHeader("Location", builder.path("/api/users/" + user.getId()).
                buildAndExpand(user1.getId()).toUriString());

        return user1;
    }
}
