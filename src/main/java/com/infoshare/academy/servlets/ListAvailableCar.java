package com.infoshare.academy.servlets;

import com.infoshare.academy.dao.CarsRepositoryDao;
import com.infoshare.academy.dao.ReservationRepositoryDao;
import com.infoshare.academy.domain.Car;
import com.infoshare.academy.domain.Reservation;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;

@WebServlet("/listAvailableCar")
public class ListAvailableCar extends HttpServlet {

    @EJB
    CarsRepositoryDao daoCar;

    @EJB
    ReservationRepositoryDao daoReservation;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String startDate = req.getParameter("startDate");
        String endDate = req.getParameter("endDate");

        List<Reservation> reservationListAvailableCar= daoReservation
                .getReservationListAvailableCar(LocalDate.parse(startDate), LocalDate.parse(endDate));

//        Set<Reservation> reservationListAvailableCar = new LinkedHashSet<>(list);
//

//        HashSet<Reservation> reservationListAvailableCar=new HashSet<>();
//        list.removeIf(e->!reservationListAvailableCar.add(e.));


//        List<Car> reservationListAvailableCar=new ArrayList<Car>(new HashSet<Reservation>(list.get(1)));

        req.setAttribute("reservationListAvailableCar", reservationListAvailableCar);

        req.getRequestDispatcher("/listAvailableCar.jsp").forward(req, resp);
    }
}
