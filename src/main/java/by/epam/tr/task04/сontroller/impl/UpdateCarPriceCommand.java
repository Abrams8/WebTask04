package by.epam.tr.task04.сontroller.impl;

import by.epam.tr.task04.service.CarService;
import by.epam.tr.task04.service.ServiceFactory;
import by.epam.tr.task04.service.UserService;
import by.epam.tr.task04.service.exception.ServiceException;
import by.epam.tr.task04.сontroller.Command;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateCarPriceCommand implements Command {

    private final Logger log = LogManager.getLogger(SaveAccauntChangesCommand.class);
    private final CarService carService = ServiceFactory.getInstance().getCarService();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        double price = Double.parseDouble(request.getParameter("price"));
        int carId = Integer.parseInt(request.getParameter("carId"));

        try {
            carService.updateCarPrice(carId, price);

            String successMessage = "Price was updated!!";
            request.setAttribute("successMessage", successMessage);

            RequestDispatcher dispatcher = request.getRequestDispatcher("MyController?command=GET_ALL_CARS");
            dispatcher.forward(request, response);

        }catch (ServiceException e) {
            String errorMessageChangePrice = "Smth is not valid! Try again!";
            log.error(errorMessageChangePrice);
            request.setAttribute("errorMessageChangePrice", errorMessageChangePrice);
            RequestDispatcher dispatcher = request.getRequestDispatcher("MyController?command=GET_ALL_CARS");
            dispatcher.forward(request, response);
        }
    }
}
