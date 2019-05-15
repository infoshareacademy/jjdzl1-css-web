package com.infoshare.academy.servlets.reservation;

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
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static com.infoshare.academy.utils.ReservationMessages.*;


@WebServlet("reservationconfirm")
public class ReservationConfirm extends HttpServlet {

    @EJB
    CarsRepositoryDao daoCar;

    @EJB
    UsersRepositoryDao daoUser;

    @EJB
    ReservationRepositoryDao daoReservation;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String start = req.getParameter("startDate");
        String end = req.getParameter("endDate");
        String carId = req.getParameter("carId");
        HttpSession session = req.getSession(false);
        String username = (String) session.getAttribute("username");

        Car car = daoCar.getCar(Integer.parseInt(carId));
        User user = daoUser.getUserByLogin(username);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        req.setAttribute("car", car);
        req.setAttribute("user", user);
        req.setAttribute("start", start(start));
        req.setAttribute("end", end(end));
        req.setAttribute("startDate", start(start).format(formatter));
        req.setAttribute("endDate", end(end).format(formatter));
        req.setAttribute("period", period(start(start), end(end)));
        req.setAttribute("price",price(car));
        req.setAttribute("cost",cost(car,start(start),end(end)));


        req.getRequestDispatcher("/reservationconfirm.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        String username = (String) session.getAttribute("username");

        String carId = req.getParameter("carId");
        if (carId == null || carId.isEmpty()) {
            req.setAttribute("error", errorCarDoesntExist());
        } else {

            String start = req.getParameter("startDate");
            String end = req.getParameter("endDate");

            List<Car> carListAvailableCar = daoReservation.getCarListAvailableCar(start(start), end(end));
            for (Car cars : carListAvailableCar) {
                Integer idCar = cars.getId();
                if (idCar == car(carId).getId()) {

                    Reservation reservation = new Reservation(getUser(username), car(carId), start(start), end(end));
                    daoReservation.addReservation(reservation);
                    req.setAttribute("success", successReservationAdd());
                    req.getRequestDispatcher("/reservation.jsp").forward(req, resp);
                }
            }
        }
        req.setAttribute("errorReservation", errorIncorrectIdCar());

    }
    public int price(Car car) {
        int type = car.getCarType();
        switch (type) {
            case 1:
                return 80;
            case 2:
                return 150;
            case 3:
                return 300;
        }
        return 100;
    }
    public int cost(Car car,LocalDate start,LocalDate end){
        return price(car)*period(start,end);
    }

    public LocalDate start(String start) {
        return LocalDate.parse(start);
    }

    public Car car(String carId) {
        Integer id = Integer.valueOf(carId);
        return daoCar.getCar(id);
    }

    public LocalDate end(String end) {
        return LocalDate.parse(end);
    }

    public int period(LocalDate start, LocalDate end) {
        Period between = Period.between(start, end);
        return between.getDays() + 1;
    }

    public User getUser(String username) {
        return daoUser.getUserByLogin(username);
    }

}
