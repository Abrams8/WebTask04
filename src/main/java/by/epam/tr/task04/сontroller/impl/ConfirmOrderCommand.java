package by.epam.tr.task04.сontroller.impl;

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

public class ConfirmOrderCommand implements Command {

    private static final Logger log = LogManager.getLogger(GoToFreeCarsPageCommand.class);
    private final OrderService orderService = ServiceFactory.getInstance().getOrderService();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int orderId = Integer.parseInt(request.getParameter("orderId"));

        try {
            orderService.addComfirmedOrder(orderId);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("MyController?command=GET_ALL_UNCONFIRMED_ORDERS");
            requestDispatcher.forward(request, response);
        } catch (ServiceException e) {
            log.error(e);
        }
    }
}