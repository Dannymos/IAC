package Controller;

import Model.Offer;
import Persistency.OfferDAO;

import java.util.ArrayList;

public class OfferController {

    private OfferDAO dao = new OfferDAO();

    public Offer getOfferByProduct(int id){ return dao.getOfferByProduct(id); }

    public ArrayList<Offer> getAllOffers() { return dao.getAllOffers(); }
}
