package com.matchApp.services;

import com.google.gson.Gson;
import com.matchApp.DatabaseExceptions.UserAlreadyExistsException;
import com.matchApp.dao.UserDAO;
import com.matchApp.enitity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final Gson gson;

    public UserService() {
        this.gson = new Gson();
    }


    private UserDAO userDAO;

    @Autowired
    public void setUserDAO(UserDAO dao){
        userDAO= dao;
    }

    public String add(User u) {
        if (userDAO.addUser(u)) {
            return "Added Succesfully";
        } else {
            return "error";
        }

    }

    public String removeUser(String login) {
        if (userDAO.removeUser(login)) {
            return "Deleted Succesfully";
        } else {
            return "error";
        }
    }

    public String getUser(String login) {
        return gson.toJson(userDAO.getUserByLogin(login));
    }

    public String getAllUsers() {
        return gson.toJson(userDAO.getAllUsers());
    }

    public String getUserByFirstAndLastName(String firstName, String lastName) {
        return gson.toJson(userDAO.getUserByNameAndLastName(firstName, lastName));
    }

    public String updateUser(String login, String param, String value) throws UserAlreadyExistsException {
        User temp = userDAO.getUserByLogin(login);

        switch (param) {
            case "password":
                temp.setPassword(value);
                userDAO.update(temp);
                break;
            case "login":
                temp.setLogin(value);
                validateUser(value, temp.getEmail(), temp.getPhoneNumber());
                userDAO.update(temp);
                break;
            case "firt_name":
                temp.setFirstName(value);
                userDAO.update(temp);
                break;
            case "last_name":
                temp.setLastName(value);
                userDAO.update(temp);
                break;
            case "email":
                temp.setEmail(value);
                validateUser(temp.getEmail(), value, temp.getPhoneNumber());
                userDAO.update(temp);
                break;
            case "phone_number":
                temp.setPhoneNumber(value);
                validateUser(temp.getLogin(), temp.getEmail(), value);
                userDAO.update(temp);
                break;
            case "warnings_number":
                temp.setWarningsNumber(Integer.parseInt(value));
                userDAO.update(temp);
                break;
            case "match_played":
                temp.setMatchPlayed(Integer.parseInt(value));
                userDAO.update(temp);
                break;
        }
        return "Updated Succesfully";
    }

    public Boolean validateUser(String login, String email, String telephone) throws UserAlreadyExistsException {

        if (userDAO.getUserByLogin(login) != null ||
                userDAO.getUserByEmail(email) != null ||
                userDAO.getUserByPhone(telephone) != null) {

            throw new UserAlreadyExistsException();
        } else {
            return true;
        }
    }

}
