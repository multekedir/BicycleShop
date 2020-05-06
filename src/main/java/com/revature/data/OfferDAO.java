package com.revature.data;

import com.revature.models.Bicycle;
import com.revature.models.Offer;
import com.revature.utility.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

import static com.revature.models.Offer.Status;
import static com.revature.singleton.LoggerSingleton.getLogger;
import static com.revature.utility.SQLBuilder.insertInto;
import static com.revature.utility.SQLBuilder.updateSQL;

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
        getLogger(OfferDAO.class).info("Setting offer data");
        Offer offer = new Offer(rs);
        getLogger(OfferDAO.class).debug(offer);
        return offer;
    }

    @Override
    void exctractID(Offer offer, ResultSet rs) throws SQLException {
        if (rs.next()) {
            getLogger(Offer.class).info("Extracting offer ID");
            offer.setId(rs.getInt(1));
        }
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

    public Offer getOfferByID(int id) {

        getLogger(OfferDAO.class).info("Getting offer using ID");
        try (Connection conn = cu.getConnection()) {
            return super.getById(id, TABLE_NAME, conn);
        } catch (SQLException ex) {
            getLogger(OfferDAO.class).error(ex);

        }

        return null;

    }


    public Set<Offer> getAll() {
        try (Connection conn = cu.getConnection()) {
            return super.getAll(TABLE_NAME, conn);
        } catch (SQLException ex) {
            getLogger(OfferDAO.class).error(ex);

        }
        return null;
    }

    public Set<Offer> getAllOtherOffers(Bicycle bicycle) {

        try (Connection conn = cu.getConnection()) {
            return super.getFiltered(TABLE_NAME, "bicycle_id", bicycle.getId(), conn);
        } catch (SQLException ex) {
            getLogger(OfferDAO.class).error(ex);

        }
        return null;
    }


    @Override
    public Offer update(Offer offer) {
        StringBuilder builder = new StringBuilder();
        String sql = updateSQL(TABLE_NAME, "id", "user_id", "bicycle_id", "amount", "status");
        getLogger(OfferDAO.class).info("Updating to " + offer);
        getLogger(OfferDAO.class).debug("My SQL statement " + sql);
        try (Connection conn = cu.getConnection()) {
            conn.setAutoCommit(false);
            PreparedStatement pstmt = conn.prepareStatement(sql);
            if (offer.getUser() != null)
                pstmt.setInt(1, offer.getUser().getID());
            else
                pstmt.setNull(1, java.sql.Types.INTEGER);
            if (offer.getBicycle() != null)
                pstmt.setInt(2, offer.getBicycle().getId());
            else
                pstmt.setNull(2, java.sql.Types.INTEGER);

            pstmt.setDouble(3, offer.getAmount());
            pstmt.setString(4, offer.getStatus());
            pstmt.setInt(5, offer.getId());

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                getLogger(OfferDAO.class).info("Offer successfully updated.");
                conn.commit();
                return offer;
            } else {
                getLogger(OfferDAO.class).info("No Offer found with that id.");
                conn.rollback();
            }


        } catch (SQLException ex) {
            getLogger(OfferDAO.class).error(ex.toString());
        }
        getLogger(OfferDAO.class).debug("Connection Closed");
        getLogger(OfferDAO.class).info("Offer not added");
        return null;
    }
}
