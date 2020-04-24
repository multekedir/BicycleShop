package com.revature.models;


import java.util.HashMap;
import java.util.Map;

import static com.revature.singleton.LoggerSingleton.getLogger;

public class User extends Person {

    private String username;
    private String password;
    private Map<Bicycle, Double> offers = new HashMap<Bicycle, Double>();
    private boolean isEmployee;

    public User(String firstName, String lastName, String username, String password, boolean isEmployee) {
        this.username = username;
        this.password = password;
        this.isEmployee = isEmployee;
        setFirstName(firstName);
        setFirstName(lastName);
        getLogger().info("Created User");
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
     * @param offers New value of offers.
     */
    public void setOffers(Map offers) {
        this.offers = offers;
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
     * @return true password match
     */
    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }
}
