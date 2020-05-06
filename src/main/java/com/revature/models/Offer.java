package com.revature.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.revature.data.DAOFactory.getBicycleDAO;
import static com.revature.data.DAOFactory.getUserDAO;

/**
 * The type Offer.
 */
public class Offer {
    private Status status;

    /**
     * Instantiates a new Offer.
     */
    public Offer() {
    }

    private User user;
    private Bicycle bicycle;
    private int id;
    private double amount;
    private Person acceptedBy;


    /**
     * Instantiates a new Offer.
     *
     * @param user    the user
     * @param bicycle the bicycle
     * @param amount  the amount
     */
    public Offer(User user, Bicycle bicycle, double amount) {
        this.user = user;
        this.bicycle = bicycle;
        this.amount = amount;
    }

    public Offer(ResultSet rs) throws SQLException {
        int userId = (rs.getInt("user_id".toUpperCase()));
        this.setUser(getUserDAO().getUserByID(userId));

        int bicycleId = (rs.getInt("bicycle_id".toUpperCase()));
        this.setBicycle(getBicycleDAO().getBicycleById(bicycleId));

        this.setStatus(rs.getString("status".toUpperCase()));

        this.setId(rs.getInt("ID"));
    }

    @Override
    public String toString() {
        return "Offer{" +
                "status='" + status + '\'' +
                ", user=" + user +
                ", bicycle=" + bicycle +
                ", id=" + id +
                ", amount=" + amount +
                '}';
    }

    /**
     * Gets status.
     *
     * @return Value of status.
     */
    public String getStatus() {
        return String.valueOf(status);
    }

    /**
     * Sets new status.
     *
     * @param string New value of status.
     */
    public void setStatus(String string) {
        this.status = Status.valueOf(string);
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

    /**
     * Sets new status.
     *
     * @param s          New value of status.
     */
    public void setStatus(Status s) {
        this.acceptedBy = acceptedBy;
        this.status = s;
    }

    /**
     * The enum Status.
     */
    public enum Status {
        /**
         * Accepted status.
         */
        ACCEPTED,
        /**
         * Denied status.
         */
        DENIED,
        /**
         * PENDING status.
         */
        PENDING
    }
}
