package com.revature.data;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

import static com.revature.singleton.LoggerSingleton.getLogger;
import static com.revature.utility.SQLBuilder.*;

public abstract class DAO<T> {

    abstract PreparedStatement exctractData(PreparedStatement ps, T t) throws SQLException;

    abstract T setData(ResultSet rs) throws SQLException;

    abstract void exctractID(T t, ResultSet rs) throws SQLException;

    public boolean insert(T t, String tableName, String sql, Connection conn) throws SQLException {
        Integer key = 0;
        conn.setAutoCommit(false);
        String[] keys = {"id"};
        getLogger(DAO.class).debug("My SQL statement " + sql);
        PreparedStatement ps = exctractData(conn.prepareStatement(sql, keys), t);
        //should return number of rows affected
        int i = ps.executeUpdate();
        if (i == 1) {
            ResultSet rs = ps.getGeneratedKeys();
            exctractID(t, rs);
            conn.commit();
            getLogger(DAO.class).debug("Added " + t);
            return true;
        }
        getLogger(DAO.class).error("Not added successfully.");
        conn.rollback();
        return false;
    }

    public T getById(int id, String tableName, Connection conn) throws SQLException {

        String sql = selectWhere(tableName, "", "id");
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            getLogger(DAO.class).debug("Object with id " + id + " found. ");
            return setData(rs);
        }
        getLogger(DAO.class).info("Not Found");


        return null;
    }


    public Set<T> getAll(String tableName, Connection conn) throws SQLException {
        Set<T> collections = new HashSet<T>();

        String sql = selectAll(tableName);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            collections.add(setData(rs));
        }

        return collections;

    }

    abstract T update(T t) throws SQLException;

    boolean delete(int id, String tableName, Connection conn) throws SQLException {
        conn.setAutoCommit(false);
        String sql = deleteSQL(tableName);
        PreparedStatement ps = conn.prepareStatement(sql);
        getLogger(DAO.class).info("Removing ...");
        getLogger(DAO.class).debug("My SQL statement " + sql);
        ps.setInt(1, id);
        if (ps.executeUpdate() > 0) {
            getLogger(DAO.class).info("Removed object successfully.");
            conn.commit();
        } else {
            getLogger(DAO.class).info("No Object found with that id.");
            conn.rollback();
        }

        return true;
    }

}
