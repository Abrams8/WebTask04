package by.epam.tr.task04.сontroller;

import by.epam.tr.task04.service.exception.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface Command {

    public void execute (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ServiceException;
}
