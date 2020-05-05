package com.revature.services;


import com.revature.models.Bicycle;
import com.revature.models.Offer;
import com.revature.models.Offer.Status;
import com.revature.models.User;

import static com.revature.singleton.LoggerSingleton.getLogger;


public class EmployeeService {


    public static Bicycle addBicycle(Bicycle bicycle) {
        getLogger(EmployeeService.class).info("Adding Bicycle");
//        int id = getDAO(DB.Bicycle).add(bicycle);
//        bicycle.setId(id);
        return bicycle;
    }

    public static boolean removeBicycle(Bicycle bicycle) {
        getLogger(EmployeeService.class).debug("Removing -> " + bicycle);
//        if (getDAO(DB.Bicycle).size() > 0 && bicycle != null) {
//            if (bicycle.getId() != null) {
//                return getDAO(DB.Bicycle).delete(bicycle.getId());
//            }
//            getLogger(EmployeeService.class).error("Bicycle not added properly. ID is NULL " + bicycle);
//
//        }
        getLogger(EmployeeService.class).error("Something went wrong  " + bicycle);
        return false;
    }

    public static boolean acceptOffer(Offer offer, User employee) {
        getLogger(EmployeeService.class).debug("Accepting offer  -> " + offer);
        if (offer != null && employee != null) {
            offer.setStatus(Status.ACCEPTED, employee);
            offer.getBicycle().setOwner(offer.getUser());
//            getDAO(DB.Offer).update(offer.getId(), offer);
//            getDAO(DB.Bicycle).update(offer.getBicycle().getId(), offer.getBicycle());
            return true;
        }
        getLogger(EmployeeService.class).error("Null value Offer: " + offer + " Employee: " + employee);
        return false;
    }

    public static boolean rejectOffer(Offer offer, User employee) {
        getLogger(EmployeeService.class).debug("Rejecting offer  -> " + offer);
        if (offer != null && employee != null) {
            offer.setStatus(Status.DENIED, employee);
//            getDAO(DB.Offer).update(offer.getId(), offer);
            return true;
        }
        getLogger(EmployeeService.class).error("Null value Offer: " + offer + " Employee: " + employee);
        return false;
    }

    public static boolean rejectOfferAll(Bicycle bicycle, User employee) {
        return false;
    }

//    public static GenericDAO<Bicycle> getBicycleDB() {
//        return getDAO(DB.Bicycle);
//    }


}
