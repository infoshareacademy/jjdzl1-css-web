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

        String page=req.getParameter("currentPage");
        String startDate = req.getParameter("startDate");
        String endDate = req.getParameter("endDate");

        if (startDate == null || startDate.isEmpty() || endDate == null || endDate.isEmpty()) {
            req.setAttribute("error", errorStartGreaterNow());
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

                List<Car> carListAvailableCarLimit = daoReservation.getCarListAvailableCarLimit(start, end, currentPage(page));

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                req.setAttribute("noOfPages", noOfPages(start,end));
                req.setAttribute("currentPage", currentPage(page));
                req.setAttribute("startDate", start.format(formatter));
                req.setAttribute("start", start);
                req.setAttribute("endDate", end.format(formatter));
                req.setAttribute("end", end);
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

            Integer idThisCar = Integer.valueOf(carId);
            String startDate = req.getParameter("startDate");
            String endDate = req.getParameter("endDate");
            LocalDate start = LocalDate.parse(startDate);
            LocalDate end = LocalDate.parse(endDate);

            Car car = daoCar.getCar(idThisCar);

            List<Car> carListAvailableCar = daoReservation.getCarListAvailableCar(start, end);
            for (Car cars : carListAvailableCar) {
                Integer idCar = cars.getId();
                if (idCar == idThisCar) {

                    Reservation reservation = new Reservation(getUser(username), car, start, end);
                    daoReservation.addReservation(reservation);
                    req.setAttribute("success", successReservationAdd());
                    req.getRequestDispatcher("/reservation.jsp").forward(req, resp);
                }
            }
        }
        req.setAttribute("errorReservation", errorIncorrectIdCar());
        req.getRequestDispatcher("/reservation.jsp").forward(req, resp);

    }

    public User getUser(String username) {
        return daoUser.getUserByLogin(username);
    }

    public int noOfPages(LocalDate start,LocalDate end){
        int rows=daoReservation.getCountCarListAvailableCar(start,end);

        int noOfPages = rows / 3;
        if (rows % 3 > 0) {
            noOfPages++;
        }
        return noOfPages;
    }
    public int currentPage(String page){
        return Integer.valueOf(page);
    }
}


