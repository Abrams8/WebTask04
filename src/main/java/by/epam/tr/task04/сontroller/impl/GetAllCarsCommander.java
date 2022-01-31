package by.epam.tr.task04.сontroller.impl;

import by.epam.tr.task04.entity.Car;
import by.epam.tr.task04.entity.Order;
import by.epam.tr.task04.service.CarService;
import by.epam.tr.task04.service.OrderService;
import by.epam.tr.task04.service.ServiceFactory;
import by.epam.tr.task04.service.exception.ServiceException;
import by.epam.tr.task04.сontroller.Command;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GetAllCarsCommander implements Command {
    private static final Logger log = LogManager.getLogger(GetAllCarsCommander.class);
    private final CarService carService = ServiceFactory.getInstance().getCarService();
    private final static String goToAdminCarsPage = "/WEB-INF/jsp/adminCars.jsp";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Car> allCars = carService.getAllCars();
            request.setAttribute("allCars", allCars);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(goToAdminCarsPage);
            requestDispatcher.forward(request, response);
        } catch (ServiceException e) {
            log.error(e);
            response.sendRedirect("/WEB-INF/jsp/errorPage.jsp");
        }
    }
}