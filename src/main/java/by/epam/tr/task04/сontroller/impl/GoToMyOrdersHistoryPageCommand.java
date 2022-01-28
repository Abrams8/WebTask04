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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class GoToMyOrdersHistoryPageCommand implements Command {

    private static final Logger log = LogManager.getLogger(GoToMyOrdersHistoryPageCommand.class);
    private final static String myOrdersPage = "/WEB-INF/jsp/myOrdersPage.jsp";
    private final OrderService orderService = ServiceFactory.getInstance().getOrderService();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            HttpSession session = request.getSession();
            int userId = (int) session.getAttribute("userId");

            List<Order> myHistoryOrders = orderService.getMyOrdersHistory(userId);

            request.setAttribute("myHistoryOrders", myHistoryOrders);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(myOrdersPage);
            requestDispatcher.forward(request, response);
        } catch (ServiceException e) {
            log.error(e);
        }
    }
}
