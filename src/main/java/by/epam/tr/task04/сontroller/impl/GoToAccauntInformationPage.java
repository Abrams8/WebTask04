package by.epam.tr.task04.сontroller.impl;

import by.epam.tr.task04.dao.DAOException;
import by.epam.tr.task04.entity.User;
import by.epam.tr.task04.service.ServiceFactory;
import by.epam.tr.task04.service.exception.ServiceException;
import by.epam.tr.task04.сontroller.Command;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

import by.epam.tr.task04.сontroller.Controller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GoToAccauntInformationPage implements Command {

    private static final Logger log = LogManager.getLogger(GoToAccauntInformationPage.class);

    private final static String goToAccauntInformationPage = "WEB-INF/jsp/accauntInformationPage.jsp";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        if (session.getAttribute("login") != null) {
            try {
                User user = ServiceFactory.getInstance().getUserService().findUserByLogin((String) session.getAttribute("login"));
                request.setAttribute("user", user);
                RequestDispatcher dispatcher = request.getRequestDispatcher(goToAccauntInformationPage);
                dispatcher.forward(request, response);
            } catch (ServiceException e) {
                log.error(e);
            }
        }

    }
}
