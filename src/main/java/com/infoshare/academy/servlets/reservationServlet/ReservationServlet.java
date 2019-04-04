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

        String page = req.getParameter("currentPage");
        String startDate = req.getParameter("startDate");
        String endDate = req.getParameter("endDate");

        if (startDate == null || startDate.isEmpty() || endDate == null || endDate.isEmpty()) {
            req.setAttribute("error", errorStartGreaterNow());
        } else {

            if (isPast(start(startDate))) {
                req.setAttribute("error", errorStartGreaterNow());
            } else if (isAfter(start(startDate), end(endDate))) {
                req.setAttribute("error", errorEndGreaterThanStart());
            } else {

                List<Car> carListAvailableCarLimit = daoReservation.getCarListAvailableCarLimit(start(startDate), end(endDate), currentPage(page));

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                req.setAttribute("noOfPages", noOfPages(start(startDate), end(endDate)));
                req.setAttribute("currentPage", currentPage(page));
                req.setAttribute("startDate", start(startDate).format(formatter));
                req.setAttribute("start", start(startDate));
                req.setAttribute("endDate", end(endDate).format(formatter));
                req.setAttribute("end", end(endDate));
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

            String startDate = req.getParameter("startDate");
            String endDate = req.getParameter("endDate");

            List<Car> carListAvailableCar = daoReservation.getCarListAvailableCar(start(startDate), end(endDate));
            for (Car cars : carListAvailableCar) {
                Integer idCar = cars.getId();
                if (idCar == car(carId).getId()) {

                    Reservation reservation = new Reservation(getUser(username), car(carId), start(startDate), end(endDate));
                    daoReservation.addReservation(reservation);
                    req.setAttribute("success", successReservationAdd());
                    req.getRequestDispatcher("/reservation.jsp").forward(req, resp);
                }
            }
        }
        req.setAttribute("errorReservation", errorIncorrectIdCar());
        req.getRequestDispatcher("/reservation.jsp").forward(req, resp);

    }
    public LocalDate now=LocalDate.now();

    public Integer pageSize=3;

    public Car car(String carId) {
        Integer id = Integer.valueOf(carId);
        return daoCar.getCar(id);
    }

    public LocalDate start(String startDate) { return LocalDate.parse(startDate); }

    public LocalDate end(String endDate) { return LocalDate.parse(endDate); }

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


