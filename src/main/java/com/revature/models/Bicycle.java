package com.revature.models;

import com.revature.singleton.LoggerSingleton;

public class Bicycle {
    private String name;
    private double cost;
    private Person owner;


    public Bicycle(String name, double cost, Person owner) {
        this.name = name;
        this.cost = cost;
        this.owner = owner;
        LoggerSingleton.logger.info("Created Person with all defined");
    }

    public Bicycle(String name, double cost) {
        this.name = name;
        this.cost = cost;
        LoggerSingleton.logger.info("Created Person with name and cost");
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
    public void setOwner(Person owner) {
        this.owner = owner;
    }


}
