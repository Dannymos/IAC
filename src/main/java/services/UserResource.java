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
    public Response registerUser(@QueryParam("postalcode") String postcode, @QueryParam("housenumber") int housenumber, @QueryParam("phonenumber") int phonenumber, @QueryParam("name") String name, @QueryParam("email") String email, @QueryParam("password") String password) {
        if(controller.registerUser(postcode, housenumber, name, email, password, phonenumber)) {
            return Response.ok().build();
        }
        else {
            return Response.status(400).build();
        }
    }
}
