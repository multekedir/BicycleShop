package com.revature.services;

import com.revature.data.GenericDAO;
import com.revature.models.Bicycle;

import static com.revature.singleton.LoggerSingleton.getLogger;


public class EmployeeService {
    private static GenericDAO<Bicycle> bicycleDB;

    static {
        bicycleDB = new GenericDAO(Bicycle.class);
    }

    public static Bicycle addBicycle(Bicycle bicycle) {
        getLogger().info("Adding Bicycle");
        int id = bicycleDB.add(bicycle);
        bicycle.setId(id);
        return bicycle;
    }

    public static boolean removeBicycle(Bicycle bicycle) {
        getLogger().debug("Removing -> " + bicycle);
        if (bicycleDB.size() > 0 && bicycle != null) {
            if (bicycle.getId() != null) {
                return bicycleDB.delete(bicycle.getId());
            }
            getLogger().error("Bicycle not added properly. ID is NULL " + bicycle);

        }
        getLogger().error("Something went wrong  " + bicycle);
        return false;
    }


    /**
     * Gets bicycleDB.
     *
     * @return list of bicycle .
     */
    public static GenericDAO<Bicycle> getBicycleDB() {
        return bicycleDB;
    }
}
