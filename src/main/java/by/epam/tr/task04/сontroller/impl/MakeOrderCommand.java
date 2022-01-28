package by.epam.tr.task04.сontroller.impl;

import by.epam.tr.task04.entity.Order;
import by.epam.tr.task04.service.CarService;
import by.epam.tr.task04.service.OrderService;
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
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class MakeOrderCommand  implements Command {

    private final Logger log = LogManager.getLogger(RegistrationCommand.class);
    private final OrderService orderService = ServiceFactory.getInstance().getOrderService();
    private final CarService carService = ServiceFactory.getInstance().getCarService();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int carId = Integer.parseInt(request.getParameter("carId"));
        LocalDate startDate = LocalDate.parse(request.getParameter("startDate"));
        LocalDate endDate = LocalDate.parse(request.getParameter("endDate"));
        int userId = Integer.parseInt(request.getParameter("userId"));


        Order order = new Order();
        order.setCarId(carId);
        order.setUserId(userId);
        order.setEndDate(endDate);
        order.setStartDate(startDate);


        try {
            orderService.addOrder(order);
            carService.addCarToBusy(order.getCarId(), order.getStartDate(), order.getEndDate());
            String successBookMessage = "Booked successfully!";
            request.setAttribute("successBookMessage", successBookMessage);
            RequestDispatcher dispatcher = request.getRequestDispatcher("MyController?command=GO_TO_FREE_CARS_PAGE");
            dispatcher.forward(request, response);
        } catch (ServiceException e) {
            log.error(e);
        }
    }
}
