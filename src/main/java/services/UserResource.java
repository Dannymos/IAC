package services;

import Controller.UserController;
import Model.Account;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.awt.*;
import java.util.ArrayList;

@Path("/user")

public class UserResource {

    UserController controller = new UserController();

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Account getUserById(@PathParam("id") int id) {
        return controller.getUserById(id);
    }

    @POST
    @Path("/register")
    public Response registerUser(@FormParam("email") String email, @FormParam("password1") String password) {
        if(controller.registerUser(email, password)) {
            return Response.status(201).build();
        }
        else {
            return Response.status(400).build();
        }
    }
}
