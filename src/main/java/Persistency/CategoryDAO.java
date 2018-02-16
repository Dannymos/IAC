package Persistency;

import Model.Category;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import static Model.Category.CategoryBuilder.aCategory;
public class CategoryDAO extends BaseDAO{

    private ArrayList<Category> getCategories(String query){
        ArrayList<Category> results = new ArrayList<Category>();
        try(Connection con = super.getlocalConnection()){

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()){

                int categoryid = rs.getInt("category_id");
                String name = rs.getString("category_name");
                String description = rs.getString("description");
                String picture = rs.getString("picture");


                Category category = aCategory()
                        .setDescription(description)
                        .setId(categoryid)
                        .setName(name)
                        .setPicture(picture)
                        .build();

                results.add(category);
            }

        }

        catch(Exception e){
            e.printStackTrace();
        }
        return results;

    }
    public ArrayList<Category> getAllCategories(){

        return getCategories("select * from category where subcategory_id is null");
    }
}
