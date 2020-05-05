package com.revature.data;

import com.revature.models.Offer;
import com.revature.models.User;

public class DAOFactory {
    private static final UserDAO userDB = new UserDAO();
    private static final GenericDAO<User> d = new GenericDAO(User.class);
    private static final GenericDAO<Offer> offerDB = new GenericDAO(Offer.class);

    public static DAO getDAO(DB db) {
        switch (db) {
            case User:
            case Bicycle:
            case Offer:
                return userDB;
            default:
                return null;
        }
    }

    public static UserDAO getUserDAO() {
        return userDB;
    }

    public enum DB {Offer, Bicycle, User}

}
