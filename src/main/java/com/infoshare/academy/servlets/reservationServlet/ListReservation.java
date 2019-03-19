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

import static com.infoshare.academy.utils.ReservationMessages.errorEmptyListReservation;

@WebServlet("/admin/getListReservation")
public class ListReservation extends HttpServlet {

    @EJB
    ReservationRepositoryDao dao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Reservation> reservationList = dao.list();

        if (reservationList == null || reservationList.isEmpty()) {
            req.setAttribute("error", errorEmptyListReservation());

        } else {
            req.setAttribute("reservationList", reservationList);
        }
        req.getRequestDispatcher("/admin/listReservation.jsp").forward(req, resp);
    }

}

