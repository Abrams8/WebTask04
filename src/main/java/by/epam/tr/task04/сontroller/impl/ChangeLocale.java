package by.epam.tr.task04.сontroller.impl;

import by.epam.tr.task04.сontroller.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ChangeLocale implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String locale = request.getParameter("local");
        request.getSession().setAttribute("local", locale);

        String url = request.getHeader("Referer");
        response.sendRedirect(url);

    }

}
