package com.matchApp.ServicesTests;

import com.matchApp.DatabaseExceptions.UserAlreadyExistsException;
import com.matchApp.dao.UserDAO;
import com.matchApp.dao.UserRepository;
import com.matchApp.enitity.User;
import com.matchApp.services.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.internal.matchers.Null;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTests {

    @Mock
    private UserDAO dao;

    @Mock
    private UserRepository userRepository;

    private User user;
    private UserService userService;

    @Before
    public void setUp(){
        dao.setUserRepository(userRepository);
        user = new User("majkel",
                "1234",
                "Michal",
                "Moraiwec",
                "m@gmail.com",
                "124",
                1,
                1);
        userService = new UserService();
        userService.setUserDAO(dao);
    }

    @Test
    public void userValidationWithSucces() {
        try {
            when(dao.getUserByLogin(anyString())).thenReturn(null);
            when(dao.getUserByEmail(anyString())).thenReturn(null);
            when(dao.getUserByPhone(anyString())).thenReturn(null);
            Boolean isvalid = userService.validateUser("majkel", "mmora@gmail.com", "12441");
            assertTrue(isvalid);
        } catch (UserAlreadyExistsException e) {
            System.out.print(e.toString());
        }
    }

}
