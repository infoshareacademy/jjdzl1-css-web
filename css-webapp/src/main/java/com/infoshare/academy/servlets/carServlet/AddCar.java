package com.infoshare.academy.servlets.carServlet;

import com.infoshare.academy.cdi.FileUploadProcessor;
import com.infoshare.academy.dao.CarsRepositoryDao;
import com.infoshare.academy.domain.Car;
import com.infoshare.academy.enums.BodyTypeEnum;
import com.infoshare.academy.enums.ColorEnum;
import com.infoshare.academy.enums.FuelSourceEnum;
import com.infoshare.academy.enums.TransmissionEnum;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

import static com.infoshare.academy.utils.CarMessages.errorNotImage;
import static com.infoshare.academy.utils.CarMessages.successCarAdded;

@MultipartConfig
@WebServlet("/admin/addCar")
public class AddCar extends HttpServlet {

    @EJB
    CarsRepositoryDao dao;

    @Inject
    FileUploadProcessor fileUploadProcessor;

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
        Part image = req.getPart("image");

        String imagePath = "img/" + image.getSubmittedFileName();

        String uploadedImage = fileUploadProcessor.uploadImageFile(image);
        if (uploadedImage == null) {
            req.setAttribute("error", errorNotImage());
            req.getRequestDispatcher("/admin/addCar.jsp").forward(req, resp);
        }

        Car car = new Car(Integer.parseInt(carType), make, model, Integer.parseInt(year), Integer.parseInt(mileage),
                Integer.parseInt(enginePower), FuelSourceEnum.valueOf(fuelSource),
                TransmissionEnum.valueOf(transmission), BodyTypeEnum.valueOf(bodyType), ColorEnum.valueOf(color),
                Integer.parseInt(seats), imagePath);

        dao.addCar(car);
        req.setAttribute("error", successCarAdded());
        req.getRequestDispatcher("/admin/addCar.jsp").forward(req, resp);

    }
}

