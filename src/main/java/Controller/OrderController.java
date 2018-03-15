package Controller;

import Model.Order;
import Model.OrderRule;
import Persistency.OrderDAO;
import Persistency.OrderruleDAO;

import java.util.ArrayList;

public class OrderController {

    OrderDAO odao = new OrderDAO();
    OrderruleDAO ordao = new OrderruleDAO();


    public Order getOrderByID(int id){

        return odao.getOrderByID(id);



    }
    public ArrayList<OrderRule> getOrderrulesByOrder(int id){
        return ordao.getOrderulesbyOrder(id);
    }
}
