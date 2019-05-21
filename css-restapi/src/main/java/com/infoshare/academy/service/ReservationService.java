package com.infoshare.academy.service;

import com.infoshare.academy.dao.CarsRepositoryDao;
import com.infoshare.academy.dao.ReservationRepositoryDao;
import com.infoshare.academy.dao.UsersRepositoryDao;
import com.infoshare.academy.domain.Car;
import com.infoshare.academy.domain.Reservation;
import com.infoshare.academy.domain.User;
import org.jboss.logging.Logger;

import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDate;
import java.util.List;

/**
 * CarSharingSystem service for Reservations
 */
@Path("/")
public class ReservationService {

    private static Logger LOGGER = Logger.getLogger(ReservationService.class.getName());

    @EJB
    private ReservationRepositoryDao reservationDao;
    @EJB
    private CarsRepositoryDao carDao;
    @EJB
    private UsersRepositoryDao userDao;

    @RolesAllowed("1")
    @GET
    @Path("/reservations")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getReservationList() {
        return Response.ok(reservationDao.list()).build();
    }

    @RolesAllowed("1")
    @GET
    @Path("/reservations")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getReservationById(@QueryParam("id") Integer id) {
        return Response.ok(reservationDao.getReservationById(id)).build();
    }

    @RolesAllowed({"1","0"})
    @GET
    @Path("/availableAllCar")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAvailableCar(
            @QueryParam("startDate") String startDate,
            @QueryParam("endDate") String endDate) {

        if (isPast(start(startDate)) || isAfter(start(startDate), end(endDate))) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        LOGGER.info("Get available car form: " + startDate + " to " + endDate);
        List<Car> cars = reservationDao.getCarListAvailableCar(start(startDate), end(endDate));

        if (cars != null) {
            return Response.ok(cars).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @RolesAllowed({"1","0"})
    @GET
    @Path("/availableCar")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAvailableCar(
            @QueryParam("startDate") String startDate,
            @QueryParam("endDate") String endDate,
            @QueryParam("currentPage") Integer currentPage,
            @QueryParam("pageSize") Integer pageSize) {

        if (isPast(start(startDate)) || isAfter(start(startDate), end(endDate))) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        LOGGER.info("Get available car form: " + startDate + " to " + endDate);
        List<Car> cars = reservationDao.getCarListAvailableCarLimit(start(startDate), end(endDate), currentPage, pageSize);

        return Response.ok(cars).build();
    }

    @RolesAllowed("1")
    @GET
    @Path("/reservationUser")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getReservationForUser(
            @QueryParam("id") Integer id,
            @QueryParam("currentPage") Integer currentPage,
            @QueryParam("pageSize") Integer pageSize) {

        LOGGER.info("Get list reservations for user id: " + id);

        if (id != null && currentPage > 0 && pageSize > 0) {
            return Response.ok(reservationDao.reservationListByUserIdLimit(id, currentPage, pageSize)).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @RolesAllowed("1")
    @POST
    @Path("/reservations")
    @Consumes({MediaType.APPLICATION_FORM_URLENCODED, MediaType.APPLICATION_JSON})
    @Produces(MediaType.APPLICATION_JSON)
    public Response addReservation(
            @FormParam("userId") String userId,
            @FormParam("carId") String carId,
            @FormParam("startDate") String startDate,
            @FormParam("endDate") String endDate) {

        if (userId.isEmpty() || carId.isEmpty() || startDate.isEmpty() || endDate.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        Integer idUser = Integer.parseInt(userId);
        Integer idCar = Integer.parseInt(carId);
        LOGGER.info("Get car by id: " + idCar);
        Car car = carDao.getCar(idCar);

        LOGGER.info("Get user by id: " + userId);
        User user = userDao.getUserById(idUser);

        LOGGER.info("Add reservation for user id: " + idUser + " car id: " + idCar);
        if (car != null && user != null) {
            Reservation reservation = new Reservation(user, car, start(startDate), end(endDate));

            return Response.ok(reservationDao.addReservation(reservation)).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @RolesAllowed("1")
    @DELETE
    @Path("/reservations")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteReservation(
            @QueryParam("id") String idString) {

        if (idString.isEmpty()) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        } else {
            Integer id = Integer.parseInt(idString);
            Reservation reservation = reservationDao.getReservationById(id);

            if (reservation != null) {
                LOGGER.info("Delete reservation by id: " + id);
                reservationDao.deleteReservation(id);
                return Response.ok().build();
            }
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    private LocalDate start(String startDate) {
        return LocalDate.parse(startDate);
    }

    private LocalDate end(String endDate) {
        return LocalDate.parse(endDate);
    }

    private boolean isAfter(LocalDate startDate, LocalDate endDate) {
        return startDate.isAfter(endDate);
    }

    private final LocalDate now = LocalDate.now();

    private boolean isPast(LocalDate startDate) {
        return now.isAfter(startDate);
    }
}
