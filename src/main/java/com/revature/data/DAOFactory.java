package com.revature.data;


public class DAOFactory {
    private static final UserDAO userDB = new UserDAO();
    private static final BicycleDAO bicycleDAO = new BicycleDAO();
    private static final OfferDAO offerDAO = new OfferDAO();


    public static UserDAO getUserDAO() {
        return userDB;
    }

    public static BicycleDAO getBicycleDAO() {
        return bicycleDAO;
    }

    public static OfferDAO getOfferDAO() {
        return offerDAO;
    }


}
