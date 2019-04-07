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

        String page = req.getParameter("currentPage");
        String login = req.getParameter("login");
        String name = req.getParameter("name");

        List<Reservation> reservationList = dao.listLimit(login, name, currentPage(page));

        if (reservationList == null || reservationList.isEmpty()) {
            req.setAttribute("error", errorEmptyListReservation());

        } else {
            req.setAttribute("noOfPages", noOfPages(login, name));
            req.setAttribute("currentPage", currentPage(page));
            req.setAttribute("login", login);
            req.setAttribute("name", name);
            req.setAttribute("reservationList", reservationList);
        }
        req.getRequestDispatcher("/admin/listReservation.jsp").forward(req, resp);
    }

    public Integer noOfPages(String login, String name) {
        int rows = dao.listCount(login, name);
        int noOfPages = rows / 3;
        if (rows % 3 > 0) {
            noOfPages++;
        }
        return noOfPages;
    }

    public int currentPage(String page) {
        return Integer.valueOf(page);
    }
}

