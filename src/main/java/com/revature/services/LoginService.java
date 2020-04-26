package com.revature.services;

import com.revature.data.GenericDAO;
import com.revature.models.User;

import static com.revature.singleton.LoggerSingleton.getLogger;

/**
 * The type Login service.
 */
public class LoginService {
    private static GenericDAO<User> userDB;

    static {
        userDB = new GenericDAO(User.class);
    }


    /**
     * Login user.
     *
     * @param username the username
     * @param password the password
     * @return the user
     */
    public static User login(String username, String password) {
        getLogger().info("Logging in  user");
        getLogger().debug("Checking user: " + username);
        for (User user : userDB.getAll()) {
            if (user.getUsername().equals(username) && user.checkPassword(password)) {
                getLogger().debug("User found: " + user);
                return user;
            }
        }
        getLogger().info("User not found");
        return null;
    }

    /**
     * Register user.
     *
     * @param user the user
     * @return the user ID
     */
    public static Integer register(User user) {
        getLogger().info("Registering user");
        return userDB.add(user);
    }

    /**
     * Gets userDB.
     *
     * @return Value of userDB.
     */
    public static GenericDAO<User> getUserDB() {
        return userDB;
    }
}
