package com.revature.data;

import com.revature.models.Bicycle;
import com.revature.models.Offer;
import com.revature.models.User;
import com.revature.services.EmployeeService;
import com.revature.services.LoginService;
import org.junit.Test;

import static com.revature.data.DAOFactory.getBicycleDAO;
import static com.revature.data.DAOFactory.getOfferDAO;
import static org.junit.Assert.assertTrue;

public class OfferDAOTest {

    @Test
    public void testInsert() {
        User user = new User("Multezem", "Kedir", "testlkklehed", "password", User.Role.Customer);
        LoginService.register(user);
        Bicycle bicycle = EmployeeService.addBicycle(new Bicycle("roassms", 500));
        Offer newOffer = new Offer(user, bicycle, 200);
        assertTrue(getOfferDAO().insert(newOffer));
    }

    @Test
    public void testGetOfferByID() {
//        User user = new User("Multezem", "Kedir", "testehed", "password", User.Role.Customer);
//        LoginService.register(user);
//        Bicycle bicycle = EmployeeService.addBicycle(new Bicycle("roms", 500));
//        Offer newOffer = new Offer(user, bicycle, 200);
//        assertTrue(getOfferDAO().insert(newOffer));
//        assertEquals(newOffer, getOfferDAO().getOfferByID(newOffer.getId()));
        getOfferDAO().getOfferByID(41);
    }


    @Test
    public void testGetAll() {
        System.out.println(getOfferDAO().getAll());
    }

    @Test
    public void testGetAllOtherOffers() {
        System.out.println(getOfferDAO().getAllOtherOffers(getBicycleDAO().getBicycleById(123)));
    }


}