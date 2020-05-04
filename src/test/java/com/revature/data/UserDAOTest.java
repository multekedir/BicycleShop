package com.revature.data;

import com.revature.models.User;
import org.junit.Before;
import org.junit.Test;

import static com.revature.models.User.Role.Customer;

public class UserDAOTest {
    UserDAO dao;

    @Before
    public void setup() {
        dao = new UserDAO();
    }


    @Test
    public void testInsert() {
        User newUser = new User("multezem", "kedir", "multezemkedir", "password", Customer);
        dao.insert(newUser);
    }

    @Test
    public void getUser() {
    }

    @Test
    public void getAll() {
    }

    @Test
    public void getByID() {
    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
    }
}