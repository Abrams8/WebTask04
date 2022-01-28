package by.epam.tr.task04.dao;

import by.epam.tr.task04.entity.*;

import java.sql.SQLException;
import java.util.List;

public interface OrderDAO {

    int getMaxOrderId() throws DAOException;
    void addOrder(Order order) throws DAOException;
    List<Order> getMyOrders(int userId) throws DAOException;

    void deleteOrder(int orderId) throws DAOException;

    void addRejectedOrder (Order order, String rejectionReason) throws DAOException;
    void addComfirmedOrder (int orderId) throws DAOException;
    void addPayedOrder (int orderId) throws DAOException;

    List<Order> getAllComfirmedOrders () throws DAOException;
    List<Order> getAllRejectedOrders () throws DAOException;
    List<Order> getAllOrders () throws DAOException;
    List<Order> getAllUncomfirmedOrders() throws DAOException;
    List<Order> getAllClosedOrders() throws DAOException;

}
