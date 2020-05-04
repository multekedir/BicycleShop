package com.revature.data;

import com.revature.models.User;
import com.revature.utility.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

import static com.revature.singleton.LoggerSingleton.getLogger;
import static com.revature.utility.SQLBuilder.insertInto;

public class UserDAO implements Dao<User> {
    ConnectionUtil cu = ConnectionUtil.getConnectionUtil();

    public UserDAO() {


    }

    @Override
    public boolean insert(User user) {
        Connection conn = cu.getConnection();
        String sql;
        getLogger(UserDAO.class).debug("Adding " + user);
        try {
            conn.setAutoCommit(false);
            sql = insertInto("users", "user_name", "first_name", "last_name", "password", "role");
            getLogger(UserDAO.class).debug("My SQL statement " + sql);
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getFirstName());
            ps.setString(3, user.getLastName());
            ps.setString(4, user.getPassword());
            ps.setString(5, String.valueOf(user.getRole()));
            getLogger(UserDAO.class).trace("My SQL statement " + ps.toString());

            //should return number of rows affected
            int i = ps.executeUpdate();
            if (i == 1) {
                conn.commit();
                getLogger(UserDAO.class).debug("Added User" + user);
                return true;
            }
            getLogger(UserDAO.class).info("Cat not added successfully.");
            conn.rollback();
        } catch (SQLException ex) {
            getLogger(UserDAO.class).error(ex.toString());
        }
        getLogger(UserDAO.class).info("User not added");
        return false;
    }

    @Override
    public User getUserByID(int id) {
        getLogger(UserDAO.class).info("Getting user using ID");
        User user = null;
        return user;

    }

    @Override
    public Set<User> getAll() {
        return null;
    }


    @Override
    public boolean update(User user) {
        return false;
    }

    @Override
    public boolean delete(User user) {
        return false;
    }

    private User extractUser(ResultSet result) {
        return null;
    }
}
