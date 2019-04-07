package com.infoshare.academy.servlets.reservationServlet;

import com.infoshare.academy.dao.CarsRepositoryDao;
import com.infoshare.academy.dao.ReservationRepositoryDao;
import com.infoshare.academy.dao.UsersRepositoryDao;
import com.infoshare.academy.domain.Car;
import com.infoshare.academy.domain.Reservation;
import com.infoshare.academy.domain.User;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

import static com.infoshare.academy.utils.ReservationMessages.*;

@WebServlet("/admin/addReservation")
public class AddReservation extends HttpServlet {

    @EJB
    ReservationRepositoryDao dao;
    @EJB
    CarsRepositoryDao daoCar;
    @EJB
    UsersRepositoryDao daoUser;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String carId = req.getParameter("carId");
        String userId = req.getParameter("userId");
        String start = req.getParameter("startDate");
        String end = req.getParameter("endDate");

        if (carId == null || carId.isEmpty()) {
            req.setAttribute("error", errorCarDoesntExist());
        } else if (userId == null || userId.isEmpty()) {
            req.setAttribute("error", errorUserDoesntExist());
        } else if (start == null || start.isEmpty()) {
            req.setAttribute("error", errorIncorrectDate());
        } else if (end == null || end.isEmpty()) {
            req.setAttribute("error", errorIncorrectDate());
        } else {


            if (isAfter(start(start),end(end))) {
                req.setAttribute("error", errorEndGreaterThanStart());
            } else if (isPast(start(start))) {
                req.setAttribute("error", errorStartGreaterNow());
            } else {

                Car car = daoCar.getCar(Integer.parseInt(carId));
                User user = daoUser.getUserById(Integer.parseInt(userId));

                if (car == null) {
                    req.setAttribute("error", errorCarDoesntExist());

                } else if (user == null) {
                    req.setAttribute("error", errorUserDoesntExist());

                } else {

                    Reservation reservation = new Reservation(user, car, start(start), end(end));

                    dao.addReservation(reservation);
                    req.setAttribute("success", successReservationAdd());
                }
            }
        }
        req.getRequestDispatcher("addreservation.jsp").forward(req, resp);
    }

    public LocalDate now = LocalDate.now();

    public LocalDate start(String start) {
        return LocalDate.parse(start);
    }

    public LocalDate end(String end) {
        return LocalDate.parse(end);
    }

    public boolean isAfter(LocalDate start,LocalDate end) {
        return start.isAfter(end);
    }

    public boolean isPast(LocalDate start) {
        return now.isAfter(start);
    }
}
