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

import static com.infoshare.academy.utils.ReservationMessages.errorEmptyReservationList;

@WebServlet("/listReservationCurrentUser")
public class ListReservationCurrentUser extends HttpServlet {

    @EJB
    ReservationRepositoryDao dao;

    @EJB
    UsersRepositoryDao daoUser;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        String username = (String) session.getAttribute("username");
        String page = req.getParameter("currentPage");

        List<Reservation> reservationByUserId = dao.reservationListByUserIdLimit(getUserId(username), currentPage(page));

        if (reservationByUserId == null || reservationByUserId.isEmpty()) {
            req.setAttribute("error", errorEmptyReservationList());
        } else {
            req.setAttribute("reservationByUserId", reservationByUserId);
            req.setAttribute("noOfPages", noOfPages(getUserId(username)));
            req.setAttribute("currentPage", currentPage(page));
        }
        req.getRequestDispatcher("/listReservationCurrentUser.jsp").forward(req, resp);
    }

    public Integer getUserId(String username) {
        User currentUser = daoUser.getUserByLogin(username);
        Integer id=currentUser.getId();
        return id;
    }

    public int currentPage(String page) {
        if (page == null) {
            page = "1";
        }
        return Integer.valueOf(page);
    }

    public int noOfPages(Integer id) {
        int rows = dao.reservationCount(id);
        int noOfPages = rows / 3;
        if (rows % 3 > 0) {
            noOfPages++;
        }
        return noOfPages;
    }
}
