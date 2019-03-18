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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

@WebServlet("/reservation")
public class ReservationServlet extends HttpServlet {

    @EJB
    CarsRepositoryDao daoCar;

    @EJB
    UsersRepositoryDao daoUser;

    @EJB
    ReservationRepositoryDao daoReservation;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String startDate = req.getParameter("startDate");
        String endDate = req.getParameter("endDate");

        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);

        List<Car> carListAvailableCar = daoReservation.getCarListAvailableCar(start, end);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        req.setAttribute("startDate", start.format(formatter));
        req.setAttribute("endDate", end.format(formatter));
        req.setAttribute("carListAvailableCar", carListAvailableCar);

        req.getRequestDispatcher("/reservation.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        String getUser = (String) session.getAttribute("username");
        User currentUser = getUser(getUser);
        Integer id = currentUser.getId();

        String carId = req.getParameter("carId");
        String startDate = req.getParameter("startDate");
        String endDate = req.getParameter("endDate");

        Car car = daoCar.getCar(Integer.parseInt(carId));
        User user = daoUser.getUserById(id);

        Reservation reservation = new Reservation(user, car, LocalDate.parse(startDate), LocalDate.parse(endDate));

        daoReservation.addReservation(reservation);
        req.getRequestDispatcher("/reservation.jsp").forward(req, resp);
    }

    public User getUser(String username) {
        return daoUser.getUserByLogin(username);
    }
}
