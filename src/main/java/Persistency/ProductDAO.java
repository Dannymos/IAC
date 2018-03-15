package Persistency;

import Model.Product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import static Model.Product.ProductBuilder.aProduct;

public class ProductDAO extends BaseDAO {

    OfferDAO odao = new OfferDAO();

    private ArrayList<Product> getProducts(String query){
        ArrayList<Product> results = new ArrayList<Product>();
        try(Connection con = super.getConnection()){

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {

                int productid = rs.getInt("product_id");

                String product_name = rs.getString("product_name");
                float price = rs.getFloat("price");
                String explanation = rs.getString("explanation");
                String image = rs.getString("image_url");
                if (odao.getOfferByProduct(productid) != null) {
                    Product product = aProduct()
                            .setId(productid)
                            .setName(product_name)
                            .setPrice(price)
                            .setExplanation(explanation)
                            .setImage(image)
                            .setOffer(odao.getOfferByProduct(productid))
                            .build();
                    results.add(product);
                } else {
                    Product product = aProduct()
                            .setId(productid)
                            .setName(product_name)
                            .setPrice(price)
                            .setExplanation(explanation)
                            .setImage(image)

                            .build();

                    results.add(product);
                }
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

        return getProducts("select * from product where product_id = " + id).get(0);
    }

    public boolean deleteProduct(int id){
        int deleted =0;

        try (Connection con = super.getConnection()) {
            Statement stmt = con.createStatement();
            String query = "delete from product where product_id = "+ id;
           deleted = stmt.executeUpdate(query);
        } catch (Exception sqle) {
            sqle.printStackTrace();
        }
        return deleted==1;
    }

    public boolean editProduct(Product product) {
        int editted =0;
        try (Connection con = super.getConnection()) {

            Statement stmt = con.createStatement();
            String query = "UPDATE product " +
                    "SET product_name = " + product.getName() + " " +
                    "SET price = " + product.getPrice() + " " +
                    "SET explanation = " + product.getExplanation() + " " +
                    "SET image_url = " + product.getImage() + " " +
                    "WHERE product_id = " + product.getId();

            editted = stmt.executeUpdate(query);
        }
        catch (Exception sqle) {
            sqle.printStackTrace();
        }
        return editted==1;
    }

    public boolean addProduct(Product product){
        try (Connection con = super.getConnection()) {

            Statement stmt = con.createStatement();
            String query = "INSERT INTO product (product_name, price, explanation, image_url)" +
                    " VALUES( " + product.getName() + ", " + product.getPrice() + ", " + product.getExplanation() + ", " + product.getImage() + ")";

            if(stmt.executeUpdate(query) == 1) {
                return true;
            }

        } catch (Exception sqle) {
            sqle.printStackTrace();
        }
        return false;
    }
}
