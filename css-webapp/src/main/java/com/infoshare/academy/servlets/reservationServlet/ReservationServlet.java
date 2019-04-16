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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static com.infoshare.academy.utils.ReservationMessages.*;

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

        Integer pageSize=3;
        String page = req.getParameter("currentPage");
        String start = req.getParameter("startDate");
        String end = req.getParameter("endDate");

        if (start == null || start.isEmpty() || end == null || end.isEmpty()) {
            req.setAttribute("error", errorStartGreaterNow());
        } else {

            if (isPast(start(start))) {
                req.setAttribute("error", errorStartGreaterNow());
            } else if (isAfter(start(start), end(end))) {
                req.setAttribute("error", errorEndGreaterThanStart());
            } else {

                List<Car> carListAvailableCarLimit = daoReservation.getCarListAvailableCarLimit(start(start), end(end), currentPage(page),pageSize);

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                req.setAttribute("noOfPages", noOfPages(start(start), end(end)));
                req.setAttribute("currentPage", currentPage(page));
                req.setAttribute("startDate", start(start).format(formatter));
                req.setAttribute("start", start(start));
                req.setAttribute("endDate", end(end).format(formatter));
                req.setAttribute("end", end(end));
                req.setAttribute("carListAvailableCarLimit", carListAvailableCarLimit);
            }
            req.getRequestDispatcher("/reservation.jsp").forward(req, resp);
        }
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
    public LocalDate now=LocalDate.now();

    public Integer pageSize=3;

    public Car car(String carId) {
        Integer id = Integer.valueOf(carId);
        return daoCar.getCar(id);
    }

    public LocalDate start(String start) { return LocalDate.parse(start); }

    public LocalDate end(String end) { return LocalDate.parse(end); }

    public boolean isAfter(LocalDate start, LocalDate end) { return start.isAfter(end); }

    public boolean isPast(LocalDate start) { return now.isAfter(start); }

    public User getUser(String username) { return daoUser.getUserByLogin(username); }

    public int noOfPages(LocalDate start, LocalDate end) {
        int rows = daoReservation.getCountCarListAvailableCar(start, end);

        int noOfPages = rows / pageSize;
        if (rows % pageSize > 0) {
            noOfPages++;
        }
        return noOfPages;
    }

    public int currentPage(String page) {
        return Integer.valueOf(page);
    }
}


