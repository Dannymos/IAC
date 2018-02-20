package services;

import Controller.CategoryController;
import Model.Category;
import org.json.JSONArray;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
    @Path("/categories")
public class CategoryService {

    CategoryController cc = new CategoryController();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/main")
    public ArrayList<Category> getMainCategories(){


        return cc.getMainCategories();
    }
        @GET
        @Produces(MediaType.APPLICATION_JSON)
        @Path("/{category}/sub")
        public ArrayList<Category> getSubCategories(@PathParam("category")int category){


            return cc.getSubCategories(category);
        }
}
