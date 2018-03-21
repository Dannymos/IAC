package services;

import Model.Offer;
import Controller.OfferController;
import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/offer")
public class OfferResource {

    OfferController controller = new OfferController();

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Offer getOfferByProduct(@PathParam( "id" ) int id) {
        return controller.getOfferByProduct(id);
    }

    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Offer> getAllOffers() {
        return controller.getAllOffers();
    }
}
