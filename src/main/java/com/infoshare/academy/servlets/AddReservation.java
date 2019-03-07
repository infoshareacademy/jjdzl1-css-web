package com.infoshare.academy.servlets;

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
import java.util.Date;

@WebServlet("/admin/addReservation")
public class AddReservation extends HttpServlet {

    @EJB
    ReservationRepositoryDao dao;
    CarsRepositoryDao daoCar;
    UsersRepositoryDao daoUser;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String carId = req.getParameter("carId");
        String userId = req.getParameter("userId");
        String startDate = req.getParameter("startDate");
        String endDate = req.getParameter("endDate");

        Car car = daoCar.getCar(Integer.parseInt(carId));
        User user = daoUser.getUserById(Integer.parseInt(userId));

        Reservation reservation = new Reservation(user,car,LocalDate.parse(startDate),LocalDate.parse(endDate));

        dao.addReservation(reservation);
        req.getRequestDispatcher("admin/admin.jsp").forward(req, resp);
    }
}
