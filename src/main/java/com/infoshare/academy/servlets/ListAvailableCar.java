package com.infoshare.academy.servlets;

import com.infoshare.academy.dao.CarsRepositoryDao;
import com.infoshare.academy.dao.ReservationRepositoryDao;
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

        List<Reservation> list = daoReservation
                .getReservationListAvailableCar(LocalDate.parse(startDate), LocalDate.parse(endDate));


        TreeSet<Reservation> reservationListAvailableCar =
                list.stream()
                .collect(Collectors.toCollection(
                        ()->new TreeSet<Reservation>((p1,p2)->p1.getCar().getId()
                        .compareTo(p2.getCar().getId()))
                ));

                req.setAttribute("reservationListAvailableCar", reservationListAvailableCar);

        req.getRequestDispatcher("/listAvailableCar.jsp").forward(req, resp);
    }
}
