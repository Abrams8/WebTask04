package by.epam.tr.task04.сontroller.impl;

import by.epam.tr.task04.entity.Car;
import by.epam.tr.task04.entity.Order;
import by.epam.tr.task04.service.CarService;
import by.epam.tr.task04.service.OrderService;
import by.epam.tr.task04.service.ServiceFactory;
import by.epam.tr.task04.service.exception.ServiceException;
import by.epam.tr.task04.сontroller.Command;
import com.mysql.cj.Session;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class GoToMyOrdersPageCommand implements Command {

    private static final Logger log = LogManager.getLogger(GoToMyOrdersPageCommand.class);
    private final static String myOrdersPage = "/WEB-INF/jsp/myOrdersPage.jsp";
    private final OrderService orderService = ServiceFactory.getInstance().getOrderService();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            HttpSession session = request.getSession();
            int userId = (int) session.getAttribute("userId");

            List<Order> myOrders = orderService.getMyOrders(userId);

            request.setAttribute("myOrders", myOrders);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(myOrdersPage);
            requestDispatcher.forward(request, response);
        } catch (ServiceException e) {
            log.error(e);
            response.sendRedirect("/WEB-INF/jsp/errorPage.jsp");
        }
    }
}
