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
import java.util.ArrayList;
import java.util.List;

import static com.infoshare.academy.utils.CarMessages.errorEmptyList;

@WebServlet("/carlist")
public class ListExampleCar extends HttpServlet {

    @EJB
    CarsRepositoryDao dao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Car> carList = dao.listCar();

        if (carList == null || carList.isEmpty()) {
            req.setAttribute("error", errorEmptyList());
        } else {
            List<Car> carExampleList = new ArrayList<>();
            for (int i =0; i < 8; i++) {
                carExampleList.add(carList.get(i));
            }
            req.setAttribute("carExampleList", carExampleList);
        }
        req.getRequestDispatcher("/examplecarlist.jsp").forward(req, resp);
    }


}

