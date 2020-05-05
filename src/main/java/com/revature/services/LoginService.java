package com.revature.services;

import com.revature.data.UserDAO;
import com.revature.models.User;

import static com.revature.data.DAOFactory.getUserDAO;
import static com.revature.singleton.LoggerSingleton.getLogger;

/**
 * The type Login service.
 */
public class LoginService {
    UserDAO userDAO;


    /**
     * Login user.
     *
     * @param username the username
     * @param password the password
     * @return the user
     */
    public static User login(String username, String password) {
        User user = getUserDAO().getUserByUserName(username);
        if (user == null) {
            getLogger(LoginService.class).info("Not a valid username");
        } else {
            if (user.checkPassword(password)) {
                getLogger(LoginService.class).info("login was successful.");
                return user;
            }
            getLogger(LoginService.class).info("Not a valid Password");
        }
        return null;
    }

    /**
     * Register user.
     *
     * @param user the user
     * @return the user ID
     */
    public static boolean register(User user) {
        getLogger(LoginService.class).info("Registering user");
        return getUserDAO().insert(user);
    }
//
//    public static GenericDAO<Object> getUserDB() {
//        return getDAO(DB.User);
//    }
}
