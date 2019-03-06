package com.infoshare.academy.servlets;

import com.infoshare.academy.dao.ReservationRepositoryDao;
import com.infoshare.academy.domain.Reservation;

import javax.ejb.EJB;
import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin/deleteReservation")
public class DeleteReservation extends HttpServlet {

    @EJB
    ReservationRepositoryDao dao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        resp.setContentType("text/html;charset=UTF-8");

        List<Reservation> reservationByUserId = dao.getReservationListByUserId(Integer.parseInt(id));

        req.setAttribute("reservationByUserId", reservationByUserId);

        req.getRequestDispatcher("/admin/deleteReservation.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id =req.getParameter("id");

        dao.deleteReservation(Integer.parseInt(id));

        req.getRequestDispatcher("/admin/admin.jsp").forward(req,resp);
    }
}
