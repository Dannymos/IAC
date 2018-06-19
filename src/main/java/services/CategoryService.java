package services;

import Controller.CategoryController;
import Model.Category;
import org.json.JSONObject;

import static Model.Category.CategoryBuilder.aCategory;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

@Path("/categories")
public class CategoryService {

    CategoryController cc = new CategoryController();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/main")
    public ArrayList<Category> getMainCategories() {

        //Response.status(200).entity().build()
        return cc.getMainCategories();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{category}")
    public ArrayList<Category> getSubCategories(@PathParam("category") int category) {

        //Response.status(200).entity().build()
        return cc.getSubCategories(category);
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/subcategories")
    public ArrayList<Category> getAllSubCategories() {


        return cc.getAllSubCategoriesList();
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/product/{product}")
    public ArrayList<Category> getCategoriesFromProduct(@PathParam("product")int product){

        return cc.getCategoriesFromProduct(product);
    }
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("/main")
    public Response addMainCategory(@FormParam("category_name")String name,@FormParam("description")String description,@FormParam("url")String image){
        Category category = aCategory()
                .setPicture(image)
                .setName(name)
                .setDescription(description)
                .build();
        if (cc.addMainCategory(category)) {


            return Response.status(201).build();
        }
        else {
            return Response.status(400).build();
        }
    }
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("/sub")
    public Response addSubCategory(@FormParam("category_name")String name,@FormParam("description")String description,@FormParam("url")String image,@FormParam("maincategory")int maincategory){
        Category category = aCategory()
                .setPicture(image)
                .setName(name)
                .setDescription(description)
                .build();
        if (cc.addSubCategory(category,maincategory)) {


            return Response.status(201).build();
        }
        else{
            return Response.status(400).build();
        }
    }
}
