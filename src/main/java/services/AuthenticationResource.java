package services;

import java.security.Key;
import java.util.ArrayList;
import java.util.Calendar;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import Model.Account;

import Model.User;
import Persistency.UserDAO;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;

@Path("/authentication")
public class AuthenticationResource {
    final static public Key key = MacProvider.generateKey();

    @POST
    @Path("/authenticate")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response authenticateUser(@FormParam("email") String email,
                                     @FormParam("password") String password) {
        try {
            // Authenticate the user against the database
            UserDAO dao = new UserDAO();
            User user = dao.findUser(email, password);

            if (user.getRole() == "") {
                throw new IllegalArgumentException("No user found!");
            }

            // Issue a token for the user
            Calendar expiration = Calendar.getInstance();
            expiration.add(Calendar.MINUTE, 30);

            String token = Jwts.builder()
                    .setSubject(email)
                    .claim("customer_id", Integer.toString(user.getCustomerId()))
                    .claim("role", user.getRole())
                    .setExpiration(expiration.getTime())
                    .signWith(SignatureAlgorithm.HS512, key)
                    .compact();
            // Return the token on the response
            String response = "{\"id\":\"" + Integer.toString(user.getCustomerId()) + "\", \"token\":\"" + token + "\", \"role\":\"" + user.getRole() +"\"}";
            return Response.ok(response).build();
        } catch (JwtException | IllegalArgumentException e) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }
}