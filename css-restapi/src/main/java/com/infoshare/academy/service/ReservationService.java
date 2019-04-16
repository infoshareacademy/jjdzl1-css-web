package com.infoshare.academy.service;


import com.infoshare.academy.dao.ReservationRepositoryDao;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
public class ReservationService {

    @EJB
    private ReservationRepositoryDao repositoryDao;

    @GET
    @Path("/reservations")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getReservationList() {

        return Response.ok(repositoryDao.list()).build();
    }


    @GET
    @Path("/reservation/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getReservationById(@PathParam("id") Integer id){
        return Response.ok(repositoryDao.getReservationById(id)).build();
    }

}
