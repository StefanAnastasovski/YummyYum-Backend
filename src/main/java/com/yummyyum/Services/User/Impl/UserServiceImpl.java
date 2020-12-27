package com.yummyyum.Services.User.Impl;

import com.yummyyum.Model.Email;
import com.yummyyum.Model.User;

import com.yummyyum.Repositories.EmailRepository;
import com.yummyyum.Repositories.UserRepository;
import com.yummyyum.Services.User.UserService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final EmailRepository emailRepository;

    public UserServiceImpl(UserRepository userRepository, EmailRepository emailRepository) {
        this.userRepository = userRepository;
        this.emailRepository = emailRepository;
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
    public Optional<User> findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    @Override
    public Boolean existsUserByUsername(String username) {
        return userRepository.existsUserByUsername(username);
    }

    @Override
    public User createNewUser(String firstName, String lastName,
                              String username, String password,
                              Timestamp userDate, Email email) {

        User user = new User(firstName, lastName, username, password, userDate);
        Email email1 = new Email(email.getEmail(), true);
        emailRepository.save(email1);
        user.setEmail(email1);

        return this.userRepository.save(user);

    }

}
