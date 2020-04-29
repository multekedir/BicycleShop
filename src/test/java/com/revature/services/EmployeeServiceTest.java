package com.revature.services;

import com.revature.models.Bicycle;
import org.junit.Before;
import org.junit.Test;

import static com.revature.services.EmployeeService.*;
import static org.junit.Assert.*;


public class EmployeeServiceTest {

    private final String NAME = "ROUBAIX";
    private final double COST = 1000;
    Bicycle bicycle;

    @Before
    public void setup() {
        bicycle = new Bicycle(NAME, COST);
    }

    @Test
    public void testAddBicycle() {
//       id should null before adding to db
        assertNull(bicycle.getId());
        int id = addBicycle(bicycle).getId();
        assertEquals(bicycle, getBicycleDB().getById(id));
    }


    @Test
    public void testRemoveBicycle() {
        bicycle = addBicycle(bicycle);
        int oldSize = getBicycleDB().size();
        removeBicycle(bicycle);
        assertEquals(Integer.valueOf(oldSize - 1), getBicycleDB().size());
    }

    @Test
    public void testRemoveBicycleFromEmpty() {
        assertFalse(removeBicycle(bicycle));
    }

    @Test
    public void testRemoveBicycleInvalidID() {
        addBicycle(bicycle).setId(3);
        assertFalse(removeBicycle(bicycle));
    }
}