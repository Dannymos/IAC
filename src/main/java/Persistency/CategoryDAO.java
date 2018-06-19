package Persistency;

import Model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import static Model.Category.CategoryBuilder.aCategory;
public class CategoryDAO extends BaseDAO{

    private ArrayList<Category> getCategories(String query){
        ArrayList<Category> results = new ArrayList<Category>();
        try(Connection con = super.getConnection()){

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
    public ArrayList<Category> getMainCategories(){

        return getCategories("select * from category where subcategory_id is null");
    }
    public ArrayList<Category> getSubCategories(int id){

        return getCategories("select * from category where subcategory_id = "+id);
    }
    public ArrayList<Category> getAllSubCategories(){

        return getCategories("select * from category where subcategory_id is not null");
    }
    public Category getCategory(int id){

        return getCategories("select * from category where category_id = "+id).get(0);
    }
    public boolean addMainCategory(Category category){
        try (Connection con = super.getConnection()) {
            String query = "INSERT INTO category (category_name,description,picture)" +
                    " VALUES(?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1,category.getName());
            stmt.setString(2,category.getDescription());
            stmt.setString(3,category.getPicture());

            if(stmt.executeUpdate(query) == 1) {
                return true;
            }

        } catch (Exception sqle) {
            sqle.printStackTrace();
        }
        return false;
    }

    public boolean addSubCategory(Category category,int mainCategory){

        try (Connection con = super.getConnection()) {

            String query = "INSERT INTO category (category_name,description,picture,subcategory_id)" +
                    " VALUES(?, ?, ?,?)";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1,category.getName());
            stmt.setString(2,category.getDescription());
            stmt.setString(3,category.getPicture());
            stmt.setInt(4,mainCategory);

            if(stmt.executeUpdate(query) == 1) {
                return true;
            }

        } catch (Exception sqle) {
            sqle.printStackTrace();
        }
        return false;
    }

}
