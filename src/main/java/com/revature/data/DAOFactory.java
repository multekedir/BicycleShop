package com.revature.data;

import com.revature.models.Bicycle;
import com.revature.models.Offer;
import com.revature.models.User;

public class DAOFactory {
    private static final GenericDAO<Bicycle> bicycleDB = new GenericDAO(Bicycle.class);
    private static final GenericDAO<User> userDB = new GenericDAO(User.class);
    private static final GenericDAO<Offer> offerDB = new GenericDAO(Offer.class);

    public static GenericDAO getDAO(DB db) {
        switch (db) {
            case User:
                return userDB;
            case Offer:
                return offerDB;
            case Bicycle:
                return bicycleDB;
            default:
                return null;
        }
    }

    public enum DB {Offer, Bicycle, User}

}
