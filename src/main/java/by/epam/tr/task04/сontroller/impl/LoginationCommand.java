package by.epam.tr.task04.сontroller.impl;

import by.epam.tr.task04.сontroller.Command;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginationCommand implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        boolean flag = false; // если все ок в дао
        if (flag) {
            request.setAttribute("loginationInfo", "Logination OK!");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/MainPage.jsp");
            requestDispatcher.forward(request, response);
        }else{
            request.setAttribute("errorMessage", "Some problems.Try again");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/logination.jsp");
            requestDispatcher.forward(request, response);
        }

    }
}
