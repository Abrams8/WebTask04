package by.epam.tr.task04.service.impl;

import by.epam.tr.task04.dao.DAOException;
import by.epam.tr.task04.dao.DAOFactory;
import by.epam.tr.task04.dao.UserDAO;
import by.epam.tr.task04.entity.User;
import by.epam.tr.task04.service.UserService;
import by.epam.tr.task04.service.exception.ServiceException;
import by.epam.tr.task04.service.validator.UserValidator;
import by.epam.tr.task04.service.validator.notEmptyStringValidator;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserDAO userDAO = DAOFactory.getInstance().getUserDAO();

    @Override
    public List<User> getAllUsers() throws ServiceException {
        List<User> allUsers;
        try {
            allUsers = userDAO.getAllUsers();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return allUsers;
    }

    @Override
    public List<User> getAllUsersInBlackList() throws ServiceException {
        List<User> allUsersInBlackList;
        try {
            allUsersInBlackList = userDAO.getAllUsersInBlackList();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return allUsersInBlackList;
    }

    @Override
    public void addUser(User user) throws ServiceException {
        try {
            userDAO.addUser(user);
        } catch (DAOException | SQLException e) {
            throw new ServiceException(e);
        }

    }

    @Override
    public void addUserToBlackList(int userId, String reason) throws ServiceException {
        try {
            userDAO.addUserToBlackList(userId, reason);
        } catch (DAOException | SQLException e) {
            throw new ServiceException(e);
        }

    }


    @Override
    public User findUserById(int userId) throws ServiceException {
        User user;
        try {
            user = userDAO.findUserById(userId);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return user;
    }

    @Override
    public User findUserByLogin(String userLogin) throws ServiceException {
        User user;
        try {
            user = userDAO.findUserByLogin(userLogin);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return user;
    }

    @Override
    public User findUserByPhoneNumber(String userPhoneNumber) throws ServiceException {
        User user;
        try {
            user = userDAO.findUserByPhoneNumber(userPhoneNumber);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return user;
    }

    @Override
    public boolean findInBlacklistById(int id) throws ServiceException {
        boolean result;
        try {
            result = userDAO.findInBlacklistById(id);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return result;
    }

    @Override
    public void updateUserBy(User user) throws ServiceException {
        try {
            userDAO.updateUser(user);
        } catch (DAOException | SQLException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void deleteUserById(int userId) throws ServiceException {
        try {
            userDAO.deleteUserById(userId);
        } catch (DAOException | SQLException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void deleteUserFromBlackList(int userId) throws ServiceException {
        try {
            userDAO.deleteUserFromBlackList(userId);
        } catch (DAOException | SQLException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public int getUserIdByLogin(String login) throws ServiceException {
        int userId;
        try {
            userId = userDAO.getUserIdByLogin(login);
        } catch (DAOException | SQLException e) {
            throw new ServiceException(e);
        }
        return userId;
    }

    @Override
    public int getMaxUserId() throws ServiceException {
        int maxUserId;
        try {
            maxUserId = userDAO.getMaxUserId();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return maxUserId;
    }

    @Override
    public String encodePassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public boolean checkPassword(String password, String realHashedPassword){
        return BCrypt.checkpw(password, realHashedPassword);
    }

    @Override
    public boolean logination(String login, String password) throws ServiceException {
        UserValidator userValidator = new UserValidator();
        if (!userValidator.loginationUserValidator(login, password)) {
            return false;
        } else {
            try{
                User user = new User();
                user = userDAO.findUserByLogin(login);
                if(checkPassword(password, user.getPassword())){
                    return true;
                }
            } catch (DAOException e) {
               throw new ServiceException (e);
            }
        } return false;
    }
    @Override
    public int getUserRole(int userId) throws DAOException, ServiceException {
        int userRole;
        try {
            userRole = userDAO.getUserRoleByUserId(userId);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return userRole;
    }

}
