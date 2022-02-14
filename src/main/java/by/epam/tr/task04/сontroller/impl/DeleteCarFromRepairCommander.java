package by.epam.tr.task04.сontroller.impl;

import by.epam.tr.task04.service.CarService;
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

public class DeleteCarFromRepairCommander implements Command {

    private static final Logger log = LogManager.getLogger(DeleteCarFromRepairCommander.class);
    private final CarService carService = ServiceFactory.getInstance().getCarService();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int carId = Integer.parseInt(request.getParameter("carId"));

        try {
            carService.deleteCarFromRepair(carId);

            String successMessage = "Success!!";
            request.setAttribute("successMessage", successMessage);

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("MyController?command=GET_CARS_IN_REPAIR");
            requestDispatcher.forward(request, response);
        } catch (ServiceException e) {
            log.error(e);
            response.sendRedirect("/WEB-INF/jsp/errorPage.jsp");
        }
    }
}