package com.infoshare.academy.service;

import com.infoshare.academy.dao.CarsRepositoryDao;
import com.infoshare.academy.domain.Car;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.logging.Logger;

/**
 * CarSharingSystem service for Cars
 */
@Path("/")
public class CarService {

    private static final Logger LOGGER = Logger.getLogger(CarService.class.getName());

    @EJB
    private CarsRepositoryDao carDao;

    @GET
    @Path("/cars")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCarList() {
        return Response.ok(carDao.listCar()).build();
    }

    @GET
    @Path("/cars/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCarById(@PathParam("id") int id) {
        Car car = carDao.getCar(id);
        if (car != null) {
            return Response.ok(carDao.getCar(id)).build();
        }
        return Response.status(Response.Status.NOT_FOUND).entity("[ERROR] Car id not found: " + id).build();
    }

    @DELETE
    @Path("/cars/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response deleteCarById(@PathParam("id") Integer id) {
        Car car = carDao.getCar(id);
        if (car != null){
            carDao.deleteCar(id);
            LOGGER.info("[CarService] Deleted car with id=" + id);
            return Response.ok("[CarService] Deleted car with id=" + id).build();
        }
        return Response.status(Response.Status.NOT_FOUND).entity("[ERROR] Car id not found: " + id).build();
    }
}
