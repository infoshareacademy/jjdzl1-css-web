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

import static com.infoshare.academy.utils.ReservationMessages.errorUserHevNoReservation;

@WebServlet("/admin/getReservationListByUserId")
public class GetReservationByUserId extends HttpServlet {

    @EJB
    ReservationRepositoryDao dao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");

        if (id == null || id.isEmpty()) {
            req.setAttribute("error", errorUserHevNoReservation());
        } else {

            List<Reservation> reservationListByUserId = dao.getReservationListByUserId(Integer.parseInt(id));

            if (reservationListByUserId == null || reservationListByUserId.isEmpty()) {
                req.setAttribute("error", errorUserHevNoReservation());
            } else
                req.setAttribute("reservationListByUserId", reservationListByUserId);

        }
        req.getRequestDispatcher("/admin/getReservationListByUserId.jsp").

                forward(req, resp);

    }
}