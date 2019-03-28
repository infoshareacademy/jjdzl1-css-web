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

import static com.infoshare.academy.utils.CarMessages.errorNoSearchResults;

@WebServlet("/admin/carPanel")
public class CarPanel extends HttpServlet {


    @EJB
    CarsRepositoryDao dao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String make = req.getParameter("make");
        String model = req.getParameter("model");
        String fuel = req.getParameter("fuel");
        Integer currentPage = Integer.valueOf(req.getParameter("currentPage"));

        int pageSize = 1;
        int noOfPage= dao.searchCount(make, model, fuel);

        List<Car> carsList = dao.search(make, model, fuel, currentPage, pageSize);

        req.setAttribute("make", make);
        req.setAttribute("model", model);
        req.setAttribute("fuel", fuel);
        req.setAttribute("carsList", carsList);
        req.setAttribute("noOfPages", noOfPage);
        req.setAttribute("currentPage", currentPage);

        if (carsList.isEmpty()) {
            req.setAttribute("error", errorNoSearchResults());
        }

        req.getRequestDispatcher("/admin/carPanel.jsp").forward(req, resp);
    }
}

