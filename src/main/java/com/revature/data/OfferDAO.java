package com.revature.data;

import com.revature.models.Offer;
import com.revature.utility.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.revature.singleton.LoggerSingleton.getLogger;
import static com.revature.utility.SQLBuilder.insertInto;

public class OfferDAO extends DAO<Offer> {
    private static final String TABLE_NAME = "offer";
    ConnectionUtil cu = ConnectionUtil.getConnectionUtil();

    @Override
    PreparedStatement exctractData(PreparedStatement ps, Offer offer) throws SQLException {
        return null;
    }

    @Override
    Offer setData(ResultSet rs) throws SQLException {
        return null;
    }

    @Override
    void exctractID(Offer offer, ResultSet rs) throws SQLException {

    }

    @Override
    Offer update(Offer offer) throws SQLException {
        return null;
    }

    public boolean insert(Offer offer) {
        String sql = insertInto(TABLE_NAME, "user", "bicycle", "amount", "status");


        try (Connection conn = cu.getConnection()) {
            conn.setAutoCommit(false);
            return super.insert(offer, TABLE_NAME, sql, conn);

        } catch (SQLException ex) {
            getLogger(OfferDAO.class).error(ex.toString());
        }


        return false;
    }
}
