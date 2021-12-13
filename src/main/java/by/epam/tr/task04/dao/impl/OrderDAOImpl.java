package by.epam.tr.task04.dao.impl;

import by.epam.tr.task04.dao.DAOException;
import by.epam.tr.task04.dao.OrderDAO;
import by.epam.tr.task04.entity.Order;
import by.epam.tr.task04.entity.OrderStatus;

import java.util.List;

public class OrderDAOImpl implements OrderDAO {


    @Override
    public int addOrder(Order order) throws DAOException {
        return 0;
    }

    @Override
    public int deleteOrder(Order order) throws DAOException {
        return 0;
    }

    @Override
    public int updateOrderStatusByOrderId(Integer id, OrderStatus orderStatus) throws DAOException {
        return 0;
    }

    @Override
    public int addRejectedOrder(OrderStatus orderStatus) {
        return 0;
    }

    @Override
    public int addComfirmedOrder(OrderStatus orderStatus) {
        return 0;
    }

    @Override
    public List<Order> allComfirmedOrders() throws DAOException {
        return null;
    }

    @Override
    public List<Order> allRejectedOrders() throws DAOException {
        return null;
    }

    @Override
    public List<Order> allOrders() throws DAOException {
        return null;
    }
}
