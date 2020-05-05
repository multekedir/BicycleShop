package com.revature.data;

import com.revature.models.Bicycle;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class BicycleDAOTest {
    BicycleDAO dao = new BicycleDAO();

    @Test
    public void testInsert() {
        Bicycle bicycle = new Bicycle("NAME", 45.20);
        assertTrue(dao.insert(bicycle));
        assertNotNull(bicycle.getId());
    }

    @Test
    public void test() {
        Bicycle bicycle = new Bicycle("NAME", 45.20);
        assertTrue(dao.insert(bicycle));
        assertNotNull(bicycle.getId());
    }
}