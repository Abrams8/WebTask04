package by.epam.tr.task04.сontroller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@WebServlet(name = "Controller", value = "/Controller")
public class Controller extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private final CommandProvider provider = new CommandProvider();

    private static final Logger log = LogManager.getLogger(Controller.class);

    public Controller() {
        super();
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        super.service(req, res);
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        process(request, response);

    }

    protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String commandName = request.getParameter("command");
        Command command = provider.getCommand(commandName);
        command.execute(request, response);

    }


}
