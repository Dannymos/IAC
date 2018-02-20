package services;

import Controller.CategoryController;
import Model.Category;
import org.json.JSONArray;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

public class CategoryService {

    CategoryController cc = new CategoryController();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/categories")
    public JSONArray getMainCategories(){

        JSONArray categories = cc.getMainCategories();

        // takes advantage to toString() implementation to format as [a, b, c]
        return categories;
    }
}
