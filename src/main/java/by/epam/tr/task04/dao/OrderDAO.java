package by.epam.tr.task04.dao;

import by.epam.tr.task04.entity.*;

import java.sql.SQLException;
import java.util.List;

public interface OrderDAO {

    void addOrder(Order order) throws DAOException;
    void deleteOrder(Order order) throws DAOException;
    void updateOrderStatusByOrderId(Order order, OrderStatus orderStatus) throws DAOException;

    void addRejectedOrder (Order order, String rejectionReason) throws DAOException;
    void addComfirmedOrder (Order order) throws DAOException;

    List<Order> getAllComfirmedOrders () throws DAOException;
    List<Order> getAllRejectedOrders () throws DAOException;
    List<Order> getAllOrders () throws DAOException;

}
