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
    @Path("/get/user/{id}")
    public Account function(@PathParam("id") int id) {
        return controller.getUserById(id);
    }
}
