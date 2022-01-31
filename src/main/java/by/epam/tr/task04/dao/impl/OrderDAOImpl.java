package by.epam.tr.task04.dao.impl;

import by.epam.tr.task04.dao.ConnectionPool.ConnectionPool;
import by.epam.tr.task04.dao.ConnectionPool.ConnectionPoolException;
import by.epam.tr.task04.dao.DAOException;
import by.epam.tr.task04.dao.OrderDAO;
import by.epam.tr.task04.entity.Order;
import by.epam.tr.task04.entity.Role;
import by.epam.tr.task04.entity.User;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrderDAOImpl implements OrderDAO {

    private static final ConnectionPool connectionPool = ConnectionPool.getInstance();

    private final static String GET_MAX_ORDER_ID = "SELECT MAX(order_id) FROM Orders;";
    private final static String ADD_ORDER = "INSERT INTO Orders(order_id, start_date, end_date, user_id, car_id, is_confirmed, is_payed, is_closed, order_price) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private final static String CLOSE_ORDER = "UPDATE Orders SET is_closed=true WHERE order_id=?;";
    private final static String UPDATE_ORDER = "UPDATE Order_status SET is_confirmed=?, rejection_reason=? WHERE order_id=?;";

    private final static String ADD_REJECTED_ORDER = "UPDATE Orders SET is_confirmed=false, is_closed=true, comments=? WHERE order_id=?;";
    private final static String ADD_COMFIRMED_ORDER = "UPDATE Orders SET is_confirmed=true WHERE order_id=?;";
    private final static String ADD_PAYED_ORDER = "UPDATE Orders SET is_payed=true WHERE order_id=?;";

    private final static String GET_ALL_COMFIRMED_ORDERS = "SELECT * FROM Orders WHERE is_confirmed=true AND is_closed=false;";
    private final static String GET_ALL_UNCOMFIRMED_ORDERS = "SELECT * FROM Orders WHERE is_confirmed=false AND is_closed=false;";
    private final static String GET_ALL_CLOSED_ORDERS = "SELECT * FROM Orders WHERE is_closed=true;";
    private final static String GET_MY_ORDERS = "SELECT * FROM Orders WHERE is_closed=false AND user_id=?;";
    private final static String GET_MY_ORDERS_HISTORY = "SELECT * FROM Orders WHERE is_closed=true AND user_id=?;";

    private final static String ADD_BILL = "INSERT INTO Bills (bill_id, final_price, order_id, order_payed) VALUES (?, ?, ?, ?);";


    @Override
    public void addOrder(Order order) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatementAddCar = null;
        try {
            connection = connectionPool.getConnection();
            connection.setAutoCommit(false);
            preparedStatementAddCar = connection.prepareStatement(ADD_ORDER);
            preparedStatementAddCar.setInt(1, getMaxOrderId() + 1);
            preparedStatementAddCar.setDate(2, java.sql.Date.valueOf(order.getStartDate()));
            preparedStatementAddCar.setDate(3, java.sql.Date.valueOf(order.getEndDate()));
            preparedStatementAddCar.setInt(4, order.getUserId());
            preparedStatementAddCar.setInt(5, order.getCarId());
            preparedStatementAddCar.setBoolean(6, order.getIsConfirmed());
            preparedStatementAddCar.setBoolean(7, order.getIsPayed());
            preparedStatementAddCar.setBoolean(8, order.getIsClosed());
            preparedStatementAddCar.setDouble(9, order.getOrderPrice());
            preparedStatementAddCar.executeUpdate();
            connection.commit();
        } catch (ConnectionPoolException | SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {

                throw new DAOException(e);
            }
            throw new DAOException(e);
        } finally {
            try {
                connectionPool.closeConnection(connection, preparedStatementAddCar);
            } catch (ConnectionPoolException e) {
                throw new DAOException(e);
            }
        }

    }

    @Override
    public void deleteOrder(int orderId) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatementDeleteCar = null;
        try {
            connection = connectionPool.getConnection();
            connection.setAutoCommit(false);
            preparedStatementDeleteCar = connection.prepareStatement(CLOSE_ORDER);
            preparedStatementDeleteCar.setInt(1, orderId);
            preparedStatementDeleteCar.executeUpdate();

            connection.commit();
        } catch (ConnectionPoolException | SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {

                throw new DAOException(e);
            }
            throw new DAOException(e);
        } finally {
            try {
                connectionPool.closeConnection(connection, preparedStatementDeleteCar);
            } catch (ConnectionPoolException e) {
                throw new DAOException(e);
            }
        }

    }


    @Override
    public void addRejectedOrder(Order order, String rejectionReason) throws DAOException {
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
        } catch (ConnectionPoolException | SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {

                throw new DAOException(e);
            }
            throw new DAOException(e);
        } finally {
            try {
                connectionPool.closeConnection(connection, preparedStatement);
            } catch (ConnectionPoolException e) {
                throw new DAOException(e);
            }
        }

    }

    @Override
    public void addComfirmedOrder(int orderId) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = connectionPool.getConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(ADD_COMFIRMED_ORDER);
            preparedStatement.setInt(1, orderId);
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (ConnectionPoolException | SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {

                throw new DAOException(e);
            }
            throw new DAOException(e);
        } finally {
            try {
                connectionPool.closeConnection(connection, preparedStatement);
            } catch (ConnectionPoolException e) {
                throw new DAOException(e);
            }
        }

    }

    @Override
    public void addPayedOrder(int orderId) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = connectionPool.getConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(ADD_PAYED_ORDER);
            preparedStatement.setInt(1, orderId);
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (ConnectionPoolException | SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {

                throw new DAOException(e);
            }
            throw new DAOException(e);
        } finally {
            try {
                connectionPool.closeConnection(connection, preparedStatement);
            } catch (ConnectionPoolException e) {
                throw new DAOException(e);
            }
        }

    }

    @Override
    public List<Order> getAllComfirmedOrders() throws DAOException {
        List<Order> allConfirmedOrders = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = connectionPool.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(GET_ALL_COMFIRMED_ORDERS);
            while (resultSet.next()) {
                Order order = new Order();
                order.setOrderId(resultSet.getInt("order_id"));
                order.setStartDate(LocalDate.parse(resultSet.getString("start_date")));
                order.setEndDate(LocalDate.parse(resultSet.getString("end_date")));
                order.setUserId(resultSet.getInt("user_id"));
                order.setCarId(resultSet.getInt("car_id"));
                order.setComments(resultSet.getString("comments"));
                order.setConfirmed(resultSet.getBoolean("is_confirmed"));
                order.setClosed(resultSet.getBoolean("is_closed"));
                order.setPayed(resultSet.getBoolean("is_payed"));
                order.setOrderPrice(resultSet.getDouble("order_price"));
                allConfirmedOrders.add(order);
            }
        } catch (ConnectionPoolException | SQLException e) {
            throw new DAOException(e);
        } finally {
            try {
                connectionPool.closeConnection(connection, statement, resultSet);
            } catch (ConnectionPoolException e) {
                throw new DAOException(e);
            }
        }
        return allConfirmedOrders;
    }

    @Override
    public int getMaxOrderId() throws DAOException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        int maxId = 0;
        try {
            connection = connectionPool.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(GET_MAX_ORDER_ID);
            while (resultSet.next()) {
                maxId = resultSet.getInt(1);
            }
        } catch (ConnectionPoolException | SQLException e) {
            throw new DAOException(e);
        } finally {
            try {
                connectionPool.closeConnection(connection, statement, resultSet);
            } catch (ConnectionPoolException e) {
                throw new DAOException(e);
            }
        }
        return maxId;
    }

    public List<Order> getMyOrders(int userId) throws DAOException {
        List<Order> myOrders = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = connectionPool.getConnection();
            preparedStatement = connection.prepareStatement(GET_MY_ORDERS);
            preparedStatement.setInt(1, userId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Order order = new Order();
                order.setOrderId(resultSet.getInt("order_id"));
                order.setStartDate(LocalDate.parse(resultSet.getString("start_date")));
                order.setEndDate(LocalDate.parse(resultSet.getString("end_date")));
                order.setUserId(resultSet.getInt("user_id"));
                order.setCarId(resultSet.getInt("car_id"));
                order.setComments(resultSet.getString("comments"));
                order.setConfirmed(resultSet.getBoolean("is_confirmed"));
                order.setClosed(resultSet.getBoolean("is_closed"));
                order.setPayed(resultSet.getBoolean("is_payed"));
                order.setOrderPrice(resultSet.getDouble("order_price"));
                myOrders.add(order);
            }
        } catch (ConnectionPoolException | SQLException e) {
            throw new DAOException(e);
        } finally {
            try {
                connectionPool.closeConnection(connection, preparedStatement, resultSet);
            } catch (ConnectionPoolException e) {
                throw new DAOException(e);
            }
        }
        return myOrders;
    }

    @Override
    public List<Order> getAllUncomfirmedOrders() throws DAOException {
        List<Order> allUnconfirmedOrders = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = connectionPool.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(GET_ALL_UNCOMFIRMED_ORDERS);
            while (resultSet.next()) {
                Order order = new Order();
                order.setOrderId(resultSet.getInt("order_id"));
                order.setStartDate(LocalDate.parse(resultSet.getString("start_date")));
                order.setEndDate(LocalDate.parse(resultSet.getString("end_date")));
                order.setUserId(resultSet.getInt("user_id"));
                order.setCarId(resultSet.getInt("car_id"));
                order.setComments(resultSet.getString("comments"));
                order.setConfirmed(resultSet.getBoolean("is_confirmed"));
                order.setClosed(resultSet.getBoolean("is_closed"));
                order.setPayed(resultSet.getBoolean("is_payed"));
                order.setOrderPrice(resultSet.getDouble("order_price"));
                allUnconfirmedOrders.add(order);
            }
        } catch (ConnectionPoolException | SQLException e) {
            throw new DAOException(e);
        } finally {
            try {
                connectionPool.closeConnection(connection, statement, resultSet);
            } catch (ConnectionPoolException e) {
                throw new DAOException(e);
            }
        }
        return allUnconfirmedOrders;
    }

    @Override
    public List<Order> getAllClosedOrders() throws DAOException {
        List<Order> allClosedOrders = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = connectionPool.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(GET_ALL_CLOSED_ORDERS);
            while (resultSet.next()) {
                Order order = new Order();
                order.setOrderId(resultSet.getInt("order_id"));
                order.setStartDate(LocalDate.parse(resultSet.getString("start_date")));
                order.setEndDate(LocalDate.parse(resultSet.getString("end_date")));
                order.setUserId(resultSet.getInt("user_id"));
                order.setCarId(resultSet.getInt("car_id"));
                order.setComments(resultSet.getString("comments"));
                order.setConfirmed(resultSet.getBoolean("is_confirmed"));
                order.setClosed(resultSet.getBoolean("is_closed"));
                order.setPayed(resultSet.getBoolean("is_payed"));
                order.setOrderPrice(resultSet.getDouble("order_price"));
                allClosedOrders.add(order);
            }
        } catch (ConnectionPoolException | SQLException e) {
            throw new DAOException(e);
        } finally {
            try {
                connectionPool.closeConnection(connection, statement, resultSet);
            } catch (ConnectionPoolException e) {
                throw new DAOException(e);
            }
        }
        return allClosedOrders;
    }

    public List<Order> getMyOrdersHistory(int userId) throws DAOException {
        List<Order> myOrdersHistory = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = connectionPool.getConnection();
            preparedStatement = connection.prepareStatement(GET_MY_ORDERS_HISTORY);
            preparedStatement.setInt(1, userId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Order order = new Order();
                order.setOrderId(resultSet.getInt("order_id"));
                order.setStartDate(LocalDate.parse(resultSet.getString("start_date")));
                order.setEndDate(LocalDate.parse(resultSet.getString("end_date")));
                order.setUserId(resultSet.getInt("user_id"));
                order.setCarId(resultSet.getInt("car_id"));
                order.setComments(resultSet.getString("comments"));
                order.setConfirmed(resultSet.getBoolean("is_confirmed"));
                order.setClosed(resultSet.getBoolean("is_closed"));
                order.setPayed(resultSet.getBoolean("is_payed"));
                order.setOrderPrice(resultSet.getDouble("order_price"));
                myOrdersHistory.add(order);
            }
        } catch (ConnectionPoolException | SQLException e) {
            throw new DAOException(e);
        } finally {
            try {
                connectionPool.closeConnection(connection, preparedStatement, resultSet);
            } catch (ConnectionPoolException e) {
                throw new DAOException(e);
            }
        }
        return myOrdersHistory;
    }

}
