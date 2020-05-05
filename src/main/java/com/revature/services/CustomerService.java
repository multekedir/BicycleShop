package com.revature.services;

import com.revature.models.Bicycle;
import com.revature.models.Offer;
import com.revature.models.User;

import java.util.HashSet;
import java.util.Set;

import static com.revature.data.DAOFactory.getBicycleDAO;
import static com.revature.singleton.LoggerSingleton.getLogger;


public class CustomerService {


    public static Set<Bicycle> getAvailableBicycles() {
        Set<Bicycle> availableBicycles = new HashSet<>();
        Set<Bicycle> bicycles = getBicycleDAO().getAll();
        if (!bicycles.isEmpty()) {
            for (Bicycle bicycle : bicycles) {
                if (bicycle.getOwner() == null)
                    availableBicycles.add(bicycle);
            }
        }
        return availableBicycles;
    }

    public static boolean makeOffer(User user, Bicycle bicycle, double amount) {
        getLogger(CustomerService.class).info("Making offer");
        if (bicycle != null && bicycle.getOwner() == null) {
            Offer newOffer = new Offer(user, bicycle, amount);
//            newOffer.setId(getDAO(DB.Offer).insert(newOffer));

            getLogger(CustomerService.class).debug("Offer went thru for Bicycle: " + bicycle);
            return true;
        }
        getLogger(CustomerService.class).debug("Offer Didn't go thru for Bicycle: " + bicycle);
//        System.out.println("Bicycle has an owner");
        return false;
    }

}
