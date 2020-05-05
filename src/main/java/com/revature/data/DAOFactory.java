package com.revature.data;


public class DAOFactory {
    private static final UserDAO userDB = new UserDAO();
    private static final BicycleDAO bicycleDAO = new BicycleDAO();


    public static UserDAO getUserDAO() {
        return userDB;
    }

    public static BicycleDAO getBicycleDAO() {
        return bicycleDAO;
    }


}
