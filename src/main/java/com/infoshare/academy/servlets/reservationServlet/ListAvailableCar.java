package com.infoshare.academy.servlets.reservationServlet;

import com.infoshare.academy.dao.ReservationRepositoryDao;
import com.infoshare.academy.domain.Car;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static com.infoshare.academy.utils.CarMessages.errorMessage;
import static com.infoshare.academy.utils.ReservationMessages.errorEndGreaterThanStart;
import static com.infoshare.academy.utils.ReservationMessages.errorStartGreaterNow;

@WebServlet("/listAvailableCar")
public class ListAvailableCar extends HttpServlet {

    @EJB
    ReservationRepositoryDao daoReservation;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String startDate = req.getParameter("startDate");
        String endDate = req.getParameter("endDate");

        if (startDate == null || startDate.isEmpty() || endDate == null || endDate.isEmpty()) {
            req.getRequestDispatcher("/listAvailableCar.jsp").forward(req, resp);
        } else {
            LocalDate now = LocalDate.now();
            LocalDate start = LocalDate.parse(startDate);
            LocalDate end = LocalDate.parse(endDate);
            boolean isAfter = start.isAfter(end);
            boolean isPast = now.isAfter(start);

            if (isPast) {
                req.setAttribute("error", errorStartGreaterNow());
            } else if (isAfter) {
                req.setAttribute("error", errorEndGreaterThanStart());
            } else {

                List<Car> carListAvailableCar = daoReservation.getCarListAvailableCar(start, end);

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

                req.setAttribute("startDate", start.format(formatter));
                req.setAttribute("endDate", end.format(formatter));
                req.setAttribute("carListAvailableCar", carListAvailableCar);
            }
            req.getRequestDispatcher("/listAvailableCar.jsp").forward(req, resp);
        }
    }
}
