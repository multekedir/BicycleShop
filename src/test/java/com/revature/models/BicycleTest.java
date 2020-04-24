package com.revature.models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BicycleTest {
    private final String NAME = "ROUBAIX";
    private final double COST = 1000;
    Bicycle bicycle;

    @Before
    public void setUp() throws Exception {
        bicycle = new Bicycle(NAME, COST);
    }

    @Test
    public void getCost() {
        assertEquals(COST, bicycle.getCost(), 0);
    }

    @Test
    public void getName() {
        assertEquals(NAME, bicycle.getName());
    }

    @Test
    public void getOwnerNull() {
        assertNull(bicycle.getOwner());
    }

    @Test
    public void setCost() {
        bicycle.setCost(10);
        assertEquals(10, bicycle.getCost(), 0);
    }

    @Test
    public void setName() {
        bicycle.setName("New Name");
        assertEquals("New Name", bicycle.getName());
    }

    @Test
    public void setOwner() {
        Person p = new Person();
        bicycle.setOwner(p);
        assertTrue(bicycle.getOwner().equals(p));
    }
}