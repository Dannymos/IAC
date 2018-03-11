package services;

import Controller.ProductController;
import java.util.ArrayList;
import Model.Product;
import Model.Offer;
import static Model.Product.ProductBuilder.aProduct;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("/product")
public class ProductResource {

    ProductController controller = new ProductController();

    @GET
    @Path("/get/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Product getProduct(@PathParam( "id" ) int id) {
            return controller.getProduct(id);

    }

    @GET
    @Path("/get/all")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Product> getAllProducts() {

            return controller.getAllProducts();

    }

    @POST
    @Path("/add}")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response addProduct(@FormParam("name") String name, @FormParam("Price") float price, @FormParam("explanation") String explanation, @FormParam("image") String image) {
        Product product = aProduct()
                .setName(name)
                .setPrice(price)
                .setExplanation(explanation)
                .setImage(image)
                .build();

        if(controller.addProduct(product)) {
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
        Product product = new Product();
        if(controller.editProduct(product)) {
            return Response.ok("Succes").build();
        }
        else {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

}