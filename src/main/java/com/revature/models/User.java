package com.revature.models;


import java.util.StringJoiner;

import static com.revature.singleton.LoggerSingleton.getLogger;

/**
 * The type User.
 */
public class User extends Person {


    private Role role;
    private String username;
    private final String password;

    /**
     * Instantiates a new User.
     *
     * @param firstName the first name
     * @param lastName  the last name
     * @param username  the username
     * @param password  the password
     * @param role      the role
     */
    public User(String firstName, String lastName, String username, String password, Role role) {
        this.username = username;
        this.password = password;
        this.role = role;
        setFirstName(firstName);
        setFirstName(lastName);
        getLogger(User.class).info("Created User");
    }

    /**
     * Gets password.
     *
     * @return Value of password.
     */
    public String getPassword() {
        return password;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    enum Role {
        Employee, Customer, Manager
    }
}
