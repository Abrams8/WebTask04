package by.epam.tr.task04.dao.impl;

import by.epam.tr.task04.dao.ConnectionPool.ConnectionPool;
import by.epam.tr.task04.dao.ConnectionPool.ConnectionPoolException;
import by.epam.tr.task04.dao.DAOException;
import by.epam.tr.task04.dao.OrderDAO;
import by.epam.tr.task04.entity.Order;
import by.epam.tr.task04.entity.OrderStatus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class OrderDAOImpl implements OrderDAO {

    private static final ConnectionPool connectionPool = ConnectionPool.getInstance();

    private final static String ADD_ORDER = "INSERT INTO Orders(order_id, start_date, end_date, status, user_id, car_id) VALUES (?, ?, ?, ?, ?, ?);";
    private final static String DELETE_ORDER = "DELETE FROM Orders WHERE order_id=?;";
    private final static String UPDATE_ORDER = "UPDATE Order_status SET is_confirmed=?, rejection_reason=? WHERE id=?;";

    private final static String ADD_REJECTED_ORDER = "UPDATE Order_status SET is_confirmed='false', rejection_reason=? WHERE id=?;";
    private final static String ADD_COMFIRMED_ORDER = "UPDATE Order_status SET is_confirmed='true' WHERE id=?;";

    private final static String GET_ALL_ORDERS = "SELECT * FROM Orders";
    private final static String GET_ALL_REJECTED_ORDERS = "";
    private final static String GET_ALL_COMFIRMED_ORDERS = "";



    @Override
    public void addOrder(Order order) throws DAOException, SQLException {
        Connection connection = null;
        PreparedStatement preparedStatementAddCar = null;
        PreparedStatement preparedStatementAddCarStatus = null;
        try {
            connection = connectionPool.getConnection();
            connection.setAutoCommit(false);
            preparedStatementAddCar = connection.prepareStatement(ADD_ORDER);
            preparedStatementAddCar.setInt(1, order.getOrderId());
            preparedStatementAddCar.setDate(2, order.getStartDate());
            preparedStatementAddCar.setDate(3, order.getEndDate());
            preparedStatementAddCar.setString(4, order.getStatus());
            preparedStatementAddCar.setInt(5, order.getUserId());
            preparedStatementAddCar.setDouble(6, order.getCarId());
            preparedStatementAddCar.executeUpdate();
            connection.commit();
        } catch (ConnectionPoolException | SQLException e){
            connection.rollback();
            throw new DAOException(e);
        }
        finally {
            try{
                connectionPool.closeConnection(connection,preparedStatementAddCar);
                //  connectionPool.closeConnection(preparedStatementAddCarStatus);
            }
            catch (ConnectionPoolException e){
                throw new DAOException(e);
            }
        }

    }


    @Override
    public void deleteOrder(Order order) throws DAOException, SQLException {
        Connection connection = null;
        PreparedStatement preparedStatementDeleteCar = null;
        PreparedStatement preparedStatementDeleteCarStatus = null;
        try {
            connection = connectionPool.getConnection();
            connection.setAutoCommit(false);
            preparedStatementDeleteCar = connection.prepareStatement(DELETE_ORDER);
            preparedStatementDeleteCar.setInt(1, order.getOrderId());
            preparedStatementDeleteCar.executeUpdate();

            connection.commit();
        } catch (ConnectionPoolException | SQLException e){
            connection.rollback();
            throw new DAOException(e);
        }
        finally {
            try{
                connectionPool.closeConnection(connection,preparedStatementDeleteCar);
                // connectionPool.closeConnection(preparedStatementDeleteCarStatus);
            }
            catch (ConnectionPoolException e){
                throw new DAOException(e);
            }
        }

    }

    @Override
    public void updateOrderStatusByOrderId(Order order, OrderStatus orderStatus) throws DAOException, SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = connectionPool.getConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(UPDATE_ORDER);
            preparedStatement.setBoolean(1, orderStatus.getConfirmed());
            preparedStatement.setString(2, orderStatus.getRejectionReason());
            preparedStatement.setInt(3, order.getCarId());
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (ConnectionPoolException | SQLException e){
            connection.rollback();
            throw new DAOException(e);
        }
        finally {
            try{
                connectionPool.closeConnection(connection,preparedStatement);
            }
            catch (ConnectionPoolException e){
                throw new DAOException(e);
            }
        }

    }

    @Override
    public void addRejectedOrder(Order order, String rejectionReason) throws DAOException, SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = connectionPool.getConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(ADD_REJECTED_ORDER);
            preparedStatement.setString(1, rejectionReason);
            preparedStatement.setInt(2, order.getOrderId());
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (ConnectionPoolException | SQLException e){
            connection.rollback();
            throw new DAOException(e);
        }
        finally {
            try{
                connectionPool.closeConnection(connection,preparedStatement);
            }
            catch (ConnectionPoolException e){
                throw new DAOException(e);
            }
        }

    }
    @Override
    public void addComfirmedOrder(Order order) throws DAOException, SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = connectionPool.getConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(ADD_COMFIRMED_ORDER);
            preparedStatement.setInt(1, order.getOrderId());
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (ConnectionPoolException | SQLException e){
            connection.rollback();
            throw new DAOException(e);
        }
        finally {
            try{
                connectionPool.closeConnection(connection,preparedStatement);
            }
            catch (ConnectionPoolException e){
                throw new DAOException(e);
            }
        }

    }

    @Override
    public List<Order> getAllComfirmedOrders() throws DAOException {
        return null;
    }

    @Override
    public List<Order> getAllRejectedOrders() throws DAOException {
        return null;
    }

    @Override
    public List<Order> getAllOrders() throws DAOException {
        return null;
    }
}
