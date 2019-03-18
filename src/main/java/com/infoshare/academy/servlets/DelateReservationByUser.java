package com.infoshare.academy.servlets;

import com.infoshare.academy.dao.ReservationRepositoryDao;
import com.infoshare.academy.dao.UsersRepositoryDao;
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
import java.util.List;

@WebServlet("/delete")
public class DelateReservationByUser extends HttpServlet {

    @EJB
    ReservationRepositoryDao dao;

    @EJB
    UsersRepositoryDao daoUser;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer id = getCurrentUserId(req);

        List<Reservation> reservationByUserId = dao.getReservationListByUserId(id);

        if (reservationByUserId == null) {
            req.setAttribute("error", errorMessage());
        } else {
            req.setAttribute("reservationByUserId", reservationByUserId);
        }
        req.getRequestDispatcher("/deletereservation.jsp").forward(req, resp);
    }

    public Integer getCurrentUserId(HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        String getUser = (String) session.getAttribute("username");
        User currentUser = getCurrentUserId(getUser);
        return currentUser.getId();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");

        if (id == null) {
            req.getRequestDispatcher("/deletereservation.jsp").forward(req, resp);
        } else if (id.isEmpty()) {
            req.setAttribute("error", errorMessage());
            req.getRequestDispatcher("/deletereservation.jsp").forward(req, resp);
        } else {
            List<Reservation> reservation = dao.getReservationListByUserId(Integer.parseInt(id));
            if (reservation != null) {
                dao.deleteReservation(Integer.valueOf(id));
            }
            req.getRequestDispatcher("/deletereservation.jsp").forward(req, resp);
        }
    }

    public static String errorMessage() {
        String html1 = "<div class=\"alert alert-danger\" role=\"alert\">";
        String html2 = "</div>";
        String errorData = "User or reservation id is incorrect! Please try again.";
        return html1 + errorData + html2;
    }

    public User getCurrentUserId(String username) {
        return daoUser.getUserByLogin(username);
    }
}
