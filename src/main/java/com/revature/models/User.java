package com.revature.models;


import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

import static com.revature.singleton.LoggerSingleton.getLogger;

/**
 * The type User.
 */
public class User extends Person {


    private String username;
    private final String password;
    private final Map<Bicycle, Double> offers = new HashMap<Bicycle, Double>();
    private boolean isEmployee;

    /**
     * Instantiates a new User.
     *
     * @param firstName  the first name
     * @param lastName   the last name
     * @param username   the username
     * @param password   the password
     * @param isEmployee the is employee
     */
    public User(String firstName, String lastName, String username, String password, boolean isEmployee) {
        this.username = username;
        this.password = password;
        this.isEmployee = isEmployee;
        setFirstName(firstName);
        setFirstName(lastName);
        getLogger(User.class).info("Created User");
    }

    /**
     * Gets offers.
     *
     * @return Value of offers.
     */
    public Map getOffers() {
        return offers;
    }

    /**
     * Sets new offers.
     *
     * @param bicycle the bicycle
     * @param cost    the offer amount
     */
    public void makeOffer(Bicycle bicycle, double cost) {
        getLogger(User.class).info(this.username + " made offer for " + bicycle.getName() + " for " + cost);
        this.offers.put(bicycle, cost);
    }

    /**
     * Gets username.
     *
     * @return Value of username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets new username.
     *
     * @param username New value of username.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * checks if password is the same
     *
     * @param password the password
     * @return true password match
     */
    public boolean checkPassword(String password) {
//        System.out.println("Password failed");
        getLogger(User.class).info("Password failed");
        return this.password.equals(password);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", this.getClass().getSimpleName() + "[", "]")
                .add("firstName = " + this.getFirstName())
                .add("lastName = " + this.getLastName())
                .add("username = " + username)
                .toString();
    }

    /**
     * Gets isEmployee.
     *
     * @return Value of isEmployee.
     */
    public boolean isIsEmployee() {
        return isEmployee;
    }

    /**
     * Sets new isEmployee.
     *
     * @param isEmployee New value of isEmployee.
     */
    public void setIsEmployee(boolean isEmployee) {
        this.isEmployee = isEmployee;
    }
}
