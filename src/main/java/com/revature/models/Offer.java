package com.revature.models;

public class Offer {

    private User user;
    private Bicycle bicycle;
    private int id;
    private double amount;
    private Person acceptedBy;


    public Offer() {
    }

    public Offer(User user, Bicycle bicycle, int id, double amount, Person acceptedBy) {
        this.user = user;
        this.bicycle = bicycle;
        this.id = id;
        this.amount = amount;
        this.acceptedBy = acceptedBy;
    }

    /**
     * Gets user.
     *
     * @return Value of user.
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets new user.
     *
     * @param user New value of user.
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Gets amount.
     *
     * @return Value of amount.
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Sets new amount.
     *
     * @param amount New value of amount.
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * Gets bicycle.
     *
     * @return Value of bicycle.
     */
    public Bicycle getBicycle() {
        return bicycle;
    }

    /**
     * Sets new bicycle.
     *
     * @param bicycle New value of bicycle.
     */
    public void setBicycle(Bicycle bicycle) {
        this.bicycle = bicycle;
    }

    /**
     * Gets id.
     *
     * @return Value of id.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets new id.
     *
     * @param id New value of id.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets acceptedBy.
     *
     * @return Value of acceptedBy.
     */
    public Person getAcceptedBy() {
        return acceptedBy;
    }

    /**
     * Sets new acceptedBy.
     *
     * @param acceptedBy New value of acceptedBy.
     */
    public void setAcceptedBy(Person acceptedBy) {
        this.acceptedBy = acceptedBy;
    }
}
