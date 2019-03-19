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

        String idString = req.getParameter("id");

        if (idString == null || idString.isEmpty()) {
            req.setAttribute("error", errorNoReservationToRm());
        } else {
            Integer id = Integer.valueOf(idString);
            List<Reservation> reservationByUserId = dao.getReservationListByUserId(id);

            if (reservationByUserId == null || reservationByUserId.isEmpty()) {
                req.setAttribute("error", errorNoReservationToRm());
            } else {
                req.setAttribute("reservationByUserId", reservationByUserId);
            }
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
}
