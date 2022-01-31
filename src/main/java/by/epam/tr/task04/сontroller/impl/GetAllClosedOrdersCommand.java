package by.epam.tr.task04.сontroller.impl;

import by.epam.tr.task04.entity.Order;
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

public class GetAllClosedOrdersCommand implements Command {

    private static final Logger log = LogManager.getLogger(GetAllClosedOrdersCommand.class);
    private final OrderService orderService = ServiceFactory.getInstance().getOrderService();
    private final static String goToAdminOrdersPage = "/WEB-INF/jsp/adminOrders.jsp";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Order> allClosedOrders = orderService.getAllClosedOrders();
            request.setAttribute("allClosedOrders", allClosedOrders);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(goToAdminOrdersPage);
            requestDispatcher.forward(request, response);
        } catch (ServiceException e) {
            log.error(e);
            response.sendRedirect("/WEB-INF/jsp/errorPage.jsp");
        }
    }
}