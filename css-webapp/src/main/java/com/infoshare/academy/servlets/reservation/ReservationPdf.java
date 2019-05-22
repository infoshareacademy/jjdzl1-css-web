package com.infoshare.academy.servlets.reservation;

import com.infoshare.academy.dao.CarsRepositoryDao;
import com.infoshare.academy.dao.ReservationRepositoryDao;
import com.infoshare.academy.dao.UsersRepositoryDao;
import com.infoshare.academy.domain.Car;
import com.infoshare.academy.domain.Reservation;
import com.infoshare.academy.domain.User;
import com.lowagie.text.DocumentException;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.w3c.tidy.Tidy;
import org.xhtmlrenderer.pdf.ITextRenderer;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.MalformedURLException;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import static com.itextpdf.text.pdf.BaseFont.EMBEDDED;
import static com.itextpdf.text.pdf.BaseFont.IDENTITY_H;
import static com.lowagie.text.html.HtmlTags.HTML;

@WebServlet("reservationPdf")
public class ReservationPdf extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(ReservationPdf.class.getName());


    @EJB
    CarsRepositoryDao daoCar;

    @EJB
    UsersRepositoryDao daoUser;

    @EJB
    ReservationRepositoryDao daoReservation;

    private static final String UTF_8 = "UTF-8";
    private static final String OUTPUT_FILE = "test.pdf";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        String userId = req.getParameter("userId");
        String carId = req.getParameter("carId");
        String startDate = req.getParameter("startDate");
        String endDate = req.getParameter("endDate");
        String reservationId = req.getParameter("reservationId");
        String period = req.getParameter("period");
        String price = req.getParameter("price");
        String cost = req.getParameter("cost");
        LocalDate dateNow = LocalDate.now();

        String now = dateNow.format(formatter);

        Car car = daoCar.getCar(Integer.parseInt(carId));
        User user = daoUser.getUserById(Integer.parseInt(userId));
        Reservation reservation = daoReservation.getReservationById(Integer.parseInt(reservationId));

        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setPrefix("/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode(HTML);
        templateResolver.setCharacterEncoding(UTF_8);


        TemplateEngine templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);

        Context context = new Context();
        Map<String, Object> variable = new HashMap<>();
        variable.put("car", car);
        variable.put("user", user);
        variable.put("reservation", reservation);
        variable.put("period", period);
        variable.put("price", price);
        variable.put("cost", cost);
        variable.put("now", now);
        variable.put("start", startDate);
        variable.put("end", endDate);
        context.setVariables(variable);

        String html = templateEngine.process("template", context);

        String xHtml = convertToXhtml(html);

        try {
            ITextRenderer renderer = new ITextRenderer();

            renderer.getFontResolver().addFont("Code39.ttf", IDENTITY_H, EMBEDDED);

            try {
                String baseUrl = Paths
                        .get("pdf/")
                        .toAbsolutePath()
                        .toUri()
                        .toURL()
                        .toString();
   //TODO
// absolutePath() powinno zwrócić "file:/home/dario/IdeaProjects/jjdzl1-css-web/css-webapp/src/main/resources/"
//       stworzyłem folder pdf w bin  i tam skopiowałem pliki z resources do
//       "file:/home/dario/wildfly-15.0.1.Final/bin/pdf/"

                renderer.setDocumentFromString(xHtml, baseUrl);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

            renderer.layout();
            resp.setContentType("application/pdf");
            resp.setHeader("Content-Disposition", "attachment;filename=reservation.pdf");
            OutputStream outputStream = new FileOutputStream(OUTPUT_FILE);
            renderer.createPDF(resp.getOutputStream());
            outputStream.close();

            LOGGER.info("Reservation.pdf download.");

        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    public LocalDate start(String start) {
        return LocalDate.parse(start);
    }

    public LocalDate end(String end) {
        return LocalDate.parse(end);
    }

    private String convertToXhtml(String html) throws UnsupportedEncodingException {
        Tidy tidy = new Tidy();
        tidy.setInputEncoding(UTF_8);
        tidy.setOutputEncoding(UTF_8);
        tidy.setXHTML(true);
        ByteArrayInputStream inputStream = new ByteArrayInputStream(html.getBytes(UTF_8));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        tidy.parseDOM(inputStream, outputStream);
        return outputStream.toString(UTF_8);
    }
}
