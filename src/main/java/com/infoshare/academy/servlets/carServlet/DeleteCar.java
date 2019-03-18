package com.infoshare.academy.servlets.carServlet;

import com.infoshare.academy.dao.CarsRepositoryDao;
import com.infoshare.academy.domain.Car;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.infoshare.academy.utils.CarMessages.errorMessage;
import static com.infoshare.academy.utils.CarMessages.successMessageCarRm;

@WebServlet("/admin/deleteCar")
public class DeleteCar extends HttpServlet {

    @EJB
    CarsRepositoryDao dao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");

        if (id == null || id.isEmpty()) {
            req.setAttribute("error", errorMessage());
        } else {
            Car car = dao.getCar(Integer.valueOf(id));

            if (car == null) {
                req.setAttribute("error", errorMessage());
            } else {
                req.setAttribute("car", car);
            }
        }
        req.getRequestDispatcher("/admin/deleteCar.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        if (id == null || id.isEmpty()) {
            req.setAttribute("error", errorMessage());
        } else {
            Car car = dao.getCar(Integer.valueOf(id));

            if (car == null) {
                req.setAttribute("error", errorMessage());
            } else {
                dao.deleteCar(Integer.valueOf(id));
                req.setAttribute("success", successMessageCarRm());
            }
        }
        req.getRequestDispatcher("/admin/deleteCar.jsp").forward(req, resp);
    }
}

