package com.revature.data;

import com.revature.models.Offer;
import com.revature.utility.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.revature.models.Offer.Status;
import static com.revature.singleton.LoggerSingleton.getLogger;
import static com.revature.utility.SQLBuilder.insertInto;

public class OfferDAO extends DAO<Offer> {
    private static final String TABLE_NAME = "offers";
    ConnectionUtil cu = ConnectionUtil.getConnectionUtil();

    @Override
    PreparedStatement exctractData(PreparedStatement ps, Offer offer) throws SQLException {
        getLogger(OfferDAO.class).debug("Extracting offer data");
        assert (ps != null & offer != null);
        ps.setInt(1, offer.getUser().getID());
        ps.setInt(2, offer.getBicycle().getId());
        ps.setDouble(3, offer.getAmount());
        ps.setString(4, String.valueOf(offer.getStatus()));
        return ps;
    }

    @Override
    Offer setData(ResultSet rs) throws SQLException {
        return null;
    }

    @Override
    void exctractID(Offer offer, ResultSet rs) throws SQLException {
        if (rs.next()) {
            getLogger(Offer.class).info("Extracting offer ID");
            offer.setId(rs.getInt(1));
        }
    }

    @Override
    Offer update(Offer offer) throws SQLException {
        return null;
    }

    public boolean insert(Offer offer) {
        String sql = insertInto(TABLE_NAME, "user_id", "bicycle_id", "amount", "status");


        try (Connection conn = cu.getConnection()) {
            conn.setAutoCommit(false);
            offer.setStatus(Status.PENDING);
            return super.insert(offer, TABLE_NAME, sql, conn);

        } catch (SQLException ex) {
            getLogger(OfferDAO.class).error(ex.toString());
        }


        return false;
    }
}
