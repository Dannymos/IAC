package Controller;

import Model.Order;
import Persistency.OrderDAO;

public class OrderController {

    OrderDAO odao = new OrderDAO();

    public Order getOrderByID(int id){

        return odao.getOrderByID(id);



    }
}
