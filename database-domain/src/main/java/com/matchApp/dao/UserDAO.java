package com.matchApp.dao;

import com.matchApp.enitity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDAO {

    private final String succes = "OK";

    private UserRepository repository;

    @Autowired
    public void setUserRepository(UserRepository userRepository){
        this.repository = userRepository;
    }

    public UserDAO() {
    }

    public Boolean addUser(User user) {
        repository.save(user);
        return true;
    }

    public User getUserByLogin(String login) {
        return repository.findOne(login);
    }

    public User getUserByPhone(String phone) {
        return repository.findOne(phone);
    }

    public User getUserByEmail(String email) {
        return repository.findOne(email);
    }

    public List<User> getUserByNameAndLastName(String firstName, String lastName) {
        return new ArrayList<>(repository.findByFirstNameAndLastName(firstName, lastName));

    }

    public List getAllUsers() {
        ArrayList<User> User = new ArrayList<>();
        for (User u : repository.findAll()) {
            User.add(u);
        }
        return User;
    }

    public Boolean update(User user) {
        repository.save(user);
        return true;
    }

    public Boolean removeUser(String login) {
        repository.delete(login);
        return true;
    }

}
