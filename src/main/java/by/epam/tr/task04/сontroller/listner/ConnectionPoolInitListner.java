package by.epam.tr.task04.сontroller.listner;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import by.epam.tr.task04.dao.ConnectionPool.ConnectionPool;
import by.epam.tr.task04.dao.ConnectionPool.ConnectionPoolException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConnectionPoolInitListner implements ServletContextListener {
    private final Logger log = LogManager.getLogger(ConnectionPoolInitListner.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            ConnectionPool.getInstance().initPoolData();
        } catch (ConnectionPoolException e) {
            log.error(e);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ConnectionPool.getInstance().dispose();
    }
}