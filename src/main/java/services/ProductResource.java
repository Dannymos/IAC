package services;

import Controller.ProductController;
import java.util.ArrayList;
import Model.Product;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("/product")
public class ProductResource {

    ProductController controller = new ProductController();

    @GET
    @Path("/get/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Product getProduct(@PathParam( "id" ) int id) {
        try {
            return controller.getProduct(id);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    @GET
    @Path("/get/all")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Product> getAllProducts() {
        try {
            return controller.getAllProducts();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    @POST
    @Path("/add/{id}")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response addProduct(@PathParam( "id" ) int id) {
        Product product = new Product();
        if(controller.addProduct(id, product)) {
            return Response.ok("Succes").build();
        }
        else {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DELETE
    @Path("/delete/{id}")
    public Response deleteProduct(@PathParam( "id" ) int id) {
        if(controller.deleteProduct(id)) {
            return Response.ok("Succes").build();
        }
        else {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PUT
    @Path("/put/{id}")
    public Response editProduct(@PathParam( "id" ) int id) {
        if(controller.editProduct(id), product) {
            return Response.ok("Succes").build();
        }
        else {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
}