package Persistency;

import Model.Product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import static Model.Product.ProductBuilder.aProduct;

public class ProductDAO extends BaseDAO {


    private ArrayList<Product> getProducts(String query){
        ArrayList<Product> results = new ArrayList<Product>();
        try(Connection con = super.getConnection()){

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()){

                int productid = rs.getInt("product_id");
                int taxid = rs.getInt("tax_id");
                String product_name = rs.getString("product_name");
                float price = rs.getFloat("price");
                String explanation = rs.getString("explanation");
                String image = rs.getString("image_url");

                Product product = aProduct()
                        .setId(productid)
                        .setTax(taxid)
                        .setName(product_name)
                        .setPrice(price)
                        .setExplanation(explanation)
                        .setImage(image)
                        .build();

                results.add(product);
            }

        }

        catch(Exception e){
            e.printStackTrace();
        }
        return results;

    }
    public ArrayList<Product> getAllProducts(){

        return getProducts("select * from product");
    }

    public Product getProduct(int id){

        return getProducts("select * from product where id = " + id).get(0);
    }

    public boolean deleteProduct(int id){
        try (Connection con = super.getConnection()) {
            Statement stmt = con.createStatement();
            String query = "delete from product where id = "+ id;
            if(stmt.executeUpdate(query) == 1){
                return true;
            }
            else {
                return false;
            }

        } catch (Exception sqle) {
            sqle.printStackTrace();
        }
    }

    public boolean editProduct(Product product) {
        try (Connection con = super.getConnection()) {

            Statement stmt = con.createStatement();
            String query = "UPDATE product " +
                    "SET product_name = " + product.getName() + " " +
                    "SET price = " + product.getPrice() + " " +
                    "SET explanation = " + product.getExplanation() + " " +
                    "SET image_url = " + product.getImage() + " " +
                    "WHERE id = " + product.getId();

            if(stmt.executeUpdate(query) == 1){
                return true;
            }
            else {
                return false;
            }

        } catch (Exception sqle) {
            sqle.printStackTrace();
        }
        return false;
    }

    public boolean addProduct(Product product){
        try (Connection con = super.getConnection()) {

            Statement stmt = con.createStatement();
            String query = "INSERT INTO product VALUES(product_product_id_seq.NEXTVAL, " + product.getName() + ", " + product.getPrice() + ", " + product.getExplanation() + ", " + product.getImage() + ")";

            if(stmt.executeUpdate(query) == 1){
                return true;
            }
            else {
                return false;
            }

        } catch (Exception sqle) {
            sqle.printStackTrace();
        }
        return false;
    }
}
