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
    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Boolean existsUserByUsername(String username) {
        return userRepository.existsUserByUsername(username);
    }

    @Override
    public User createNewUser(String firstName, String lastName,
                              String username, String password,
                              Timestamp userDate, Email email) {

        Timestamp timestamp = new Timestamp(userDate.getTime());
        User user = new User(firstName, lastName, username, password, timestamp);
        Email email1 = new Email(email.getEmail(), true);
        emailRepository.save(email1);
        user.setEmail(email1);

        return this.userRepository.save(user);

    }

    @Override
    public User updateUser(String newPassword, String email) {

        Optional<User> user = userRepository.findUserByEmail(email);
        Optional<Email> email1 = emailRepository.findEmailByEmail(email);

        Email emailObj = null;
        User userObj = null;

        if (email1.isPresent())
            emailObj = email1.get();
        if (user.isPresent())
            userObj = user.get();

        User user1 = new User(userObj.getFirstName(),
                userObj.getLastName(), userObj.getUsername(),
                newPassword, userObj.getSignUpDate());

        user1.setId(userObj.getId());
        user1.setEmail(emailObj);

        return userRepository.saveAndFlush(user1);

    }


}
