package by.epam.tr.task04.dao;

import by.epam.tr.task04.entity.*;

import java.sql.SQLException;
import java.util.List;

public interface OrderDAO {

    void addOrder(Order order) throws SQLException, DAOException;
    void deleteOrder(Order order) throws SQLException, DAOException;
    void updateOrderStatusByOrderId(Order order, OrderStatus orderStatus) throws DAOException, SQLException;

    void addRejectedOrder (Order order, String rejectionReason) throws DAOException, SQLException;
    void addComfirmedOrder (Order order) throws DAOException, SQLException;

    List<Order> getAllComfirmedOrders () throws DAOException;
    List<Order> getAllRejectedOrders () throws DAOException;
    List<Order> getAllOrders () throws DAOException;

}
