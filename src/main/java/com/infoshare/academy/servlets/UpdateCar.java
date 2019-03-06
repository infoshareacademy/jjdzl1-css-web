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
import java.io.PrintWriter;

@WebServlet("/admin/updateCar")
public class UpdateCar extends HttpServlet {

    @EJB
    CarsRepositoryDao dao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        PrintWriter writer = resp.getWriter();
        resp.setContentType("text/html;charset=UTF-8");

        if (id == null || id.isEmpty()) {
            req.setAttribute("error", HttpServletResponse.SC_BAD_REQUEST);
            req.getRequestDispatcher("/admin/updateCarMileage.jsp").forward(req, resp);
            return;
        }
        Car car = dao.getCar(Integer.valueOf(id));

        if (car == null) {
            req.setAttribute("error", HttpServletResponse.SC_NOT_FOUND);
            req.getRequestDispatcher("/admin/updateCarMileage.jsp").forward(req, resp);
            return;
        }

        req.setAttribute("id", car.getId());
        req.setAttribute("mileage", car.getMileage());
        req.getRequestDispatcher("/admin/updateCarMileage.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        String mileage = req.getParameter("mileage");

        dao.updateCarMileage(Integer.parseInt(id), Integer.parseInt(mileage));

        req.getRequestDispatcher("/admin/admin.jsp").forward(req, resp);

    }

}
