package by.epam.tr.task04.dao;

import by.epam.tr.task04.entity.BlackList;
import by.epam.tr.task04.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {

    List<User> getAllUsers() throws DAOException, SQLException;
    List<User> getAllUsersInBlackList() throws DAOException, SQLException;

    void addUser(User user) throws DAOException, SQLException;
    void addUserToBlackList(int userId, String reason) throws DAOException, SQLException;


    User findUserById(int userId) throws DAOException, SQLException;
    User findUserByLogin(String userLogin) throws DAOException, SQLException;
    User findUserByPhoneNumber(String userPhoneNumber) throws DAOException, SQLException;
    boolean findInBlacklistById(int id) throws DAOException, SQLException;

    void updateUser(User user) throws DAOException, SQLException;

    void deleteUser(int userId) throws DAOException, SQLException;
    void deleteUserFromBlackList(int userId) throws DAOException, SQLException;

    int getUserIdByLogin(String login) throws DAOException, SQLException;
    int getMaxUserId() throws DAOException;

}
