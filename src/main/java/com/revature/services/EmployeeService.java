package com.revature.services;


import com.revature.models.Bicycle;
import com.revature.models.Offer;
import com.revature.models.Offer.Status;
import com.revature.models.User;

import java.util.Set;

import static com.revature.data.DAOFactory.getBicycleDAO;
import static com.revature.data.DAOFactory.getOfferDAO;
import static com.revature.singleton.LoggerSingleton.getLogger;


public class EmployeeService {


    public static Bicycle addBicycle(Bicycle bicycle) {
        getLogger(EmployeeService.class).info("Adding Bicycle");
        getBicycleDAO().insert(bicycle);

        return bicycle;
    }

    public static boolean removeBicycle(Bicycle bicycle) {
        getLogger(EmployeeService.class).debug("Removing -> " + bicycle);
        if (bicycle != null) {
            if (bicycle.getId() != null) {
                return getBicycleDAO().delete(bicycle);
            }
            getLogger(EmployeeService.class).error("Bicycle not added properly. ID is NULL " + bicycle);

        }
        getLogger(EmployeeService.class).error("Something went wrong  " + bicycle);
        return false;
    }

    public static Set<Bicycle> allBicycle() {
        return getBicycleDAO().getAll();
    }

    public static Set<Offer> allOffer() {
        return getOfferDAO().getAll();
    }

    public static boolean acceptOffer(int id) {
        Offer offer = getOfferDAO().getOfferByID(id);

        getLogger(EmployeeService.class).debug("Accepting offer  -> " + offer);
        if (offer != null) {
            Bicycle bicycle = offer.getBicycle();
            offer.setStatus(Status.ACCEPTED);
            bicycle.setOwner(offer.getUser());
            getOfferDAO().update(offer);
            getBicycleDAO().update(bicycle);

//            for (Offer off : getOfferDAO().getAllOtherOffers(bicycle)) {
//                if (off.getId() == offer.getId())
//                    continue;
//                rejectOffer(offer);
//
//
//            }
            return true;
        }
        getLogger(EmployeeService.class).error("Null value Offer: " + offer);
        return false;
    }

    public static boolean rejectOffer(int id) {
        Offer offer = getOfferDAO().getOfferByID(id);
        getLogger(EmployeeService.class).debug("Rejecting offer  -> " + offer);
        if (offer != null) {
            offer.setStatus(Status.DENIED);
            getOfferDAO().update(offer);
            return true;
        }
        getLogger(EmployeeService.class).error("Null value Offer: " + offer);
        return false;
    }

    public static boolean rejectOfferAll(Bicycle bicycle, User employee) {
        return false;
    }

//    public static GenericDAO<Bicycle> getBicycleDB() {
//        return getDAO(DB.Bicycle);
//    }


}
