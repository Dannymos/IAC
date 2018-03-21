package Persistency;

import Model.Order;
import Model.Product;


import java.sql.Connection;
import java.sql.PreparedStatement;
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
    public Order getLatestOrder(){
        return getOrders("select * from product_order ORDER BY order_id DESC LIMIT 1").get(0);
    }
    public boolean addOrder(Order order) {
        int editted =0;
        try (Connection con = super.getConnection()) {

            String query = "insert into product_order (customer_id,status,delivery_address)" +
                    " values(?,?,?)";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1,order.getCustomer_id());
            stmt.setString(2,"new");
            stmt.setString(3,order.getDeliveryAddress());

            System.out.println(query);
            editted = stmt.executeUpdate();
        }
        catch (Exception sqle) {
            sqle.printStackTrace();
        }
        return editted==1;
    }
}
