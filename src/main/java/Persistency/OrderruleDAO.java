package Persistency;

import Model.OrderRule;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import static Model.OrderRule.OrderRuleBuilder.anOrderRule;

public class OrderruleDAO extends BaseDAO{
    ProductDAO pdao = new ProductDAO();
    private ArrayList<OrderRule> getOrderrules(String query) {
        ArrayList<OrderRule> results = new ArrayList<OrderRule>();
        try (Connection con = super.getConnection()) {

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);


            while (rs.next()) {
                int amount = rs.getInt("amount");
                int id = rs.getInt("orderrule_id");
                int orderID = rs.getInt("order_id");
                int productID = rs.getInt("product_id");


                OrderRule orderrule = anOrderRule()
                        .setAmount(amount)
                        .setId(id)
                        .setOrder_id(orderID)
                        .setProduct(pdao.getProduct(productID))
                        .build();

                results.add(orderrule);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return results;

    }

    public ArrayList<OrderRule> getOrderulesbyOrder(int id){
        return getOrderrules("select * from orderrule where order_ID ="+ id);
    }

    public boolean addProductToOrder(int id,int product,int amount){
        try (Connection con = super.getConnection()) {

            String query = "INSERT INTO orderrule(order_id,product_id,amount) " +
                    "values (?,?,?) ";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1,id);
            stmt.setInt(2,product);
            stmt.setInt(3,amount);

            if(stmt.executeUpdate() == 1) {
                return true;
            }

        } catch (Exception sqle) {
            sqle.printStackTrace();
        }
        return false;
    }
}
