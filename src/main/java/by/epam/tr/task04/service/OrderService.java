package by.epam.tr.task04.service;


import by.epam.tr.task04.dao.DAOException;
import by.epam.tr.task04.entity.Order;
import by.epam.tr.task04.service.exception.ServiceException;

import java.time.LocalDate;
import java.util.List;

public interface OrderService {

    void addOrder(Order order) throws ServiceException;

    List<Order> getMyOrders(int userId) throws ServiceException;

    void deleteOrder(int orderId) throws ServiceException;

    void addPayedOrder(int orderId) throws ServiceException;

    List<Order> getAllComfirmedOrders() throws ServiceException;

    void addComfirmedOrder(int orderId) throws ServiceException;

    List<Order> getAllUncomfirmedOrders() throws ServiceException;

    List<Order> getAllClosedOrders() throws ServiceException;

    List<Order> getMyOrdersHistory(int userId) throws ServiceException;

    int getMaxOrderId() throws ServiceException;
}
