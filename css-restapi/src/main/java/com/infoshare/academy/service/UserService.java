package com.infoshare.academy.service;

import com.infoshare.academy.dao.UsersRepositoryDao;
import com.infoshare.academy.domain.User;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.logging.Logger;

/**
 * CarSharingSystem service for Users
 */
@Path("/")
public class UserService {

    private static final Logger LOGGER = Logger.getLogger(UserService.class.getName());

    @EJB
    private UsersRepositoryDao userDao;

    @GET
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    public Response hello(@HeaderParam("user-agent") String userAgent) {
        return Response.ok("Hello from CarSharingSystem!\n" + userAgent).build();
    }

    @GET
    @Path("/users")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserList() {
        return Response.ok(userDao.getUsersList()).build();
    }

    @GET
    @Path("/users/{login}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserByLogin(@PathParam("login") String login) {
        User user = userDao.getUserByLogin(login);
        if (user != null) {
            return Response.ok(userDao.getUserByLogin(login)).build();
        }
        return Response.status(Response.Status.NOT_FOUND).entity("[ERROR] User login not found: " + login).build();
    }

    @GET
    @Path("/users/id/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserById(@PathParam("id") int id) {
        User user = userDao.getUserById(id);
        if (user != null) {
            return Response.ok(userDao.getUserById(id)).build();
        }
        return Response.status(Response.Status.NOT_FOUND).entity("[ERROR] User id not found: " + id).build();
    }

    @DELETE
    @Path("/users/{login}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response deleteUserByLogin(@PathParam("login") String login) {
        User user = userDao.getUserByLogin(login);
        if (user != null) {
            userDao.deleteUserByLogin(login);
            LOGGER.info("[UserService] Deleted user with login=" + login);
            return Response.ok("[UserService] Deleted user with login=" + login).build();
        }
        return Response.status(Response.Status.NOT_FOUND).entity("[ERROR] User login not found: " + login).build();
    }

    @DELETE
    @Path("/users/id/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response deleteUserById(@PathParam("id") int id) {
        User user = userDao.getUserById(id);
        if (user != null) {
            userDao.deleteUserById(id);
            LOGGER.info("[UserService] Deleted user with id=" + id);
            return Response.ok("[UserService] Deleted user with id=" + id).build();
        }
        return Response.status(Response.Status.NOT_FOUND).entity("[ERROR] User id not found: " + id).build();
    }
}
