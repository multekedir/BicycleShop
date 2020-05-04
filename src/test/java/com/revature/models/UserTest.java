package com.revature.models;

import com.revature.models.User.Role;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTest {
    User user;

    @Before
    public void setUp() {
        user = new User("Multezem", "Test", "testuser", "no password", Role.Customer);
    }

    @Test
    public void setUsername() {
        user.setUsername("newuser");
        assertEquals("newuser", user.getUsername());
    }

    @Test
    public void getOffers() {
    }

    @Test
    public void setOffers() {
    }

    @Test
    public void getUsername() {
        assertEquals("testuser", user.getUsername());
    }

    @Test
    public void checkPassword() {
    }
}