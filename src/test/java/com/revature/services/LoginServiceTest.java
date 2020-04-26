package com.revature.services;

import com.revature.models.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class LoginServiceTest {
    LoginService loginService;

    @Before
    public void setUp() {
        loginService = new LoginService();
    }


    @Test
    public void testLogin() {
        User newUser = new User("first", "last", "username", "password", false);

        LoginService.register(newUser);
        assertEquals(newUser, LoginService.login("username", "password"));
    }

    @Test
    public void testLoginBadUsername() {
        User newUser = new User("first", "last", "username", "password", false);

        LoginService.register(newUser);
        assertNull(LoginService.login("badusername", "password"));
    }

    @Test
    public void testLoginBadPassword() {
        User newUser = new User("first", "last", "username", "password", false);

        LoginService.register(newUser);
        assertNull(LoginService.login("username", "badpassword"));
    }

    @Test
    public void register() {
        User newUser = new User("first", "last", "username", "password", false);
        int id = LoginService.register(newUser);

        assertEquals(newUser, LoginService.getUserDB().getById(id));
    }

    @Test
    public void testRegisterEmploy() {
        User newUser = new User("first_e", "last_e", "employ", "password", true);
        int id = LoginService.register(newUser);
        assertTrue(LoginService.getUserDB().getById(id).isIsEmployee());
        assertEquals(newUser, LoginService.getUserDB().getById(id));
    }


}