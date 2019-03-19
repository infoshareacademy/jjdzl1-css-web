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
        String startDate = req.getParameter("startDate");
        String endDate = req.getParameter("endDate");
        LocalDate now = LocalDate.now();

        if (carId == null || carId.isEmpty()) {
            req.setAttribute("error", errorCarDoesntExist());
        } else if (userId == null || userId.isEmpty()) {
            req.setAttribute("error", errorUserDoesntExist());
        } else if (startDate == null || startDate.isEmpty()) {
            req.setAttribute("error", errorIncorrectDate());
        } else if (endDate == null || endDate.isEmpty()) {
            req.setAttribute("error", errorIncorrectDate());
        } else {


            LocalDate start = LocalDate.parse(startDate);
            LocalDate end = LocalDate.parse(endDate);
            boolean isAfter = start.isAfter(end);
            boolean isPast = now.isAfter(start);

            if (isAfter) {
                req.setAttribute("error", errorEndGreaterThanStart());
            } else if (isPast) {
                req.setAttribute("error", errorStartGreaterNow());
            } else {

                Car car = daoCar.getCar(Integer.parseInt(carId));
                User user = daoUser.getUserById(Integer.parseInt(userId));

                if (car == null) {
                    req.setAttribute("error", errorCarDoesntExist());

                } else if (user == null) {
                    req.setAttribute("error", errorUserDoesntExist());

                } else {

                    Reservation reservation = new Reservation(user, car, LocalDate.parse(startDate), LocalDate.parse(endDate));

                    dao.addReservation(reservation);
                    req.setAttribute("success", successReservationAdd());
                }
            }
        }
        req.getRequestDispatcher("addReservation.jsp").forward(req, resp);
    }
}
