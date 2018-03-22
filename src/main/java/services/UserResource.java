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
    @Path("/get/{id}")
    public Account getUserById(@PathParam("id") int id) {
        return controller.getUserById(id);
    }

    @POST
    @Path("/register")
    public boolean registerUser(@FormParam("email") String email, @FormParam("password1") String password1, @FormParam("password2") String password2) {
        return controller.registerUser(email, password1, password2);
    }
}
