package com.infoshare.academy.service;

import com.infoshare.academy.dao.CarsRepositoryDao;
import com.infoshare.academy.domain.Car;

import javax.ejb.EJB;
import javax.ws.rs.*;
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

    @GET
    @Path("/cars/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCarById(@PathParam("id") int id) {
        Car car = carDao.getCar(id);
        if (car != null) {
            return Response.ok(carDao.getCar(id)).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("/car")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteCarById(@QueryParam("id") Integer id) {
        Car car = carDao.getCar(id);
        if (car != null){
            carDao.deleteCar(id);
            return Response.ok().build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
