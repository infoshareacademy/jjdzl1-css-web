package com.infoshare.academy.service;

import com.infoshare.academy.dao.UsersRepositoryDao;
import com.infoshare.academy.domain.User;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
public class UserService {

    @EJB
    UsersRepositoryDao userDao;

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
    @Path("/users/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserById(@PathParam("id") int id) {
        User user = userDao.getUserById(id);
        if (user != null) {
            return Response.ok(userDao.getUserById(id)).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("/user")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteUserById(@QueryParam("id") Integer id) {
        User user = userDao.getUserById(id);
        if (user != null) {
            userDao.deleteUserById(id);
            return Response.ok().build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("/userByLogin")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteUserByLogin(@QueryParam("login") String login) {
        User user = userDao.getUserByLogin(login);
        if (user != null) {
            userDao.deleteUserByLogin(login);
            return Response.ok().build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }


}
