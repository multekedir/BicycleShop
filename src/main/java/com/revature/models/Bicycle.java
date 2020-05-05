package com.revature.models;

import com.revature.data.UserDAO;
import com.revature.singleton.LoggerSingleton;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.StringJoiner;

import static com.revature.data.DAOFactory.getUserDAO;

public class Bicycle {
    private Integer id;
    private String name;
    private double cost;
    private Person owner;


    public Bicycle(String name, double cost, Person owner) {
        this.name = name;
        this.cost = cost;
        this.owner = owner;
        LoggerSingleton.getLogger(Bicycle.class).info("Created Person with all defined");
    }

    public Bicycle(String name, double cost) {
        this.name = name;
        this.cost = cost;
        LoggerSingleton.getLogger(Bicycle.class).info("Created Person with name and cost");
    }

    public Bicycle(ResultSet rs) throws SQLException {
        this.setName(rs.getString("name".toUpperCase()));
        this.setCost(rs.getDouble("cost".toUpperCase()));
        int ownerID = (rs.getInt("owner".toUpperCase()));
        this.setOwner(getUserDAO().getUserByID(ownerID));
        this.setId(rs.getInt("ID"));
    }


    /**
     * Gets cost.
     *
     * @return Value of cost.
     */
    public double getCost() {
        return cost;
    }

    /**
     * Sets new cost.
     *
     * @param cost New value of cost.
     */
    public void setCost(double cost) {
        this.cost = cost;
    }

    /**
     * Gets name.
     *
     * @return Value of name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets new name.
     *
     * @param name New value of name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets owner.
     *
     * @return Value of owner.
     */
    public Person getOwner() {
        return owner;
    }

    /**
     * Sets new owner.
     *
     * @param owner New value of owner.
     */
    public void setOwner(User owner) {
        this.owner = owner;
    }

    /**
     * Sets new owner.
     *
     * @param id id of the owner.
     */
    public void setOwner(int id) {
        System.out.println(id);
        UserDAO dao = new UserDAO();
        this.owner = dao.getUserByID(id);
    }

    /**
     * Gets id.
     *
     * @return Value of id.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets new id.
     *
     * @param id New value of id.
     */
    public void setId(Integer id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return new StringJoiner(", ", this.getClass().getSimpleName() + "[", "]")
                .add("cost = " + cost)
                .add("id = " + id)
                .add("name = " + name)
                .add("owner = " + owner)
                .toString();
    }
}
