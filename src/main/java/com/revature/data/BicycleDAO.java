package com.revature.data;

import com.revature.models.Bicycle;
import com.revature.utility.ConnectionUtil;

import java.sql.*;
import java.util.Set;

import static com.revature.singleton.LoggerSingleton.getLogger;
import static com.revature.utility.SQLBuilder.insertInto;

public class BicycleDAO extends DAO<Bicycle> {

    private static final String TABLE_NAME = "bicycles";
    ConnectionUtil cu = ConnectionUtil.getConnectionUtil();

    @Override
    PreparedStatement exctractData(PreparedStatement ps, Bicycle bicycle) throws SQLException {
        getLogger(BicycleDAO.class).debug("Extracting bicycle data");
        assert (ps != null & bicycle != null);
        ps.setString(1, bicycle.getName());
        ps.setDouble(2, bicycle.getCost());
        if (bicycle.getOwner() != null)
            ps.setInt(3, bicycle.getOwner().getID());
        ps.setNull(3, Types.INTEGER);
        return ps;
    }

    @Override
    Bicycle setData(ResultSet rs) throws SQLException {
        getLogger(BicycleDAO.class).info("Setting bicycle data");
        Bicycle bicycle = new Bicycle(rs);
        getLogger(BicycleDAO.class).debug(bicycle);
        return bicycle;
    }

    @Override
    void exctractID(Bicycle bicycle, ResultSet rs) throws SQLException {
        if (rs.next()) {
            getLogger(BicycleDAO.class).info("Extracting bicycle ID");
            bicycle.setId(rs.getInt(1));
        }
    }

    public boolean insert(Bicycle bicycle) {
        String sql = insertInto(TABLE_NAME, "name", "cost", "owner");


        getLogger(BicycleDAO.class).debug("Adding " + bicycle);

        try (Connection conn = cu.getConnection()) {
            conn.setAutoCommit(false);
            return super.insert(bicycle, TABLE_NAME, sql, conn);

        } catch (SQLException ex) {
            getLogger(BicycleDAO.class).error(ex.toString());
        }
        getLogger(BicycleDAO.class).debug("Connection Closed");
        getLogger(BicycleDAO.class).info("Bicycle not added");
        return false;
    }

    public Bicycle getBicycleAOByID(int id) {

        getLogger(BicycleDAO.class).info("Getting bicycle using ID");
        try (Connection conn = cu.getConnection()) {
            return super.getById(id, TABLE_NAME, conn);
        } catch (SQLException ex) {
            getLogger(BicycleDAO.class).error(ex);

        }

        return null;

    }

    public Set<Bicycle> getAll() {
        try (Connection conn = cu.getConnection()) {
            return super.getAll(TABLE_NAME, conn);
        } catch (SQLException ex) {
            getLogger(BicycleDAO.class).error(ex);

        }
        return null;
    }

    @Override
    Bicycle update(Bicycle bicycle) throws SQLException {
        return null;
    }
}
