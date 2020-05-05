package com.revature.services;

import com.revature.models.Bicycle;
import com.revature.models.User;
import org.junit.Before;
import org.junit.Test;

import static com.revature.models.User.Role.Customer;
import static com.revature.services.CustomerService.getAvailableBicycles;
import static com.revature.services.CustomerService.makeOffer;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CustomerServiceTest {
    private final String NAME = "ROUBAIX";
    private final double COST = 1000;

    @Before
    public void setup() {
        for (Bicycle bicycle : getAvailableBicycles()) {
            EmployeeService.removeBicycle(bicycle);
        }
    }

    @Test
    public void testGetAvailableBicycles() {
        for (int i = 0; i < 10; i++) {
            EmployeeService.addBicycle(new Bicycle(NAME + i, COST));
        }
        assertEquals(10, getAvailableBicycles().size());
    }

    @Test
    public void testGetAvailableBicycles2() {
        User person = new User("multezem", "kedir", "test", "password", Customer);
        LoginService.register(person);
        Bicycle bicycle = new Bicycle(NAME, COST);
        bicycle.setOwner(person);
        EmployeeService.addBicycle(bicycle);
        assertEquals(0, getAvailableBicycles().size());
    }

    @Test
    public void testMakeOffer() {
        User user = new User("Multezem", "Kedir", "jonh", "password", User.Role.Customer);
        LoginService.register(user);
        Bicycle bicycle = EmployeeService.addBicycle(new Bicycle("NAMjomE", 500));
        assertTrue(makeOffer(user, bicycle, 200));
    }
//
//    @Test
//    public void testMakeOfferOwned() {
//        User user = new User("Multezem", "Kedir", "multek", "password", Role.Customer);
//        LoginService.register(user);
//        Bicycle bicycle = EmployeeService.addBicycle(new Bicycle("NAME", 500));
//        bicycle.setOwner(user);
//        assertFalse(makeOffer(user, bicycle, 200));
//    }


}