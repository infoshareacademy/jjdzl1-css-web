package com.infoshare.academy.servlets;

import com.infoshare.academy.dao.CarsRepositoryDao;
import com.infoshare.academy.domain.Car;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/deleteCar")
public class DeleteCar extends HttpServlet {

    @EJB
    CarsRepositoryDao dao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");

        if (id.isEmpty()) {
            req.setAttribute("error", errorMessage());
        }

        Car car = dao.getCar(Integer.valueOf(id));

        if (car != null) {
            req.setAttribute("id", car.getId());
            req.setAttribute("make", car.getMake());
            req.setAttribute("model", car.getModel());
            req.setAttribute("year", car.getYear());

        } else {
            req.setAttribute("error", errorMessage());
        }

        req.getRequestDispatcher("/admin/deleteCar.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        if (id.isEmpty()) {
            req.setAttribute("error", errorMessage());

        }
        Car car = dao.getCar(Integer.parseInt(id));

        if (car != null) {
            dao.deleteCar(Integer.parseInt(id));
        } else {
            req.setAttribute("error", errorMessage());

        }
        req.getRequestDispatcher("/admin/deleteCar.jsp").forward(req, resp);
    }

    public static String errorMessage() {
        String html1 = "<div class=\"alert alert-danger\" role=\"alert\">";
        String html2 = "</div>";
        String errorData = " Id car incorrect! Please try again.";
        return html1 + errorData + html2;
    }
}

