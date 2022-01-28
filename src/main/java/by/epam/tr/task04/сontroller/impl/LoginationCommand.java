package by.epam.tr.task04.сontroller.impl;

import by.epam.tr.task04.entity.Role;
import by.epam.tr.task04.entity.User;
import by.epam.tr.task04.service.ServiceFactory;
import by.epam.tr.task04.service.UserService;
import by.epam.tr.task04.service.exception.ServiceException;
import by.epam.tr.task04.service.validator.UserValidator;
import by.epam.tr.task04.сontroller.Command;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoginationCommand implements Command {


    private final Logger log = LogManager.getLogger(LoginationCommand.class);
    private final UserService userService = ServiceFactory.getInstance().getUserService();
    private final UserValidator userValidator = new UserValidator();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        if (userValidator.loginationUserValidator(login, password)) {
            try {
                User user = userService.logination(login, password);
                if (user != null) {
                    HttpSession session = request.getSession();
                    session.setAttribute("userId", user.getId());
                    session.setAttribute("login", user.getLogin());
                    session.setAttribute("role", Role.getRoleById(user.getRole().getRoleId()).toString());
                    response.sendRedirect("MyController?command=GO_TO_MAIN_PAGE");
                } else {
                    request.setAttribute("errorMessage", "Login or password is incorrect.Try again!");
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/logination.jsp");
                    requestDispatcher.forward(request, response);
                }
            } catch (ServiceException e) {
                log.error(e);
                request.setAttribute("errorMessage", "Login or password is incorrect.Try again!");
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/logination.jsp");
                requestDispatcher.forward(request, response);
            }
        } else {
            request.setAttribute("errorMessage", "Login or password is incorrect.Try again!");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/logination.jsp");
            requestDispatcher.forward(request, response);
        }
    }
}
