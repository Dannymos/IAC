package Persistency;

import Model.ProdCats;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import static Model.ProdCats.ProdCatsBuilder.aProdCats;

public class ProdCatDAO extends BaseDAO{

    private ArrayList<ProdCats> getProdCats(String query){
        ArrayList<ProdCats> results = new ArrayList<ProdCats>();
        try(Connection con = super.getConnection()){

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()){

                int productid = rs.getInt("product_id");
                int categoryid = rs.getInt("category_id");
                int id = rs.getInt("category_product_id");

                ProdCats prodcat = aProdCats()
                        .setCategory(categoryid)
                        .setProduct(productid)
                        .setId(id)
                        .build();

                results.add(prodcat);
            }

        }

        catch(Exception e){
            e.printStackTrace();
        }
        return results;

    }

    public ArrayList<ProdCats> getAllProdCats(){
        return getProdCats("select * from category_product");
    }
    public ArrayList<ProdCats> getAllProdCatsByCategory(int category){
        return getProdCats("select * from category_product where category_id = "+category);
    }
    public ArrayList<ProdCats> getAllProdCatsByProduct(int product){
        return getProdCats("select * from category_product where product_id = "+product);
    }

    public boolean addProductToCategory(int prodid,int catid){

        try (Connection con = super.getConnection()) {

            String query = "INSERT INTO category_product (product_id, category_id)" +
                    " VALUES(?, ?)";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1,prodid);
            stmt.setInt(2,catid);

            if(stmt.executeUpdate() == 1) {

                return true;
            }

        } catch (Exception sqle) {
            sqle.printStackTrace();
        }

        return false;
    }
    public boolean deleteProductFromCategory(int prodid,int catid){

        try (Connection con = super.getConnection()) {

            String query = "delete from category_product " +
                    " where category_id = ?" +
                    " and product_id = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1,catid);
            stmt.setInt(2,prodid);


            if(stmt.executeUpdate() == 1) {

                return true;
            }

        } catch (Exception sqle) {
            sqle.printStackTrace();
        }

        return false;
    }
}
