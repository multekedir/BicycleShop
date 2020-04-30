package com.revature.services;

import com.revature.data.DAOFactory.DB;
import com.revature.models.Bicycle;
import com.revature.models.User;

import java.util.ArrayList;
import java.util.Set;

import static com.revature.data.DAOFactory.getDAO;
import static com.revature.singleton.LoggerSingleton.getLogger;


public class CustomerService {


    public static ArrayList<Bicycle> getAvailableBicycles() {
        ArrayList<Bicycle> availableBicycles = new ArrayList();
        Set<Bicycle> bicycles = getDAO(DB.Bicycle).getAll();

        if (getDAO(DB.Bicycle) != null) {
            for (Bicycle bicycle : bicycles) {
                if (bicycle.getOwner() == null)
                    availableBicycles.add(bicycle);
            }
        }
        return availableBicycles;
    }

    public static boolean makeOffer(User user, Bicycle bicycle, double offer) {
        getLogger(CustomerService.class).info("Making offer");
        if (bicycle != null && bicycle.getOwner() == null) {
            getLogger(CustomerService.class).debug("Offer went thru for Bicycle: " + bicycle);
            user.makeOffer(bicycle, offer);
            return true;
        }
        getLogger(CustomerService.class).debug("Offer Didn't go thru for Bicycle: " + bicycle);
        System.out.println("Bicycle has an owner");
        return false;
    }

}
