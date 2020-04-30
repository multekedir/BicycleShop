package com.revature.services;

import com.revature.data.DAOFactory.DB;
import com.revature.data.GenericDAO;
import com.revature.models.User;

import java.util.Set;

import static com.revature.data.DAOFactory.getDAO;
import static com.revature.singleton.LoggerSingleton.getLogger;

/**
 * The type Login service.
 */
public class LoginService {



    /**
     * Login user.
     *
     * @param username the username
     * @param password the password
     * @return the user
     */
    public static User login(String username, String password) {
        Set<User> users = getDAO(DB.User).getAll();
        getLogger(LoginService.class).info("Logging in  user");
        getLogger(LoginService.class).debug("Checking user: " + username);
        for (User user : users) {
            if (user.getUsername().equals(username) && user.checkPassword(password)) {
                getLogger(LoginService.class).debug("User found: " + user);
                return user;
            }
        }
        getLogger(LoginService.class).info("User not found");
        return null;
    }

    /**
     * Register user.
     *
     * @param user the user
     * @return the user ID
     */
    public static Integer register(User user) {
        getLogger(LoginService.class).info("Registering user");
        return getDAO(DB.User).add(user);
    }

    public static GenericDAO<Object> getUserDB() {
        return getDAO(DB.User);
    }
}
