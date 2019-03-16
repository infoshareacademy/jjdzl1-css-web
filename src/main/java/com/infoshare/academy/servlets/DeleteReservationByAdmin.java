package com.infoshare.academy.servlets;

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

@WebServlet("/admin/deleteReservation")
public class DeleteReservationByAdmin extends HttpServlet {

    @EJB
    ReservationRepositoryDao dao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");

        if (id == null) {
            req.getRequestDispatcher("/admin/deleteReservation.jsp").forward(req, resp);
        } else if (id.isEmpty()) {
            req.setAttribute("error", errorMessage());
            req.getRequestDispatcher("/admin/deleteReservation.jsp").forward(req, resp);
        } else {
            List<Reservation> reservationByUserId = dao.getReservationListByUserId(Integer.valueOf(id));
            if (reservationByUserId != null) {
                req.setAttribute("reservationByUserId", reservationByUserId);
            }
            req.getRequestDispatcher("/admin/deleteReservation.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");

        if (id == null) {
            req.getRequestDispatcher("/admin/deleteReservation.jsp").forward(req, resp);
        } else if (id.isEmpty()) {
            req.setAttribute("error", errorMessage());
            req.getRequestDispatcher("/admin/deleteReservation.jsp").forward(req, resp);
        } else {
            List<Reservation> reservation = dao.getReservationListByUserId(Integer.valueOf(id));
            if (reservation != null) {
                dao.deleteReservation(Integer.valueOf(id));
            }
            req.getRequestDispatcher("/admin/deleteReservation.jsp").forward(req, resp);
        }
    }

    public static String errorMessage() {
        String html1 = "<div class=\"alert alert-danger\" role=\"alert\">";
        String html2 = "</div>";
        String errorData = "User or reservation id is incorrect! Please try again.";
        return html1 + errorData + html2;
    }
}
