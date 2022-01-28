package by.epam.tr.task04.сontroller.impl;

import by.epam.tr.task04.сontroller.Command;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LogOutCommand implements Command {

    private final static String goToMainPage = "/WEB-INF/jsp/MainPage.jsp";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.removeAttribute("login");
        session.removeAttribute("role");
        RequestDispatcher dispatcher = request.getRequestDispatcher(goToMainPage);
        dispatcher.forward(request, response);


    }

}