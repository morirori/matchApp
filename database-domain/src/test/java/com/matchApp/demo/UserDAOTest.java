package com.matchApp.demo;


import com.matchApp.dao.UserDAO;
import com.matchApp.dao.UserRepository;
import com.matchApp.enitity.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import java.util.*;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserDAOTest {
    // TODO implement tests for testing communication with database  and correctness of retrived data
    @Mock
    private User user;

    @Mock
    private UserRepository userRepository;

    private UserDAO dao;

    @Before
    public void setUp() {
        dao = new UserDAO();
        user = new User("majkel",
                "1234",
                "Michal",
                "Moraiwec",
                "m@gmail.com",
                "124",
                1,
                1);
        dao.setUserRepository(userRepository);
    }

    @Test
    public void addUserWithSucces(){
        when(userRepository.save(user)).thenReturn(user);
        assertTrue(dao.addUser(user));
    }

    @Test
    public void getOneUser(){
        when(userRepository.findOne(user.getLogin())).thenReturn(user);
        User returned= dao.getUserByLogin("majkel");
        assertSame(returned,user);
    }

    @Test
    public void getUserAccordingToFirstNameAndLastNameWithSucces(){
        ArrayList<User> tempUserList= new ArrayList<>();
        tempUserList.add(user);
        when(userRepository.findByFirstNameAndLastName(user.getFirstName(),user.getLastName())).thenReturn(tempUserList);
        List<User> returned= dao.getUserByNameAndLastName("Michal", "Moraiwec");
        if (returned.size()==1){
            assertSame(returned.get(0),user);
        }
    }

    @Test
    public void getFewUsers(){
        ArrayList<User> tempUserList = new ArrayList<>();
        tempUserList.add(user);
        User tempUser= new User("macio",
                "1245",
                "Maciej",
                "Cymbalista",
                "macio@gmail.com",
                "21412444",
                2,
                3);

        tempUserList.add(tempUser);
        when(userRepository.findAll()).thenReturn(tempUserList);
        List returnedUsers = dao.getAllUsers();

        for (int i=0; i<returnedUsers.size();i++){
            assertSame(returnedUsers.get(i),tempUserList.get(i));
        }
    }

}
