package com.revature.data;

import com.revature.models.Bicycle;
import com.revature.models.Offer;
import com.revature.models.User;
import com.revature.services.EmployeeService;
import com.revature.services.LoginService;
import org.junit.Test;

import static com.revature.data.DAOFactory.getOfferDAO;

public class OfferDAOTest {

    @Test
    public void testInsert() {
        User user = new User("Multezem", "Kedir", "testehed", "password", User.Role.Customer);
        LoginService.register(user);
        Bicycle bicycle = EmployeeService.addBicycle(new Bicycle("roms", 500));
        Offer newOffer = new Offer(user, bicycle, 200);
        getOfferDAO().insert(newOffer);
    }

    @Test
    public void update() {

    }


}