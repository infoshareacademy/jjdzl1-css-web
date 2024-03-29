package com.infoshare.academy.servlets.car;


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

@WebServlet("/admin/cars")
public class CarListServlet extends HttpServlet {

    @EJB
    CarsRepositoryDao dao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String page = req.getParameter("currentPage");

        List<Car> carList = dao.list(currentPage(page), pageSize());

        if (carList == null || carList.isEmpty()) {
            req.setAttribute("error", errorEmptyList());
        } else {
            req.setAttribute("currentPage", currentPage(page));
            req.setAttribute("noOfPages", noOfPages());
            req.setAttribute("carList", carList);
        }
        req.getRequestDispatcher("/admin/cars.jsp").forward(req, resp);
    }

    public int pageSize() {
        int pageSize = 3;
        return pageSize;
    }

    public Integer noOfPages() {
        int rows = dao.listCount();
        int noOfPages = rows / pageSize();
        if (rows % pageSize() > 0) {
            noOfPages++;
        }
        return noOfPages;
    }

    public Integer currentPage(String page) {
        if (page == null) {
            page = "1";
        }
        Integer currentPage = Integer.parseInt(page);
        return currentPage;
    }
}
