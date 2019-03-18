package com.infoshare.academy.servlets.reservationServlet;

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

import static com.infoshare.academy.utils.ReservationMessages.*;

@WebServlet("/delete")
public class DelateReservationByUser extends HttpServlet {

    @EJB
    ReservationRepositoryDao dao;

    @EJB
    UsersRepositoryDao daoUser;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        String getUser = (String) session.getAttribute("username");
        User currentUser = getUser(getUser);
        Integer id = currentUser.getId();

        List<Reservation> reservationByUserId = dao.getReservationListByUserId(id);

        if (reservationByUserId == null || reservationByUserId.isEmpty()) {
            req.setAttribute("error", errorEmptyReservationList());
        } else {
            req.setAttribute("reservationByUserId", reservationByUserId);
        }
        req.getRequestDispatcher("/deletereservation.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String idString = req.getParameter("id");
        Integer id = Integer.valueOf(idString);


        HttpSession session = req.getSession(false);
        String getUser = (String) session.getAttribute("username");
        User currentUser = getUser(getUser);
        Integer idUser = currentUser.getId();

        if (idString == null || idString.isEmpty()) {
            req.setAttribute("error", errorMessage());
        }
        Reservation reservation = dao.getReservationById(id);
        if (reservation == null) {
            req.setAttribute("error", errorUserDoesNotHaveReser());
        } else {
            Integer idUserInReservation = reservation.getUser().getId();
            if (reservation != null && idUser == idUserInReservation) {
                dao.deleteReservation(id);
                req.setAttribute("success", successReservationRm());
            } else {
                req.setAttribute("error", errorIncorectIdReservation());
            }
        }
        req.getRequestDispatcher("/deletereservation.jsp").forward(req, resp);

    }


    public User getUser(String username) {
        return daoUser.getUserByLogin(username);
    }
}
