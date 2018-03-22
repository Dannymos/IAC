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
    public boolean registerUser(@FormParam("email") String email, @FormParam("password1") String password) {
        return controller.registerUser(email, password);
    }
}
