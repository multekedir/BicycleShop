package com.revature.services;

import com.revature.models.User;
import com.revature.models.User.Role;

import java.util.Set;

import static com.revature.data.DAOFactory.getUserDAO;

public class ManagerService {

    public static boolean hasManager() {
        return getUserDAO().filterWithRole(Role.Manager).size() != 0;
    }

    public static Set<User> getAllEmployees() {

        return getUserDAO().filterWithRole(Role.Employee);
    }

    public static boolean makeManager(int id) {
        User employee = getUserDAO().getUserByID(id);
        if (employee.getRole() == Role.Employee) {
            System.out.println("Making ->" + employee + " manager");
            employee.setRole(Role.Manager);
            return null != getUserDAO().update(employee);
        }
        return false;
    }

    public static boolean fireEmployee(int id) {
        User employee = getUserDAO().getUserByID(id);
        return getUserDAO().delete(employee);
    }

}
