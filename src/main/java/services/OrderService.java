package services;


import Controller.OrderController;
import Model.Order;
import Model.OrderRule;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.awt.*;
import java.util.ArrayList;

@Path("/order")

public class OrderService {
        OrderController oc = new OrderController();

        @GET
        @Path("/{id}")
        @Produces(MediaType.APPLICATION_JSON)
        public Order getOrderByID(@PathParam("id")int id){

            return oc.getOrderByID(id);
        }
        @GET
        @Path("/items/{id}")
        @Produces(MediaType.APPLICATION_JSON)
        public ArrayList<OrderRule> getOrderRulesByOrder(@PathParam("id")int id){

                return oc.getOrderrulesByOrder(id);
        }
}
