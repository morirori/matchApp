package com.matchApp.webServices;

import com.matchApp.enitity.User;
import com.matchApp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserWebServicesController {

    @Autowired
    private UserService us;

    @Autowired
    private DatabaseWebServicesExceptionHandler ex;

// TODO Create user data validation
// TODO Create exception handling for  - UserAlreadyExitst and NotUserFound
// TODO Paprametrize update method and maybe every method :D
// TODO class which let us send request via HTTPS

    // ------ Those methods runs properly
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@RequestBody User input) {
//        if(us.validateUser(input.getLogin(),input.getEmail(), input.getPhoneNumber())) {
        us.add(input);
//        }
        return "";
    }

    @RequestMapping(value = "/get/{login}", method = RequestMethod.GET)
    public ResponseEntity<String> getUser(@PathVariable("login") String login) {

        String toReturn = us.getUser(login);
        return new ResponseEntity<>(toReturn, new HttpHeaders(), HttpStatus.OK);

    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseEntity<String> getAll() {
        String toReturn = us.getAllUsers();
        return new ResponseEntity<>(toReturn, new HttpHeaders(), HttpStatus.OK);
    }

    @RequestMapping(value = "/get/{firstName}/{lastName}", method = RequestMethod.GET)
    public ResponseEntity getByFirstAndLastName(@PathVariable("firstName") String firstName, @PathVariable("lastName") String lastName) {
        String toReturn = us.getUserByFirstAndLastName(firstName, lastName);
        return new ResponseEntity<>(toReturn, new HttpHeaders(), HttpStatus.OK);
    }




// --------------------------------------------------------Those methods dont run properly----------------------------------------------------
// TODO  repair below methods

    @RequestMapping(value = "/delete/{login}]", method = RequestMethod.DELETE)
    public ResponseEntity<String> delete(@PathVariable("login") String login) {
        String toReturn = us.removeUser(login);
        return new ResponseEntity<>(toReturn, new HttpHeaders(), HttpStatus.OK);
    }


    @RequestMapping(value = "/update/{login}-{password}/", method = RequestMethod.PUT)
    public ResponseEntity update(@PathVariable("login") String login, @PathVariable("password") String password) {
//        String toReturn = us.updateUser(login, "password" , password);
        String toReturn = "s";
        return new ResponseEntity<>(toReturn, new HttpHeaders(), HttpStatus.OK);

    }
}
