package services;

import Controller.ProductController;
import java.util.ArrayList;
import Model.Product;
import Model.Offer;
import org.glassfish.jersey.media.multipart.FormDataParam;

import static Model.Product.ProductBuilder.aProduct;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("/product")
public class ProductResource {

    ProductController controller = new ProductController();

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Product getProduct(@PathParam( "id" ) int id) {
            return controller.getProduct(id);

    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Product> getAllProducts() {

            return controller.getAllProducts();

    }
    @GET
    @Path("/category/{category}")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Product> getAllProductsFromCategory(@PathParam("category")int category){
        return controller.getAllProductsFromCategory(category);
    }













    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("/addproduct")

    public Response addProduct(@FormParam("name")String name, @FormParam("price")double price, @FormParam("explanation")String explanation, @FormParam("image")String image) {
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
            return Response.status(500).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deleteProduct(@PathParam( "id" ) int id) {
        if(controller.deleteProduct(id)) {
            return Response.ok("Succes").build();
        }
        else {

            return Response.status(500).build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("/{id}")
    public Response editProduct(@PathParam( "id" ) int id,MultivaluedMap<String ,String >formParams) {

        Product product = aProduct()
                .setName(formParams.getFirst("name"))
                .setPrice(Float.parseFloat(formParams.getFirst("price")))
                .setExplanation(formParams.getFirst("explanation"))
                .setImage(formParams.getFirst("image"))
                .setId(id)
                .build();

        if(controller.editProduct(product)) {
            return Response.ok("Succes").build();
        }
        else {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PUT
    @Path("/addcategory")
    public Response addCategoryToProduct(@QueryParam("product")int product,@QueryParam("category")int category){

        if(controller.updateCategoryOfProduct(product,category)){

            return Response.ok().build();
        }
        else{
            return Response.status(500).build();
        }
    }

}
