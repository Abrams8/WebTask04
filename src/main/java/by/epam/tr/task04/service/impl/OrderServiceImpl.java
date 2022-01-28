package by.epam.tr.task04.service.impl;

import by.epam.tr.task04.dao.DAOException;
import by.epam.tr.task04.dao.DAOFactory;
import by.epam.tr.task04.dao.OrderDAO;
import by.epam.tr.task04.dao.UserDAO;
import by.epam.tr.task04.entity.Order;
import by.epam.tr.task04.service.OrderService;
import by.epam.tr.task04.service.exception.ServiceException;

import java.util.ArrayList;
import java.util.List;

public class OrderServiceImpl implements OrderService {

    private final OrderDAO orderDAO = DAOFactory.getInstance().getOrderDAO();

    @Override
    public void addOrder(Order order) throws ServiceException {
        try {
            orderDAO.addOrder(order);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }

    }

    @Override
    public List<Order> getMyOrders(int userId) throws ServiceException {

        try {
           return orderDAO.getMyOrders(userId);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public int getMaxOrderId() throws ServiceException {
        try {
            return orderDAO.getMaxOrderId();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void deleteOrder(int orderId) throws ServiceException {
        try {
             orderDAO.deleteOrder(orderId);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void addPayedOrder(int orderId) throws ServiceException {
        try {
            orderDAO.addPayedOrder(orderId);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Order> getAllComfirmedOrders() throws ServiceException {
        try {
            return orderDAO.getAllComfirmedOrders();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void addComfirmedOrder(int orderId) throws ServiceException {
        try {
            orderDAO.addComfirmedOrder(orderId);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Order> getAllUncomfirmedOrders() throws ServiceException {
        try {
            return orderDAO.getAllUncomfirmedOrders();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Order> getAllClosedOrders() throws ServiceException {
        try {
            return orderDAO.getAllClosedOrders();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
