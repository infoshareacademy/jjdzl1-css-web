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

import static com.infoshare.academy.utils.CarMessages.*;

@WebServlet("/admin/updateCar")
public class UpdateCar extends HttpServlet {

    @EJB
    CarsRepositoryDao dao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");

        if (id == null || id.isEmpty()) {
            req.setAttribute("error", errorCarIdIncorrect());
        } else {
            Car car = dao.getCar(Integer.parseInt(id));

            if (car != null) {
                req.setAttribute("id", car.getId());
                req.setAttribute("mileage", car.getMileage());
                req.setAttribute("photoLink",car.getPhotoLink());
            } else {
                req.setAttribute("error", errorCarIdIncorrect());
            }
        }
        req.getRequestDispatcher("/admin/updateCarMileage.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        String mileage = req.getParameter("mileage");

        if (id == null || id.isEmpty()) {
            req.setAttribute("error", errorCarIdIncorrect());
        } else if (mileage == null || mileage.isEmpty()) {
            req.setAttribute("error", errorCarMileageIncorrect());

        } else {

            Car car = dao.getCar(Integer.parseInt(id));

            if (car != null) {
                dao.updateCarMileage(Integer.parseInt(id),Integer.parseInt(mileage));
                req.setAttribute("success", successUpdateDone());
            } else {
                req.setAttribute("error", errorUpdateHasFailed());
            }
        }
        req.getRequestDispatcher("/admin/updateCarMileage.jsp").forward(req, resp);
    }
}

