package services;


import Controller.OrderController;
import Model.Order;
import Model.OrderRule;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.awt.*;
import java.util.ArrayList;

import static Model.Order.OrderBuilder.anOrder;

@Path("/order")

public class OrderService {
        OrderController oc = new OrderController();

        @GET
        @Path("/{id}")
        @Produces(MediaType.APPLICATION_JSON)
        public Response getOrderByID(@PathParam("id")int id){

            return  Response.status(200).entity(oc.getOrderByID(id)).build();
        }
        @GET
        @Path("/items/{id}")
        @Produces(MediaType.APPLICATION_JSON)
        public  ArrayList<OrderRule> getOrderRulesByOrder(@PathParam("id")int id){

                return oc.getOrderrulesByOrder(id);
        }

        @POST
        @Path("/{id}")

        public Response addProductsToOrder(@PathParam("id")int id,@QueryParam("product")int productid,@QueryParam("amount")int amount){

            boolean succesful = oc.addProductToOrder(id,productid,amount);

            if (succesful) {
                return Response.status(201).build();
            }
            else{
                return Response.status(400).build();
            }
        }

        @POST
        @Path("/complete")

        public Response completeOrder(@QueryParam("CustomerID")int customerID,@QueryParam("deliveryAddress")String deliveryaddress){
            Order order = anOrder().setCustomer_id(customerID)
                    .setDeliveryAddress(deliveryaddress)
                    .build();
            int orderid = oc.completeOrder(order);

            return Response.status(200).entity(orderid).build();
        }


}
