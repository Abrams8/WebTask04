package by.epam.tr.task04.dao;

import by.epam.tr.task04.dao.impl.CarDAOImpl;
import by.epam.tr.task04.dao.impl.OrderDAOImpl;
import by.epam.tr.task04.dao.impl.UserDAOImpl;

public final class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();

    private final UserDAO userDAO = new UserDAOImpl();
    private final OrderDAO orderDAO = new OrderDAOImpl();
    private final CarDAO carDAO = new CarDAOImpl();

    private DAOFactory() {
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public CarDAO getCarDAO() {
        return carDAO;
    }

    public OrderDAO getOrderDAO() {
        return orderDAO;
    }

    public static DAOFactory getInstance() {
        return instance;
    }
}
