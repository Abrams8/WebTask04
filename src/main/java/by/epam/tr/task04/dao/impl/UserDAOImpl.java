package by.epam.tr.task04.dao.impl;

import by.epam.tr.task04.dao.ConnectionPool.ConnectionPool;
import by.epam.tr.task04.dao.ConnectionPool.ConnectionPoolException;
import by.epam.tr.task04.dao.DAOException;
import by.epam.tr.task04.dao.UserDAO;
import by.epam.tr.task04.entity.BlackList;
import by.epam.tr.task04.entity.Role;
import by.epam.tr.task04.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {

    private static final ConnectionPool connectionPool = ConnectionPool.getInstance();

    private final static String ADD_USER = "INSERT INTO Users(user_id, login, password, pasport_number, name, surname, age, phone_number, user_roles_id, mail) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private final static String ADD_USER_TO_BLACK_LIST = "INSERT INTO Black_list(user_id, reason) VALUES(?, ?);";
    private final static String GET_USER_BY_ID = "SELECT * FROM Users NATURAL JOIN black_list NATURAL JOIN user_roles WHERE user_id=?;";
    private final static String GET_ALL_USERS = "SELECT * FROM Users NATURAL JOIN User_roles NATURAL JOIN Black_list;";
    private final static String UPDATE_USER_BY_ID = "UPDATE Users SET user_id=?, login=?, password=?, pasport_number=?, name=?, surname=?, age=?, phone_number=?, user_roles_id=? mail=? WHERE user_id=?;";
    private final static String GET_MAX_USER_ID = "SELECT MAX(user_id) FROM Users;";
    private final static String GET_ALL_USERS_IN_BLACK_LIST = "SELECT * FROM Users INNER JOIN Black_list using(user_id);";
    private final static String FIND_USER_BY_LOGIN = "SELECT * FROM Users WHERE login=?;";
    private final static String FIND_USER_BY_PHONE_NUMBER = "SELECT * FROM Users WHERE phone_number=?;";
    private final static String FIND_USER_IN_BLACK_LIST_BY_ID = "SELECT * FROM Black_list NATURAL JOIN Users NATURAL JOIN User_roles WHERE user_id=?;";
    private final static String DELETE_USER_BY_ID = "DELETE FROM Users WHERE user_id=?;";
    private final static String DELETE_USER_FROM_BLACK_LIST_BY_ID = "DELETE FROM Black_list WHERE user_id=?;";
    private final static String GET_USER_ID_BY_LOGIN = "SELECT user_id FROM Users WHERE login=?;";
    private final static String GET_USER_ROLE_BY_USER_ID = "SELECT user_role_id FROM Users WHERE user_id=?;";

    @Override
    public List<User> getAllUsers() throws DAOException {
        List<User> allUsersList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = connectionPool.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(GET_ALL_USERS);
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("user_id"));
                user.setAge(resultSet.getInt("age"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                user.setPasportNumber(resultSet.getString("pasport_number"));
                user.setPhoneNumber(resultSet.getString("phone_number"));
                user.setName(resultSet.getString("name"));
                user.setSurname(resultSet.getString("surname"));
                user.setRole(Role.getRoleById(resultSet.getInt("user_role_id")));
                user.setMail(resultSet.getString("mail"));
                allUsersList.add(user);
            }
        } catch (ConnectionPoolException | SQLException e){
            throw new DAOException(e);
        }
        finally {
            try{
                connectionPool.closeConnection(connection,statement,resultSet);
            }
            catch (ConnectionPoolException e){
                throw new DAOException(e);
            }
        }
        return allUsersList;
    }

    @Override
    public List<User> getAllUsersInBlackList() throws DAOException {
        List<User> allUsersInBlackList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = connectionPool.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(GET_ALL_USERS_IN_BLACK_LIST);
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("user_id"));
                user.setAge(resultSet.getInt("age"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                user.setPasportNumber(resultSet.getString("pasport_number"));
                user.setPhoneNumber(resultSet.getString("phone_number"));
                user.setName(resultSet.getString("name"));
                user.setSurname(resultSet.getString("surname"));
                user.setRole(Role.getRoleById(resultSet.getInt("user_role_id")));
                user.setMail(resultSet.getString("mail"));
                allUsersInBlackList.add(user);
            }
        } catch (ConnectionPoolException | SQLException e){
            throw new DAOException(e);
        }
        finally {
            try{
                connectionPool.closeConnection(connection,statement,resultSet);
            }
            catch (ConnectionPoolException e){
                throw new DAOException(e);
            }
        }
        return allUsersInBlackList;
    }


    @Override
    public void addUser(User user) throws DAOException, SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = connectionPool.getConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(ADD_USER);
            preparedStatement.setInt(1, getMaxUserId() + 1);
            preparedStatement.setString(2, user.getLogin());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getPasportNumber());
            preparedStatement.setString(5, user.getName());
            preparedStatement.setString(6, user.getSurname());
            preparedStatement.setInt(7, user.getAge());
            preparedStatement.setString(8, user.getPhoneNumber());
            preparedStatement.setInt(9, user.getRole().getRoleId());
            preparedStatement.setString(10, user.getMail());
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
    public void addUserToBlackList(int userId, String reason) throws DAOException, SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = connectionPool.getConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(ADD_USER_TO_BLACK_LIST);
            preparedStatement.setInt(1, userId);
            preparedStatement.setString(2, reason);

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
    public User findUserById(int userId) throws DAOException {
        User user = new User();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = connectionPool.getConnection();
            preparedStatement = connection.prepareStatement(GET_USER_BY_ID);
            preparedStatement.setInt(1, userId);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user.setId(userId);
                user.setAge(resultSet.getInt("age"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                user.setPasportNumber(resultSet.getString("pasport_number"));
                user.setPhoneNumber(resultSet.getString("phone_number"));
                user.setName(resultSet.getString("name"));
                user.setSurname(resultSet.getString("surname"));
                user.setRole(Role.getRoleById(resultSet.getInt("user_role_id")));
                user.setMail(resultSet.getString("mail"));
            }
        } catch (ConnectionPoolException | SQLException e){
            throw new DAOException(e);
        }
        finally {
            try{
                connectionPool.closeConnection(connection,preparedStatement,resultSet);
            }
            catch (ConnectionPoolException e){
                throw new DAOException(e);
            }
        }
        return user;
    }

    @Override
    public User findUserByLogin(String userLogin) throws DAOException {
        User user = new User();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = connectionPool.getConnection();
            preparedStatement = connection.prepareStatement(FIND_USER_BY_LOGIN);
            preparedStatement.setString(1, userLogin);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user.setId(resultSet.getInt("user_id"));
                user.setAge(resultSet.getInt("age"));
                user.setLogin(userLogin);
                user.setPassword(resultSet.getString("password"));
                user.setPasportNumber(resultSet.getString("pasport_number"));
                user.setPhoneNumber(resultSet.getString("phone_number"));
                user.setName(resultSet.getString("name"));
                user.setSurname(resultSet.getString("surname"));
                user.setRole(Role.getRoleById(resultSet.getInt("user_roles_id")));
                user.setMail(resultSet.getString("mail"));
            }
        } catch (ConnectionPoolException | SQLException e){
            throw new DAOException(e);
        }
        finally {
            try{
                connectionPool.closeConnection(connection,preparedStatement,resultSet);
            }
            catch (ConnectionPoolException e){
                throw new DAOException(e);
            }
        }
        return user;
    }

    @Override
    public User findUserByPhoneNumber(String userPhoneNumber) throws DAOException {
        User user = new User();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = connectionPool.getConnection();
            preparedStatement = connection.prepareStatement(FIND_USER_BY_PHONE_NUMBER);
            preparedStatement.setString(1, userPhoneNumber);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user.setId(resultSet.getInt("user_id"));
                user.setAge(resultSet.getInt("age"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                user.setPasportNumber(userPhoneNumber);
                user.setPhoneNumber(resultSet.getString("phone_number"));
                user.setName(resultSet.getString("name"));
                user.setSurname(resultSet.getString("surname"));
                user.setRole(Role.getRoleById(resultSet.getInt("user_role_id")));
                user.setMail(resultSet.getString("mail"));
            }
        } catch (ConnectionPoolException | SQLException e){
            throw new DAOException(e);
        }
        finally {
            try{
                connectionPool.closeConnection(connection,preparedStatement,resultSet);
            }
            catch (ConnectionPoolException e){
                throw new DAOException(e);
            }
        }
        return user;
    }


    @Override
    public boolean findInBlacklistById(int userId) throws DAOException {
        boolean userInBlackList = false;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = connectionPool.getConnection();
            preparedStatement = connection.prepareStatement(FIND_USER_IN_BLACK_LIST_BY_ID);
            preparedStatement.setInt(1, userId);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                userInBlackList = true;
            }
        } catch (ConnectionPoolException | SQLException e){
            throw new DAOException(e);
        }
        finally {
            try{
                connectionPool.closeConnection(connection,preparedStatement,resultSet);
            }
            catch (ConnectionPoolException e){
                throw new DAOException(e);
            }
        }
        return userInBlackList;
    }

    @Override
    public void updateUser(User user) throws DAOException, SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = connectionPool.getConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(UPDATE_USER_BY_ID);
            preparedStatement.setInt(1, user.getId());
            preparedStatement.setString(2, user.getLogin());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getPasportNumber());
            preparedStatement.setString(5, user.getName());
            preparedStatement.setString(6, user.getSurname());
            preparedStatement.setInt(7, user.getAge());
            preparedStatement.setString(8, user.getPhoneNumber());
            preparedStatement.setInt(9, user.getRole().getRoleId());
            preparedStatement.setString(10, user.getMail());
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
    public void deleteUserById(int userId) throws DAOException, SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = connectionPool.getConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(DELETE_USER_BY_ID);
            preparedStatement.setInt(1, userId);
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
    public void deleteUserFromBlackList(int userId) throws DAOException, SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = connectionPool.getConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(DELETE_USER_FROM_BLACK_LIST_BY_ID);
            preparedStatement.setInt(1, userId);
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
    public int getUserIdByLogin(String login) throws DAOException, SQLException {
        Integer userId = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = connectionPool.getConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(GET_USER_ID_BY_LOGIN);
            preparedStatement.setString(1, login);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                userId = resultSet.getInt("user_id");
                connection.commit();
            }
        } catch (ConnectionPoolException | SQLException e){
            connection.rollback();
            throw new DAOException(e);
        }
        finally {
            try{
                connectionPool.closeConnection(connection,preparedStatement,resultSet);
            }
            catch (ConnectionPoolException e){
                throw new DAOException(e);
            }
        }
        return userId;
    }

    @Override
    public int getMaxUserId() throws DAOException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        int maxId = 0;
        try {
            connection = connectionPool.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(GET_MAX_USER_ID);
            while (resultSet.next()) {
                maxId = resultSet.getInt(1);
            }
        } catch (ConnectionPoolException | SQLException e){
            throw new DAOException(e);
        }
        finally {
            try{
                connectionPool.closeConnection(connection,statement,resultSet);
            }
            catch (ConnectionPoolException e){
                throw new DAOException(e);
            }
        }
        return maxId;
    }

    @Override
    public int getUserRoleByUserId(int userId) throws DAOException {
        int userRole = 0;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = connectionPool.getConnection();
            preparedStatement = connection.prepareStatement(GET_USER_ROLE_BY_USER_ID);
            preparedStatement.setInt(1, userId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                userRole = resultSet.getInt("user_role_id");
            }
        } catch (ConnectionPoolException | SQLException e){
            throw new DAOException(e);
        }
        finally {
            try{
                connectionPool.closeConnection(connection,preparedStatement, resultSet);
            }
            catch (ConnectionPoolException e){
                throw new DAOException(e);
            }
        }
        return userRole;
    }
}