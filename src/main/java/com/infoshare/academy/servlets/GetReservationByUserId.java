package com.infoshare.academy.servlets;

import com.infoshare.academy.dao.ReservationRepositoryDao;
import com.infoshare.academy.domain.Reservation;
import com.infoshare.academy.domain.User;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/admin/getReservationListByUserId")
public class GetReservationByUserId extends HttpServlet {

    @EJB
    ReservationRepositoryDao dao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");

        if (id.isEmpty()) {
            req.setAttribute("error", errorMessage());
        }

        List<Reservation> reservationListByUserId = dao.getReservationListByUserId(Integer.parseInt(id));

        if (reservationListByUserId.isEmpty()) {
            req.setAttribute("error", errorMessage());
        } else
            req.setAttribute("reservationListByUserId", reservationListByUserId);


        req.getRequestDispatcher("/admin/getReservationListByUserId.jsp").

                forward(req, resp);

    }

    public static String errorMessage() {
        String html1 = "<div class=\"alert alert-danger\" role=\"alert\">";
        String html2 = "</div>";
        String errorData = " User have no reservation.";
        return html1 + errorData + html2;
    }
}
