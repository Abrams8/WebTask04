package by.epam.tr.task04.dao.impl;

import by.epam.tr.task04.dao.CarDAO;
import by.epam.tr.task04.dao.ConnectionPool.ConnectionPool;
import by.epam.tr.task04.dao.ConnectionPool.ConnectionPoolException;
import by.epam.tr.task04.dao.DAOException;
import by.epam.tr.task04.entity.Car;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class CarDAOImpl implements CarDAO {

    private static final ConnectionPool connectionPool = ConnectionPool.getInstance();

    private final static String GET_ALL_CARS = "SELECT * FROM Cars";
    private final static String GET_ALL_FREE_CARS = "SELECT * FROM Cars NATURAL JOIN Car_status WHERE is_busy=false and is_repaired=false;";
    private final static String GET_ALL_BUSY_CARS = "SELECT * FROM Cars NATURAL JOIN Car_status WHERE is_busy=true;";
    private final static String GET_ALL_BROKEN_CARS = "SELECT * FROM Cars NATURAL JOIN Car_status WHERE is_repaired=true;";
    private final static String GET_CAR_BY_ID = "SELECT * FROM Cars NATURAL JOIN Car_status WHERE car_id=?;";

    private final static String ADD_CAR = "INSERT INTO Cars(car_id, brand, model, transmission_type, year_of_issue, price, fuel_type, body_type) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
    private final static String ADD_CAR_STATUS = "INSERT INTO Car_status(car_status_id, car_id) VALUES (?, ?);";

    private final static String UPDATE_CAR_PRICE = "UPDATE Cars SET price=? WHERE car_id=?;";
    private final static String DELETE_CAR = "DELETE FROM Cars WHERE car_id=?;";
    private final static String DELETE_CAR_FROM_CAR_STATUS = "DELETE FROM Cars_status WHERE car_id=?;";

    private final static String ADD_CAR_TO_REPAIR = "UPDATE Car_status SET is_repaired=? WHERE car_id = ?;";
    private final static String ADD_CAR_TO_BUSY = "UPDATE Car_status SET is_busy=?, rent_start_date=?, rent_end_date=? WHERE car_id = ?;";
    private final static String DELETE_CAR_FROM_REPAIR = "UPDATE Car_status SET is_repaired = false WHERE car_id = ?;";
    private final static String DELETE_CAR_FROM_BUSY = "UPDATE Car_status SET is_busy = false, rent_start_date = null, rent_end_date = null WHERE car_id = ?;";
    private final static String GET_MAX_CAR_STATUS_ID = "SELECT MAX(car_status_id) FROM Car_status;";


    @Override
    public List<Car> getAllCars() throws DAOException {
        List<Car> allCarsList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = connectionPool.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(GET_ALL_CARS);
            while (resultSet.next()) {
                Car car = new Car();
                car.setCarId(resultSet.getInt("car_id"));
                car.setBrand(resultSet.getString("brand"));
                car.setModel(resultSet.getString("model"));
                car.setTransmissionType(resultSet.getString("transmission_type"));
                car.setYearOfIssue(resultSet.getInt("year_of_issue"));
                car.setPrice(resultSet.getDouble("price"));
                car.setFuelType(resultSet.getString("fuel_type"));
                car.setBodyType(resultSet.getString("body_type"));
                allCarsList.add(car);
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
        return allCarsList;
    }

    @Override
    public List<Car> getAllFreeCars() throws DAOException {
        List<Car> allFreeCarsList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = connectionPool.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(GET_ALL_FREE_CARS);
            while (resultSet.next()) {
                Car car = new Car();
                car.setCarId(resultSet.getInt("car_id"));
                car.setBrand(resultSet.getString("brand"));
                car.setModel(resultSet.getString("model"));
                car.setTransmissionType(resultSet.getString("transmission_type"));
                car.setYearOfIssue(resultSet.getInt("year_of_issue"));
                car.setPrice(resultSet.getDouble("price"));
                car.setFuelType(resultSet.getString("fuel_type"));
                car.setBodyType(resultSet.getString("body_type"));
                allFreeCarsList.add(car);
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
        return allFreeCarsList;
    }

    @Override
    public List<Car> getAllBusyCars() throws DAOException {
        List<Car> allLockCarsList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = connectionPool.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(GET_ALL_BUSY_CARS);
            while (resultSet.next()) {
                Car car = new Car();
                car.setCarId(resultSet.getInt("car_id"));
                car.setBrand(resultSet.getString("brand"));
                car.setModel(resultSet.getString("model"));
                car.setTransmissionType(resultSet.getString("transmission_type"));
                car.setYearOfIssue(resultSet.getInt("year_of_issue"));
                car.setPrice(resultSet.getDouble("price"));
                car.setFuelType(resultSet.getString("fuel_type"));
                car.setBodyType(resultSet.getString("body_type"));
                allLockCarsList.add(car);
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
        return allLockCarsList;
    }


    @Override
    public List<Car> getAllBrokenCars() throws DAOException {
        List<Car> allBrokenCarsList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = connectionPool.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(GET_ALL_BROKEN_CARS);
            while (resultSet.next()) {
                Car car = new Car();
                car.setCarId(resultSet.getInt("car_id"));
                car.setBrand(resultSet.getString("brand"));
                car.setModel(resultSet.getString("model"));
                car.setTransmissionType(resultSet.getString("transmission_type"));
                car.setYearOfIssue(resultSet.getInt("year_of_issue"));
                car.setPrice(resultSet.getDouble("price"));
                car.setFuelType(resultSet.getString("fuel_type"));
                car.setBodyType(resultSet.getString("body_type"));
                allBrokenCarsList.add(car);
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
        return allBrokenCarsList;
    }

    @Override
    public Car findCarById(int carId) throws DAOException {
        Car car = new Car();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = connectionPool.getConnection();
            preparedStatement = connection.prepareStatement(GET_CAR_BY_ID);
            preparedStatement.setInt(1, carId);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                car.setCarId(carId);
                car.setBrand(resultSet.getString("brand"));
                car.setModel(resultSet.getString("model"));
                car.setTransmissionType(resultSet.getString("transmission_type"));
                car.setYearOfIssue(resultSet.getInt("year_of_issue"));
                car.setPrice(resultSet.getDouble("price"));
                car.setFuelType(resultSet.getString("fuel_type"));
                car.setBodyType(resultSet.getString("body_type"));
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
        return car;
    }

    @Override
    public void addCar(Car car) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatementAddCar = null;
        PreparedStatement preparedStatementAddCarStatus = null;
        try {
            connection = connectionPool.getConnection();
            connection.setAutoCommit(false);
            preparedStatementAddCar = connection.prepareStatement(ADD_CAR);
            preparedStatementAddCar.setInt(1, car.getCarId());
            preparedStatementAddCar.setString(2, car.getBrand());
            preparedStatementAddCar.setString(3, car.getModel());
            preparedStatementAddCar.setString(4, car.getTransmissionType());
            preparedStatementAddCar.setInt(5, car.getYearOfIssue());
            preparedStatementAddCar.setDouble(6, car.getPrice());
            preparedStatementAddCar.setString(7, car.getFuelType());
            preparedStatementAddCar.setString(8, car.getBodyType());
            preparedStatementAddCar.executeUpdate();

            preparedStatementAddCarStatus = connection.prepareStatement(ADD_CAR_STATUS);
            preparedStatementAddCarStatus.setInt(1, getMaxCarStatusId() + 1);
            preparedStatementAddCarStatus.setInt(2, car.getCarId());
            preparedStatementAddCarStatus.executeUpdate();
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
                /////  closeConnection(preparedStatementAddCarStatus)
            } catch (ConnectionPoolException e) {
                throw new DAOException(e);
            }
        }

    }

    @Override
    public void updateCarPrice(int carId, double price) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = connectionPool.getConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(UPDATE_CAR_PRICE);
            preparedStatement.setDouble(1, price);
            preparedStatement.setInt(2, carId);
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
    public void deleteCar(int carId) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = connectionPool.getConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(DELETE_CAR);
            preparedStatement.setInt(1, carId);
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
    public void addCarToRepair(int carId) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = connectionPool.getConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(ADD_CAR_TO_REPAIR);
            preparedStatement.setBoolean(1, true);
            preparedStatement.setInt(2, carId);
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
    public void addCarToBusy(int carId, LocalDate startRent, LocalDate endRent) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = connectionPool.getConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(ADD_CAR_TO_BUSY);
            preparedStatement.setBoolean(1, true);
            preparedStatement.setDate(2, java.sql.Date.valueOf(startRent));
            preparedStatement.setDate(3, java.sql.Date.valueOf(endRent));
            preparedStatement.setInt(4, carId);
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
    public void deleteCarFromRepair(int carId) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = connectionPool.getConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(DELETE_CAR_FROM_REPAIR);
            preparedStatement.setInt(1, carId);
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
    public void deleteCarFromBusy(int carId) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = connectionPool.getConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(DELETE_CAR_FROM_BUSY);
            preparedStatement.setInt(1, carId);
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
    public int getMaxCarStatusId() throws DAOException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        int maxId = 0;
        try {
            connection = connectionPool.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(GET_MAX_CAR_STATUS_ID);
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
}
