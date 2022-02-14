package by.epam.tr.task04.dao;

import by.epam.tr.task04.entity.BlackList;
import by.epam.tr.task04.entity.User;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface UserDAO {

    List<User> getAllUsers() throws DAOException;

    List<User> getAllUsersInBlackList() throws DAOException;

    void addUser(User user) throws DAOException;

    void addUserToBlackList(int userId, String reason) throws DAOException;

    User findUserById(int userId) throws DAOException;

    User findUserByLogin(String userLogin) throws DAOException;

    User findUserByPhoneNumber(String userPhoneNumber) throws DAOException;

    boolean findInBlacklistByLogin(String login) throws DAOException;

    void updateUser(User user) throws DAOException;

    void deleteUserById(int userId) throws DAOException;

    void deleteUserFromBlackList(int userId) throws DAOException;

    int getUserIdByLogin(String login) throws DAOException;

    int getMaxUserId() throws DAOException;

    int getUserRoleByUserId(int userId) throws DAOException;

    Map<User, BlackList> getBlackList() throws DAOException;

}
