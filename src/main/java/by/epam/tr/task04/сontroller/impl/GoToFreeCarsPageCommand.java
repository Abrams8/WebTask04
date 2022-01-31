package by.epam.tr.task04.сontroller.impl;

import by.epam.tr.task04.dao.DAOException;
import by.epam.tr.task04.entity.Car;
import by.epam.tr.task04.entity.User;
import by.epam.tr.task04.service.CarService;
import by.epam.tr.task04.service.ServiceFactory;
import by.epam.tr.task04.service.UserService;
import by.epam.tr.task04.service.exception.ServiceException;
import by.epam.tr.task04.сontroller.Command;
import by.epam.tr.task04.сontroller.CommandProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class GoToFreeCarsPageCommand implements Command {

    private static final Logger log = LogManager.getLogger(GoToFreeCarsPageCommand.class);
    private final static String goToFreeCars = "/WEB-INF/jsp/freeCarsPage.jsp";
    private final CarService carService = ServiceFactory.getInstance().getCarService();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            List<Car> freeCars = carService.getAllFreeCars();
            request.setAttribute("freeCars", freeCars);
            RequestDispatcher dispatcher = request.getRequestDispatcher(goToFreeCars);
            dispatcher.forward(request, response);
        } catch (ServiceException e) {
            log.error(e);
            response.sendRedirect("/WEB-INF/jsp/errorPage.jsp");
        }
    }
}
