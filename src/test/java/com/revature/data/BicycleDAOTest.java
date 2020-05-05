package com.revature.data;

import com.revature.models.Bicycle;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class BicycleDAOTest {
    BicycleDAO dao = new BicycleDAO();

    @Test
    public void testInsert() {
        Bicycle bicycle = new Bicycle("hello", 45.22);
        assertTrue(dao.insert(bicycle));
        assertNotNull(bicycle.getId());
    }


    @Test
    public void testGetByID() {
        assertNotNull(dao.getBicycleById(4));
        assertNotNull(dao.getBicycleById(4).getId());
    }

    @Test
    public void testGetAll() {
        System.out.println(dao.getAll());
    }

    @Test
    public void testUpdate() {
        Bicycle bicycle = dao.getBicycleById(5);
        bicycle.setName("newName");
        dao.update(bicycle);
    }
}