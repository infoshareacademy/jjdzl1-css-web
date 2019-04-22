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

import static com.infoshare.academy.utils.ReservationMessages.*;

@WebServlet("/listAvailableCar")
public class ListAvailableCar extends HttpServlet {

    @EJB
    ReservationRepositoryDao daoReservation;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer pageSize=3;
        String start = req.getParameter("startDate");
        String end = req.getParameter("endDate");
        String page = req.getParameter("currentPage");

        if (start == null || start.isEmpty() || end == null || end.isEmpty()) {
            req.setAttribute("error", errorIncorrectDate());
        } else {

            if (isPast(start(start))) {
                req.setAttribute("error", errorStartGreaterNow());
            } else if (isAfter(start(start), end(end))) {
                req.setAttribute("error", errorEndGreaterThanStart());
            } else {

                List<Car> carListAvailableCarLimit = daoReservation
                        .getCarListAvailableCarLimit(start(start), end(end), currentPage(page),pageSize);

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                req.setAttribute("noOfPages", noOfPages(start(start), end(end)));
                req.setAttribute("currentPage", currentPage(page));
                req.setAttribute("start", start);
                req.setAttribute("end", end);
                req.setAttribute("startDate", start(start).format(formatter));
                req.setAttribute("endDate", end(end).format(formatter));
                req.setAttribute("carListAvailableCarLimit", carListAvailableCarLimit);
            }
        }
            req.getRequestDispatcher("/listAvailableCar.jsp").forward(req, resp);
    }

    public LocalDate now = LocalDate.now();

    public LocalDate start(String start) {
        return LocalDate.parse(start);
    }

    public LocalDate end(String end) {
        return LocalDate.parse(end);
    }

    public boolean isAfter(LocalDate start, LocalDate end) {
        return start.isAfter(end);
    }

    public boolean isPast(LocalDate start) {
        return now.isAfter(start);
    }

    public Integer noOfPages(LocalDate start, LocalDate end) {
        int rows = daoReservation.getCountCarListAvailableCar(start, end);
        int noOfPages = rows / 3;
        if (rows % 3 > 0) {
            noOfPages++;
        }
        return noOfPages;
    }

    public int currentPage(String page) {
        return Integer.valueOf(page);
    }
}
