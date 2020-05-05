package com.revature.services;

import com.revature.models.User;
import org.junit.Before;
import org.junit.Test;

import static com.revature.models.User.Role.Customer;
import static com.revature.models.User.Role.Employee;
import static org.junit.Assert.*;


public class LoginServiceTest {
    LoginService loginService;

    @Before
    public void setUp() {
        loginService = new LoginService();
    }

    @Test
    public void register() {
        User newUser = new User("Multezem", "Kedir", "multekedir", "password", Customer);
        assertTrue(LoginService.register(newUser));
    }

    @Test
    public void testLogin() {
        User newUser = new User("first", "last", "username", "password", Customer);
        LoginService.register(newUser);
        assertEquals(newUser, LoginService.login("username", "password"));
    }

    @Test
    public void testLoginBadUsername() {
        assertNull(LoginService.login("badusername", "password"));
    }

    @Test
    public void testLoginBadPassword() {
        assertNull(LoginService.login("username", "badpassword"));
    }



    @Test
    public void testRegisterEmploy() {
        User newEmploy = new User("first_e", "last_e", "employ", "password", Employee);
//        assertTrue(LoginService.register(newEmploy));
        User user = LoginService.login(newEmploy.getUsername(), newEmploy.getPassword());
        System.out.println(user);
        assertEquals(Employee, user.getRole());
    }




}