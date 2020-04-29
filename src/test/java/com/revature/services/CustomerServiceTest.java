package com.revature.services;

import com.revature.models.Bicycle;
import com.revature.models.Person;
import com.revature.models.User;
import org.junit.Test;

import static com.revature.services.CustomerService.getAvailableBicycles;
import static com.revature.services.CustomerService.makeOffer;
import static org.junit.Assert.*;

public class CustomerServiceTest {
    private final String NAME = "ROUBAIX";
    private final double COST = 1000;


    @Test
    public void testGetAvailableBicycles() {
        for (int i = 0; i < 10; i++) {
            EmployeeService.addBicycle(new Bicycle(NAME + i, COST));
        }
        assertEquals(10, getAvailableBicycles().size());
    }

    @Test
    public void testGetAvailableBicycles2() {
        Person person = new Person();

        for (int i = 0; i < 10; i++) {

            if (i % 2 == 0) EmployeeService.addBicycle(new Bicycle(NAME + i, COST));
            Bicycle bicycle = new Bicycle(NAME + i, COST);
            bicycle.setOwner(person);
            EmployeeService.addBicycle(bicycle);
        }
        assertEquals(5, getAvailableBicycles().size());
    }

    @Test
    public void testMakeOffer() {
        User user = new User("Multezem", "Kedir", "multek", "password", true);
        LoginService.register(user);
        Bicycle bicycle = EmployeeService.addBicycle(new Bicycle("NAME", 500));
        assertTrue(makeOffer(user, bicycle, 200));
    }

    @Test
    public void testMakeOfferOwned() {
        User user = new User("Multezem", "Kedir", "multek", "password", true);
        LoginService.register(user);
        Bicycle bicycle = EmployeeService.addBicycle(new Bicycle("NAME", 500));
        bicycle.setOwner(user);
        assertFalse(makeOffer(user, bicycle, 200));
    }


}