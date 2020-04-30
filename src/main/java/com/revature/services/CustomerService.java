package com.revature.services;

import com.revature.data.GenericDAO;
import com.revature.models.Bicycle;
import com.revature.models.User;

import java.util.ArrayList;

import static com.revature.services.EmployeeService.getBicycleDB;
import static com.revature.singleton.LoggerSingleton.getLogger;

public class CustomerService {
    private static final GenericDAO<Bicycle> bicycleDB;

    static {
        bicycleDB = getBicycleDB();
    }

    public static ArrayList<Bicycle> getAvailableBicycles() {
        ArrayList<Bicycle> availableBicycles = new ArrayList();
        if (bicycleDB != null) {
            for (Bicycle bicycle : bicycleDB.getAll()) {
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
