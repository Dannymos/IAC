package services;


import Controller.OrderController;
import Model.Order;
import Model.OrderRule;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.awt.*;
import java.util.ArrayList;

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
        public  Response getOrderRulesByOrder(@PathParam("id")int id){

                return Response.status(200).entity(oc.getOrderrulesByOrder(id)).build();
        }

        @POST
        @Path("/{id}")

        public Response addProductToOrder(@PathParam("id")int id,@QueryParam("product")int productid,@QueryParam("amount")int amount){

            boolean succesful = oc.addProductToOrder(id,productid,amount);

            if (succesful) {
                return Response.status(201).build();
            }
            else{
                return Response.status(400).build();
            }
        }
}
