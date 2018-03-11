package Persistency;

import Model.Offer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import static Model.Offer.OfferBuilder.anOffer;

public class OfferDAO extends BaseDAO{

    public Offer getOfferByProduct(int id) {
        try (Connection con = super.getConnection()) {

            Statement stmt = con.createStatement();
            String query = "SELECT * FROM offer WHERE product_id ="+ id;

            ResultSet result = stmt.executeQuery(query);

            if(result.next()) {
                int offerid = result.getInt("offer_id");
                int productid = result.getInt("product_id");
                Timestamp startdate = result.getTimestamp("start_date");
                Timestamp enddate = result.getTimestamp("end_date");
                Float reduction = result.getFloat("reduction");

                Offer offer = anOffer()
                        .setOffer_id(offerid)
                        .setProduct_id(productid)
                        .setStart_date(startdate)
                        .setEnd_date(enddate)
                        .setReduction(reduction)
                        .build();

                return offer;
            }

        } catch (Exception sqle) {
            sqle.printStackTrace();
        }
        return null;
    }

    public ArrayList<Offer> getAllOffers() {
        ArrayList<Offer> offers = new ArrayList<Offer>();
        try (Connection con = super.getConnection()) {

            Statement stmt = con.createStatement();
            String query = "SELECT * FROM offer";

            ResultSet result = stmt.executeQuery(query);

            if(result.next()) {
                int offerid = result.getInt("offer_id");
                int productid = result.getInt("product_id");
                Timestamp startdate = result.getTimestamp("start_date");
                Timestamp enddate = result.getTimestamp("end_date");
                Float reduction = result.getFloat("reduction");

                Offer offer = anOffer()
                        .setOffer_id(offerid)
                        .setProduct_id(productid)
                        .setStart_date(startdate)
                        .setEnd_date(enddate)
                        .setReduction(reduction)
                        .build();

                offers.add(offer);
            }

        } catch (Exception sqle) {
            sqle.printStackTrace();
        }
        return offers;
    }
}
