package by.epam.tr.task04.сontroller.impl;

import by.epam.tr.task04.dao.DAOException;
import by.epam.tr.task04.entity.Car;
import by.epam.tr.task04.service.ServiceFactory;
import by.epam.tr.task04.service.exception.ServiceException;
import by.epam.tr.task04.сontroller.Command;
import by.epam.tr.task04.сontroller.CommandProvider;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class GoToFreeCarsPageCommand implements Command {

    private final static String goToFreeCars = "/WEB-INF/jsp/freeCarsPage.jsp";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ServiceException, DAOException {

        List<Car> freeCars = ServiceFactory.getInstance().getCarService().getAllFreeCars();
        for (int i = 0; i<freeCars.size(); i++){
            Car car = new Car();
        }

        HttpSession session = request.getSession();
        String login = (String) session.getAttribute("login");
        if(login!=null) {
            RequestDispatcher dispatcher = request.getRequestDispatcher(goToFreeCars);
            dispatcher.forward(request, response);
        }else {
            CommandProvider commandProvider  = new CommandProvider();
            commandProvider.getCommand("GO_TO_LOGINATION_PAGE").execute(request, response);
        }
    }

}
