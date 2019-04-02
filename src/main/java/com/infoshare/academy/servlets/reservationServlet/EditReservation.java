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

import static com.infoshare.academy.utils.ReservationMessages.errorReservationDoesntExist;

@WebServlet("/admin/editReservation")
public class EditReservation extends HttpServlet {

    @EJB
    ReservationRepositoryDao dao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");

        if (id == null) {
            req.setAttribute("error", errorReservationDoesntExist());
        } else {

            Reservation reservations = dao.getReservationById(Integer.parseInt(id));

            if (reservations != null) {
                req.setAttribute("reservations", reservations);
            } else {
                req.setAttribute("error", errorReservationDoesntExist());
            }
        }
        req.getRequestDispatcher("/admin/editReservation.jsp").forward(req, resp);
    }
}
