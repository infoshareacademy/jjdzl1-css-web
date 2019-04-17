package com.infoshare.academy.service;


import com.infoshare.academy.dao.CarsRepositoryDao;
import com.infoshare.academy.dao.ReservationRepositoryDao;
import com.infoshare.academy.dao.UsersRepositoryDao;
import com.infoshare.academy.domain.Car;
import com.infoshare.academy.domain.Reservation;
import com.infoshare.academy.domain.User;
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

    @EJB
    private CarsRepositoryDao carDao;

    @EJB
    private UsersRepositoryDao userDao;

    public static Logger LOGGER = Logger.getLogger(ReservationService.class.getName());

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

        List<Car> cars = reservationDao.getCarListAvailableCarLimit(start, end, currentPage, pageSize);

        return Response.ok(cars).build();
    }

    @GET
    @Path("/reservationUser")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getReservationForUser(
            @QueryParam("id") Integer id,
            @QueryParam("currentPage") Integer currentPage,
            @QueryParam("pageSize") Integer pageSize) {
        return Response.ok(reservationDao.reservationListByUserIdLimit(id, currentPage, pageSize)).build();
    }

    @POST
    @Path("/reservation")
    @Consumes({MediaType.APPLICATION_FORM_URLENCODED, MediaType.APPLICATION_JSON})
    @Produces(MediaType.APPLICATION_JSON)
    public Response addReservation(
            @FormParam("userId") Integer userId,
            @FormParam("carId") Integer carId,
            @FormParam("startDate") String startDate,
            @FormParam("endDate") String endDate) {

        if (userId == null || carId == null || startDate == null || endDate == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        Car car = carDao.getCar(carId);
        User user = userDao.getUserById(userId);

        if (car != null && user != null) {
            Reservation reservation = new Reservation(user, car, start(startDate), end(endDate));

            return Response.ok(reservationDao.addReservation(reservation)).build();
        }

        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @DELETE
    @Path("/reservation")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteReservation(
            @QueryParam("id") Integer id) {

        Reservation reservation = reservationDao.getReservationById(id);

        if (reservation != null) {

            reservationDao.deleteReservation(id);
            return Response.ok().build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }


    public LocalDate start(String startDate) {
        return LocalDate.parse(startDate);
    }

    public LocalDate end(String endDate) {
        return LocalDate.parse(endDate);
    }
}



