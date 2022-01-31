package by.epam.tr.task04.сontroller.impl;

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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class DeleteOrderCommand implements Command {

    private static final Logger log = LogManager.getLogger(DeleteOrderCommand.class);
    private final OrderService orderService = ServiceFactory.getInstance().getOrderService();
    private final CarService carService = ServiceFactory.getInstance().getCarService();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int orderId = Integer.parseInt(request.getParameter("orderId"));
        int carId = Integer.parseInt(request.getParameter("carId"));

        try {
            orderService.deleteOrder(orderId);
            carService.deleteCarFromBusy(carId);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("MyController?command=GO_TO_MY_ORDERS_PAGE");
            requestDispatcher.forward(request, response);
        } catch (ServiceException e) {
            log.error(e);
            response.sendRedirect("/WEB-INF/jsp/errorPage.jsp");
        }
    }
}

