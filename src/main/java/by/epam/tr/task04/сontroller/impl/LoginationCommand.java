package by.epam.tr.task04.сontroller.impl;

import by.epam.tr.task04.dao.DAOException;
import by.epam.tr.task04.entity.Role;
import by.epam.tr.task04.entity.User;
import by.epam.tr.task04.service.ServiceFactory;
import by.epam.tr.task04.service.UserService;
import by.epam.tr.task04.service.exception.ServiceException;
import by.epam.tr.task04.service.validator.UserValidator;
import by.epam.tr.task04.сontroller.Command;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mindrot.jbcrypt.BCrypt;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginationCommand implements Command {

    private final Logger log = LogManager.getLogger(RegistrationCommand.class);
    private final UserService userService = ServiceFactory.getInstance().getUserService();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, DAOException, ServiceException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        if(userService.logination(login,password)){
            try {
                User user = userService.findUserByLogin(login);

                HttpSession session = request.getSession();
                session.setAttribute("login", user.getLogin());
                session.setAttribute("role", Role.getRoleById(user.getRole().getRoleId()).toString());
                response.sendRedirect("MyController?command=GO_TO_MAIN_PAGE");
            } catch (ServiceException e){
                log.error(e);
            }
        } else {
            request.setAttribute("errorMessage", "Login or password is incorrect.Try again!");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/logination.jsp");
            requestDispatcher.forward(request, response);
        }
    }
}
