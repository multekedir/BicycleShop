package com.revature.data;

import com.revature.models.User;
import com.revature.utility.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

import static com.revature.utility.SQLBuilder.insertInto;

public class UserDAO implements Dao<User> {
    ConnectionUtil cu = ConnectionUtil.getConnectionUtil();

    public UserDAO() {


    }

    @Override
    public boolean insert(User user) {
        Connection conn = cu.getConnection();
        try {
            conn.setAutoCommit(false);
            String sql = insertInto("users", "user_name", "first_name", "last_name", "password", "role");
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getUsername());
            pstmt.setString(1, user.getFirstName());
            pstmt.setString(1, user.getLastName());
            pstmt.setString(1, user.getPassword());
            pstmt.setString(1, String.valueOf(user.getRole()));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return false;
    }

    @Override
    public User getUser() {
        return null;
    }

    @Override
    public Set<User> getAll() {
        return null;
    }

    @Override
    public Object getByID(int id) {
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
