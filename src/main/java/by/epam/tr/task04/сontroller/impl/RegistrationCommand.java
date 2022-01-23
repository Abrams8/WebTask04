package by.epam.tr.task04.сontroller.impl;

import by.epam.tr.task04.entity.Role;
import by.epam.tr.task04.entity.User;
import by.epam.tr.task04.service.ServiceFactory;
import by.epam.tr.task04.service.UserService;
import by.epam.tr.task04.service.exception.ServiceException;
import by.epam.tr.task04.service.validator.UserValidator;
import by.epam.tr.task04.сontroller.Command;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mindrot.jbcrypt.BCrypt;

public class RegistrationCommand implements Command {

    private final Logger log = LogManager.getLogger(RegistrationCommand.class);
    private final UserService userService = ServiceFactory.getInstance().getUserService();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String login = request.getParameter("login");
        String passportNumber = request.getParameter("passportNumber");
        String age = request.getParameter("age");
        String mail = request.getParameter("mail");
        String phoneNumber = request.getParameter("phoneNumber");
        String password = request.getParameter("password");

        UserValidator userValidator = new UserValidator();
        if (userValidator.registrationUserValidator(login, password, name, surname, phoneNumber, mail, passportNumber, age)) {
            User user = new User();

            user.setName(name);
            user.setSurname(surname);
            user.setLogin(login);
            user.setPasportNumber(passportNumber);
            user.setAge(Integer.parseInt(age));
            user.setPhoneNumber(phoneNumber);
            user.setPassword(BCrypt.hashpw(password, BCrypt.gensalt()));
            user.setRole(Role.Client);
            user.setMail(mail);

            try {
                userService.addUser(user);
                HttpSession session = request.getSession();
                session.setAttribute("login", user.getLogin());
                session.setAttribute("role", Role.getRoleById(user.getRole().getRoleId()).toString());
                response.sendRedirect("MyController?command=GO_TO_MAIN_PAGE");
            } catch (ServiceException e){
                log.error(e);
            }
        } else {
            log.info("Registration failed, smth is not valid!");
            String errorMessage = "Registration failed, smth is not valid! Try again!";
            request.setAttribute("errorMessage", errorMessage);
            // response.sendRedirect("MyController?command=GO_TO_REGISTRATION_PAGE");

            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Registration.jsp");
            dispatcher.forward(request, response);
        }

        }
    }
