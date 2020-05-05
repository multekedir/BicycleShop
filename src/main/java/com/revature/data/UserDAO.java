package com.revature.data;

import com.revature.models.User;
import com.revature.utility.ConnectionUtil;
import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

import static com.revature.singleton.LoggerSingleton.getLogger;
import static com.revature.utility.SQLBuilder.*;

public class UserDAO extends DAO<User> {
    ConnectionUtil cu = ConnectionUtil.getConnectionUtil();
    private static final String TABLE_NAME = "users";


    @Override
    PreparedStatement exctractData(PreparedStatement ps, User user) throws SQLException {
        getLogger(UserDAO.class).debug("Extracting user data");
        assert (ps != null & user != null);
        ps.setString(1, user.getUsername());
        ps.setString(2, user.getFirstName());
        ps.setString(3, user.getLastName());
        ps.setString(4, user.getPassword());
        ps.setString(5, String.valueOf(user.getRole()));
        return ps;
    }


    @Override
    User setData(ResultSet rs) throws SQLException {
        getLogger(UserDAO.class).info("Setting user data");
        User user = new User(rs);
        getLogger(UserDAO.class).debug(user);
        return user;
    }

    @Override
    void exctractID(User user, ResultSet rs) throws SQLException {

        if (rs.next()) {
            getLogger(UserDAO.class).info("Extracting user ID");
            user.setID(rs.getInt(1));
        }
    }


    public boolean insert(User user) {
        String sql = insertInto(TABLE_NAME, "user_name", "first_name", "last_name", "password", "role");


        getLogger(UserDAO.class).debug("Adding " + user);

        try (Connection conn = cu.getConnection()) {
            conn.setAutoCommit(false);
            return super.insert(user, TABLE_NAME, sql, conn);

        } catch (SQLException ex) {
            getLogger(UserDAO.class).error(ex.toString());
        }
        getLogger(UserDAO.class).debug("Connection Closed");
        getLogger(UserDAO.class).info("User not added");
        return false;
    }

    public User getUserByUserName(String username) {
        getLogger(UserDAO.class).info("Getting user using ID");


        try (Connection conn = cu.getConnection()) {
            String sql = selectWhere(TABLE_NAME, "", "user_name");
            getLogger(UserDAO.class).debug("My SQL statement " + sql);
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                getLogger(UserDAO.class).debug("User with username " + username + " found.");
                User user = new User(rs);
                getLogger(UserDAO.class).debug(user);
                return user;
            }
            getLogger(UserDAO.class).info("User Not Found");

        } catch (SQLException ex) {
            getLogger(UserDAO.class).error(ex);

        }
        return null;
    }


    public User getUserByID(int id) {

        getLogger(UserDAO.class).info("Getting user using ID");
        try (Connection conn = cu.getConnection()) {
            return super.getUserByID(id, TABLE_NAME, conn);
        } catch (SQLException ex) {
            getLogger(UserDAO.class).error(ex);

        }

        return null;

    }


    public Set<User> getAll() {
        try (Connection conn = cu.getConnection()) {
            return super.getAll(TABLE_NAME, conn);
        } catch (SQLException ex) {
            getLogger(UserDAO.class).error(ex);

        }
        return null;
    }


    public User update(@NotNull User user) {
        StringBuilder builder = new StringBuilder();

        String sql = updateSQL(TABLE_NAME, "id", "user_name", "first_name", "last_name", "password", "role");
        getLogger(UserDAO.class).info("Updating to " + user);
        getLogger(UserDAO.class).debug("My SQL statement " + sql);
        try (Connection conn = cu.getConnection()) {
            conn.setAutoCommit(false);
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getFirstName());
            pstmt.setString(3, user.getLastName());
            pstmt.setString(4, user.getPassword());
            pstmt.setString(5, String.valueOf(user.getRole()));
            pstmt.setInt(6, user.getID());
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                getLogger(UserDAO.class).info("User successfully updated.");
                conn.commit();
                return user;
            } else {
                getLogger(UserDAO.class).info("No User found with that id.");
                conn.rollback();
            }


        } catch (SQLException ex) {
            getLogger(UserDAO.class).error(ex.toString());
        }
        getLogger(UserDAO.class).debug("Connection Closed");
        getLogger(UserDAO.class).info("User not added");
        return null;
    }

    public boolean delete(User user) {
        try (Connection conn = cu.getConnection()) {
            return super.delete(user.getID
                    (), TABLE_NAME, conn);
        } catch (SQLException ex) {
            getLogger(UserDAO.class).error(ex);
        }
        getLogger(UserDAO.class).debug("Connection Closed");
        return false;
    }

}
