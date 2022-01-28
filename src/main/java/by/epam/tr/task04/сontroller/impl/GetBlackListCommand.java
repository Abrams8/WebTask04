package by.epam.tr.task04.сontroller.impl;

import by.epam.tr.task04.entity.User;
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
import java.util.List;

public class GetBlackListCommand implements Command {

    private static final Logger log = LogManager.getLogger(GoToFreeCarsPageCommand.class);
    private final UserService userService = ServiceFactory.getInstance().getUserService();
    private final static String goToBlackListPage = "/WEB-INF/jsp/adminUsers.jsp";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<User> blackList = userService.getAllUsersInBlackList();
            request.setAttribute("blackList", blackList);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(goToBlackListPage);
            requestDispatcher.forward(request, response);
        } catch (ServiceException e) {
            log.error(e);
        }
    }
}