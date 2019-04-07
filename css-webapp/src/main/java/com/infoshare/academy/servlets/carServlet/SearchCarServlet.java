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

@WebServlet("/searchCar")
public class SearchCarServlet extends HttpServlet {

    @EJB
    CarsRepositoryDao dao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String make = req.getParameter("make");
        String model = req.getParameter("model");
        String fuel = req.getParameter("fuel");
        Integer currentPage = Integer.valueOf(req.getParameter("currentPage"));

        List<Car> carsList = dao.search(make, model, fuel, currentPage, pageSize());

        req.setAttribute("make", make);
        req.setAttribute("model", model);
        req.setAttribute("fuel", fuel);
        req.setAttribute("carsList", carsList);
        req.setAttribute("noOfPages", noOfPages(make,model,fuel));
        req.setAttribute("currentPage", currentPage);

        if (carsList.isEmpty()) {
            req.setAttribute("error", errorNoSearchResults());
        }

        req.getRequestDispatcher("searchcar.jsp").forward(req, resp);
    }

    public int pageSize() {
        int pageSize = 3;
        return pageSize;
    }
    public Integer noOfPages(String make,String model, String fuel){
        int rows = dao.searchCount(make, model, fuel);
        int noOfPage = rows / pageSize();
        if (rows % pageSize() > 0) {
            noOfPage++;
        }
        return noOfPage;
    }
}

