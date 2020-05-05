package com.revature.data;

import com.revature.models.User;
import org.junit.Before;
import org.junit.Test;

import static com.revature.models.User.Role.Customer;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class UserDAOTest {
    UserDAO dao;

    @Before
    public void setup() {
        dao = new UserDAO();
    }


    @Test
    public void testInsert() {
        User newUser = new User("multezem", "kedir", "testuser", "password", Customer);
        assertTrue(dao.insert(newUser));
    }


    @Test
    public void testGetByID() {
        assertNotNull(dao.getUserByID(113));
    }

    @Test
    public void testGetByUserName() {
        assertNotNull(dao.getUserByUserName("username"));
    }

    @Test
    public void testGetAll() {
        System.out.println(dao.getAll());
    }

    @Test
    public void testUpdate() {
        User user = dao.getUserByID(113);
        user.setFirstName("newName");
        user.setLastName("newLast");
        dao.update(user);
    }

    @Test
    public void testDelete() {
        dao.delete(dao.getUserByID(112));
    }
}