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
import java.util.List;

import static com.infoshare.academy.utils.CarMessages.errorEmptyList;

@WebServlet("/admin/carlist")
public class ListCar extends HttpServlet {

    @EJB
    CarsRepositoryDao dao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Car> carList = dao.list();

        if (carList == null || carList.isEmpty()) {
            req.setAttribute("error", errorEmptyList());
        } else {
            req.setAttribute("carList", carList);
        }
        req.getRequestDispatcher("/admin/carlist.jsp").forward(req, resp);
    }


}

