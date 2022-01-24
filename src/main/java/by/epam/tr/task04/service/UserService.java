package by.epam.tr.task04.service;

import by.epam.tr.task04.dao.DAOException;
import by.epam.tr.task04.entity.User;
import by.epam.tr.task04.service.exception.ServiceException;

import java.util.List;

public interface UserService {

    List<User> getAllUsers() throws ServiceException;
    List<User> getAllUsersInBlackList() throws ServiceException;

    void addUser(User user) throws ServiceException;
    void addUserToBlackList(int userId, String reason) throws ServiceException;


    User findUserById(int userId) throws ServiceException;
    User findUserByLogin(String userLogin) throws ServiceException;
    User findUserByPhoneNumber(String userPhoneNumber) throws ServiceException;
    boolean findInBlacklistById(int id) throws ServiceException;

    void updateUserBy(User user) throws ServiceException;

    void deleteUserById(int userId) throws ServiceException;
    void deleteUserFromBlackList(int userId) throws ServiceException;

    int getUserIdByLogin(String login) throws ServiceException;
    int getMaxUserId() throws ServiceException;
    String encodePassword(String password);

    User logination (String login, String password) throws ServiceException;
    int getUserRole(int userId) throws ServiceException;
}
