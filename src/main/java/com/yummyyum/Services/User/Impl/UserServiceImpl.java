package com.yummyyum.Services.User.Impl;

import com.yummyyum.Model.User;

import com.yummyyum.Repositories.UserRepository;
import com.yummyyum.Services.User.UserService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {

        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserByUsername(String username) {
        return userRepository.getUserByUsername(username);
    }

    @Override
    public Boolean existsUserByUsername(String username) {
        return userRepository.existsUserByUsername(username);
    }

    @Override
    public User createNewUser(String firstName, String lastName,
                              String username, String password,
                              Timestamp userDate) {

        User user = new User(firstName, lastName, username, password, userDate);

        return userRepository.save(user);

    }
}
