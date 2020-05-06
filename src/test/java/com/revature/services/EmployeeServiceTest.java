package com.revature.services;

import com.revature.models.Bicycle;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.revature.data.DAOFactory.getOfferDAO;
import static com.revature.models.Offer.Status.DENIED;
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

    @After
    public void after() {
        bicycle = null;
    }


    @Test
    public void testAddBicycle() {
//       id should null before adding to db
        assertNull(bicycle);
        assertNull(bicycle.getId());
    }



    @Test
    public void testRemoveBicycle() {
        bicycle = addBicycle(bicycle);
//        int oldSize = getBicycleDB().size();
        removeBicycle(bicycle);
//        assertEquals(Integer.valueOf(oldSize - 1), getBicycleDB().size());
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

    @Test
    public void testAcceptOffer() {
//        addBicycle(bicycle);
//        assertNull(bicycle.getOwner());
//        User user = new User("Multezem", "Kedir", "multek", "password", Role.Employee);
//        User employe = new User("Multezem", "Kedir", "multek", "password", Role.Employee);
//        Offer offer = new Offer(user, bicycle, 100);
//        assertTrue(acceptOffer(offer));
//        assertEquals(user, bicycle.getOwner());
//        CustomerService.makeOffer(getUserDAO().getUserByID())
//        for (int i = 0; i < 5 ; i++) {
//            User newUser = new User("Multezem"+i, "Kedir"+i, "multekedir"+i, "password", Customer);
//            LoginService.register(newUser);
//        }
//        for (User user: getUserDAO().getAll()){
//            CustomerService.makeOffer(user,getBicycleDAO().getBicycleById(123),2343);
//        }
        acceptOffer(getOfferDAO().getAll().iterator().next().getId());

    }

    @Test
    public void testRejectOffer() {
//        User user = new User("Multezem", "Kedir", "multek", "password", Role.Employee);
//        User employe = new User("Multezem", "Kedir", "multek", "password", Role.Employee);
//        Offer offer = new Offer(user, bicycle, 100);
//        assertTrue(rejectOffer(offer));
//        assertNull(bicycle.getOwner());
//        assertNotEquals(String.valueOf(DENIED), getOfferDAO().getOfferByID(41).getStatus());
        rejectOffer(41);
        assertEquals(String.valueOf(DENIED), getOfferDAO().getOfferByID(41).getStatus());
    }


}