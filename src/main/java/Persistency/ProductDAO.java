package Persistency;

import Model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

            PreparedStatement stmt = con.prepareStatement("delete from product where product_id = ?");
           stmt.setInt(1,id);
           deleted = stmt.executeUpdate();
        } catch (Exception sqle) {
            sqle.printStackTrace();
        }
        return deleted==1;
    }

    public boolean editProduct(Product product) {
        int editted =0;
        try (Connection con = super.getConnection()) {

            String query = "UPDATE product " +
                    "set product_name = ?, " +
                    " price = ? ," +
                    " explanation = ?, " +
                    " image_url = ? " +
                    "WHERE product_id = ?" ;
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1,product.getName());
            stmt.setDouble(2,product.getPrice());
            stmt.setString(3,product.getExplanation());
            stmt.setString(4,product.getImage());
            stmt.setInt(5,product.getId());

            System.out.println(query);
            editted = stmt.executeUpdate();
        }
        catch (Exception sqle) {
            sqle.printStackTrace();
        }
        return editted==1;
    }

    public boolean addProduct(Product product){
        try (Connection con = super.getConnection()) {

            String query = "INSERT INTO product (product_name, price, explanation, image_url)" +
                    " VALUES(?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1,product.getName());
            stmt.setDouble(2,product.getPrice());
            stmt.setString(3,product.getExplanation());
            stmt.setString(4,product.getImage());

            if(stmt.executeUpdate() == 1) {
                return true;
            }

        } catch (Exception sqle) {
            sqle.printStackTrace();
        }
        return false;
    }
}
