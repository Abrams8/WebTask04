package by.epam.tr.task04.сontroller.impl;

import by.epam.tr.task04.сontroller.Command;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class GoToIndexPageCommand implements Command {

    private final static String goToMainPage = "/WEB-INF/jsp/MainPage.jsp";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(true);

        session.setAttribute("url", "http://localhost:8080/Task04_war_exploded/MyController?command=GO_TO_INDEX_PAGE");

        RequestDispatcher requestDispatcher = request.getRequestDispatcher(goToMainPage);
        requestDispatcher.forward(request, response);
    }
}
