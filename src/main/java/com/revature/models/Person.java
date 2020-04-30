package com.revature.models;

import java.util.Objects;
import java.util.StringJoiner;

import static com.revature.singleton.LoggerSingleton.getLogger;


/**
 * The type Person.
 */
public class Person {

    private String firstName;
    private String lastName;

    public Person() {
        this.firstName = "firstName";
        this.lastName = "lastName";
        getLogger(Person.class).info("Created Person with default constructor");
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        getLogger(Person.class).info("Created Person");
    }

    /**
     * Print name.
     */
    public void printName() {
        System.out.println(String.format("Person[firstName = %s, lastName = %s]", this.getFirstName(),
                this.getLastName()));
    }

    /**
     * Gets lastName.
     *
     * @return Value of lastName.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets new lastName.
     *
     * @param lastName New value of lastName.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets firstName.
     *
     * @return Value of firstName.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets new firstName.
     *
     * @param firstName New value of firstName.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Get full name string.
     *
     * @return the string
     */
    String getFullName() {
        return this.firstName + " " + this.lastName;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", this.getClass().getSimpleName() + "[", "]")
                .add("firstName = " + firstName)
                .add("lastName = " + lastName)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person that = (Person) o;

        return Objects.equals(this.firstName, that.firstName) &&
                Objects.equals(this.lastName, that.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

}
