package com.infoshare.academy.servlets.carServlet;

import com.infoshare.academy.dao.CarsRepositoryDao;
import com.infoshare.academy.domain.Car;
import com.infoshare.academy.enums.BodyTypeEnum;
import com.infoshare.academy.enums.ColorEnum;
import com.infoshare.academy.enums.FuelSourceEnum;
import com.infoshare.academy.enums.TransmissionEnum;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/addCar")
public class AddCar extends HttpServlet {

    @EJB
    CarsRepositoryDao dao;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String carType = req.getParameter("carType");
        String make = req.getParameter("make");
        String model = req.getParameter("model");
        String year = req.getParameter("year");
        String mileage = req.getParameter("mileage");
        String enginePower = req.getParameter("enginePower");
        String fuelSource = req.getParameter("fuelSource");
        String transmission = req.getParameter("transmission");
        String bodyType = req.getParameter("bodyType");
        String color = req.getParameter("color");
        String seats = req.getParameter("seats");

        Car car = new Car(Integer.parseInt(carType),make,model,Integer.parseInt(year),Integer.parseInt(mileage),
                Integer.parseInt(enginePower), FuelSourceEnum.valueOf(fuelSource),
                TransmissionEnum.valueOf(transmission), BodyTypeEnum.valueOf(bodyType), ColorEnum.valueOf(color),
                Integer.parseInt(seats));

        dao.addCar(car);
        req.getRequestDispatcher("/admin/admin.jsp").forward(req,resp);

    }
}

