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
        resp.setContentType("text/html;charset=UtF-8");

        Car car = dao.getCar(Integer.valueOf(id));

        req.setAttribute("id", car.getId());
        req.setAttribute("make", car.getMake());
        req.setAttribute("model", car.getModel());
        req.setAttribute("year", car.getYear());
        req.getRequestDispatcher("/admin/deleteCar.jsp").forward(req, resp);

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");

        dao.deleteCar(Integer.parseInt(id));

        req.getRequestDispatcher("/admin/admin.jsp").forward(req,resp);
    }

}
