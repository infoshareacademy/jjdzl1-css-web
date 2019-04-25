package com.infoshare.academy.servlets.reservationServlet;

import com.infoshare.academy.dao.ReservationRepositoryDao;
import com.infoshare.academy.domain.Reservation;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static com.infoshare.academy.utils.ReservationMessages.*;

@WebServlet("/admin/deleteReservation")
public class DeleteReservationByAdmin extends HttpServlet {

    @EJB
    ReservationRepositoryDao dao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String page = req.getParameter("currentPage");
        String login = req.getParameter("login");
        String name = req.getParameter("name");

        List<Reservation> reservations = dao.listLimit(login, name, currentPage(page));

        if (reservations == null || reservations.isEmpty()) {
            req.setAttribute("error", errorNoReservationToRm());
        } else {
            req.setAttribute("noOfPages", noOfPages(login, name));
            req.setAttribute("currentPage", currentPage(page));
            req.setAttribute("login", login);
            req.setAttribute("name", name);
            req.setAttribute("reservations", reservations);
        }
        req.getRequestDispatcher("/admin/deleteReservation.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String idString = req.getParameter("id");

        if (idString == null || idString.isEmpty()) {
            req.setAttribute("error", errorNoReservationToRm());
        } else {
            Integer id = Integer.valueOf(idString);
            Reservation reservation = dao.getReservationById(id);

            if (reservation == null) {
                req.setAttribute("error", errorNoReservationToRm());
            } else {
                dao.deleteReservation(id);
                req.setAttribute("success", successReservationRm());
            }
        }
        req.getRequestDispatcher("/admin/deleteReservation.jsp").forward(req, resp);
    }

    public Integer noOfPages(String login, String name) {
        int rows = dao.listCount(login, name);
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
