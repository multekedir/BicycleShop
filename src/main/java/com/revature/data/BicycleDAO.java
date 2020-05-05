package com.revature.data;

import com.revature.models.Bicycle;
import com.revature.utility.ConnectionUtil;

import java.sql.*;

import static com.revature.singleton.LoggerSingleton.getLogger;
import static com.revature.utility.SQLBuilder.insertInto;

public class BicycleDAO extends DAO<Bicycle> {

    private static final String TABLE_NAME = "bicycles";
    ConnectionUtil cu = ConnectionUtil.getConnectionUtil();

    @Override
    PreparedStatement exctractData(PreparedStatement ps, Bicycle bicycle) throws SQLException {
        getLogger(UserDAO.class).debug("Extracting user data");
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
        return null;
    }

    @Override
    void exctractID(Bicycle bicycle, ResultSet rs) throws SQLException {
        if (rs.next()) {
            getLogger(UserDAO.class).info("Extracting user ID");
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

    @Override
    Bicycle update(Bicycle bicycle) throws SQLException {
        return null;
    }
}
