package Persistency;

import Model.Order;
import Model.Product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import static Model.Order.OrderBuilder.anOrder;

public class OrderDAO extends BaseDAO {

    OrderruleDAO ordao = new OrderruleDAO();
    private ArrayList<Order> getOrders(String query) {
        ArrayList<Order> results = new ArrayList<Order>();
        try (Connection con = super.getConnection()) {

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);




            while (rs.next()) {
                int custID = rs.getInt("Customer_ID");
                String deliveryAddress = rs.getString("delivery_Address");
                int id = rs.getInt("order_id");
                String status = rs.getString("status");

                Order order = anOrder()
                        .setCustomer_id(custID)
                        .setDeliveryAddress(deliveryAddress)
                        .setId(id)
                        .setItems(ordao.getOrderulesbyOrder(id))
                        .setStatus(status).build();

                results.add(order);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return results;

    }

    public Order getOrderByID(int id) {


        return getOrders("select * from product_order where order_id= "+id).get(0);
    }
}
