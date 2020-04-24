package com.revature.models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PersonTest {
    Person person;

    @Before
    public void setUp() {
        person = new Person("Test", "Name");
    }

    @Test
    public void getLastName() {
        assertEquals("Name", person.getLastName());
    }

    @Test
    public void getFirstName() {
        assertEquals("Test", person.getFirstName());
    }

    @Test
    public void getFullName() {
        assertEquals("Test Name", person.getFullName());
    }

    @Test
    public void setLastName() {
        person.setLastName("New");
        assertEquals("New", person.getLastName());
    }

    @Test
    public void setFirstName() {
        person.setFirstName("New");
        assertEquals("New", person.getFirstName());
    }

    @Test
    public void testToString() {
        String out = String.format("Person[firstName = %s, lastName = %s]", person.getFirstName(), person.getLastName());
        assertEquals(out, person.toString());
    }

    @Test
    public void testEquals() {
        Person newPerson = new Person("Test", "Name");
        assertTrue(person.equals(newPerson));
    }
}