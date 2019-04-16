package com.infoshare.academy.service;

import com.infoshare.academy.dao.CarsRepositoryDao;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
public class CarService {

    @EJB
    private CarsRepositoryDao carDao;

    @GET
    @Path("/cars")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCarList() {
        return Response.ok(carDao.listCar()).build();
    }
}
