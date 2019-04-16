package com.infoshare.academy.service;

import com.infoshare.academy.dao.UsersRepositoryDao;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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
    public Response getCarList() {
        return Response.ok(userDao.getUsersList()).build();
    }
}
