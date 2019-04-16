package com.infoshare.academy.service;


import com.infoshare.academy.dao.ReservationRepositoryDao;
import com.infoshare.academy.domain.Car;
import org.jboss.logging.Logger;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDate;
import java.util.List;

@Path("/")
public class ReservationService {

    @EJB
    private ReservationRepositoryDao reservationDao;

    public static Logger LOGGER=Logger.getLogger(ReservationService.class.getName());

    @GET
    @Path("/reservations")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getReservationList() {

        return Response.ok(reservationDao.list()).build();
    }


    @GET
    @Path("/reservation")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getReservationById(@QueryParam("id") Integer id) {
        return Response.ok(reservationDao.getReservationById(id)).build();
    }

    @GET
    @Path("/availableAllCar")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAvailableCar(
            @QueryParam("startDate") String startDate,
            @QueryParam("endDate") String endDate) {

        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);

        List<Car> cars = reservationDao.getCarListAvailableCar(start, end);

        if (cars != null) {
            return Response.ok(cars).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
    @GET
    @Path("/availableCar")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAvailableCar(
            @QueryParam("startDate") String startDate,
            @QueryParam("endDate") String endDate,
            @QueryParam("currentPage") Integer currentPage,
            @QueryParam("pageSize") Integer pageSize) {

        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);

        List<Car> cars = reservationDao.getCarListAvailableCarLimit(start, end,currentPage,pageSize);

            return Response.ok(cars).build();
    }
    @GET
    @Path("/reservationUser")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getReservationForUser(
            @QueryParam("id") Integer id,
            @QueryParam("currentPage") Integer currentPage,
            @QueryParam("pageSize") Integer pageSize){
        return Response.ok(reservationDao.reservationListByUserIdLimit(id,currentPage,pageSize)).build();
    }
}

