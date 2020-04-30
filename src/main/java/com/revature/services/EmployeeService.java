package com.revature.services;


import com.revature.data.DAOFactory.DB;
import com.revature.models.Bicycle;

import static com.revature.data.DAOFactory.getDAO;
import static com.revature.singleton.LoggerSingleton.getLogger;


public class EmployeeService {


    public static Bicycle addBicycle(Bicycle bicycle) {
        getLogger(EmployeeService.class).info("Adding Bicycle");
        int id = getDAO(DB.Bicycle).add(bicycle);
        bicycle.setId(id);
        return bicycle;
    }

    public static boolean removeBicycle(Bicycle bicycle) {
        getLogger(EmployeeService.class).debug("Removing -> " + bicycle);
        if (getDAO(DB.Bicycle).size() > 0 && bicycle != null) {
            if (bicycle.getId() != null) {
                return getDAO(DB.Bicycle).delete(bicycle.getId());
            }
            getLogger(EmployeeService.class).error("Bicycle not added properly. ID is NULL " + bicycle);

        }
        getLogger(EmployeeService.class).error("Something went wrong  " + bicycle);
        return false;
    }

}
