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
import org.mindrot.jbcrypt.BCrypt;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SaveAccauntChangesCommand implements Command {

    private final Logger log = LogManager.getLogger(SaveAccauntChangesCommand.class);
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
        String userId = request.getParameter("userId");

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
            user.setId(Integer.parseInt(userId));

            try {
                userService.updateUser(user);
                HttpSession session = request.getSession();
                session.setAttribute("login", user.getLogin());
                session.setAttribute("role", Role.getRoleById(user.getRole().getRoleId()).toString());

                String successMessageChangeAccauntInfo = "Changes saved!!";
                request.setAttribute("successMessageChangeAccauntInfo", successMessageChangeAccauntInfo);

                RequestDispatcher dispatcher = request.getRequestDispatcher("MyController?command=GO_TO_ACCAUNT_INFORMATION_PAGE");
                dispatcher.forward(request, response);
            } catch (ServiceException e) {
                log.error(e);
            }
        } else {
            String errorMessageChangeAccauntInfo = "Changes were not saved, smth is not valid! Try again!";
            log.error(errorMessageChangeAccauntInfo);
            request.setAttribute("errorMessageChangeAccauntInfo", errorMessageChangeAccauntInfo);
            RequestDispatcher dispatcher = request.getRequestDispatcher("MyController?command=GO_TO_ACCAUNT_INFORMATION_PAGE");
            dispatcher.forward(request, response);
        }

    }
}
