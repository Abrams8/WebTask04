package by.epam.tr.task04.dao;

import by.epam.tr.task04.entity.*;

import java.util.List;

public interface OrderDAO {

    int addOrder(Order order) throws DAOException;
    int deleteOrder(Order order) throws DAOException;
    int updateOrderStatusByOrderId(Integer id,  OrderStatus orderStatus) throws DAOException;

    int addRejectedOrder (OrderStatus orderStatus);
    int addComfirmedOrder (OrderStatus orderStatus);

    List<Order> allComfirmedOrders () throws DAOException;
    List<Order> allRejectedOrders () throws DAOException;
    List<Order> allOrders () throws DAOException;


}
