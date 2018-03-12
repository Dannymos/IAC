package services;


import Controller.OrderController;
import Model.Order;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/order")

public class OrderService {
        OrderController oc = new OrderController();

        @GET
        @Path("/{id}")
        public Order getOrderByID(@PathParam("id")int id){

            return oc.getOrderByID(id);
        }
}
