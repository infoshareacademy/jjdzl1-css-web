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

        PrintWriter writer = resp.getWriter();

        resp.setContentType("text/html;charset=UTF-8");

        List<Reservation> reservationListByUserId =dao.getReservationListByUserId(Integer.parseInt(id));

        req.setAttribute("reservationListByUserId", reservationListByUserId);

        req.getRequestDispatcher("/admin/getReservationListByUserId.jsp").forward(req,resp);
    }
}
