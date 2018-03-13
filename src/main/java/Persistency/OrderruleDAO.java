package Persistency;

import Model.OrderRule;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import static Model.OrderRule.OrderRuleBuilder.anOrderRule;

public class OrderruleDAO extends BaseDAO{

    private ArrayList<OrderRule> getOrderrules(String query) {
        ArrayList<OrderRule> results = new ArrayList<OrderRule>();
        try (Connection con = super.getConnection()) {

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            int amount = rs.getInt("amount");
            int id = rs.getInt("id");
            int orderID = rs.getInt("order_id");
            int productID = rs.getInt("product_id");



            String items = "items";
            while (rs.next()) {


                OrderRule orderrule = anOrderRule()
                        .setAmount(amount)
                        .setId(id)
                        .setOrder_id(orderID)
                        .setProduct_id(productID)
                        .build();

                results.add(orderrule);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return results;

    }

    public ArrayList<OrderRule> getOrderulesbyOrder(int id){
        return getOrderrules("select * from orderrule where orderID ="+ id);
    }
}
