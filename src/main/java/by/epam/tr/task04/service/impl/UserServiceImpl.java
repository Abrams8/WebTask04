package by.epam.tr.task04.service.impl;

import by.epam.tr.task04.dao.DAOException;
import by.epam.tr.task04.dao.DAOFactory;
import by.epam.tr.task04.dao.UserDAO;
import by.epam.tr.task04.entity.User;
import by.epam.tr.task04.service.UserService;
import by.epam.tr.task04.service.exception.ServiceException;
import by.epam.tr.task04.service.validator.UserValidator;
import org.mindrot.jbcrypt.BCrypt;

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
        } catch (DAOException e) {
            throw new ServiceException(e);
        }

    }

    @Override
    public void addUserToBlackList(int userId, String reason) throws ServiceException {
        try {
            userDAO.addUserToBlackList(userId, reason);
        } catch (DAOException e) {
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
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void deleteUserById(int userId) throws ServiceException {
        try {
            userDAO.deleteUserById(userId);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void deleteUserFromBlackList(int userId) throws ServiceException {
        try {
            userDAO.deleteUserFromBlackList(userId);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public int getUserIdByLogin(String login) throws ServiceException {
        int userId;
        try {
            userId = userDAO.getUserIdByLogin(login);
        } catch (DAOException e) {
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


    @Override
    public User logination(String login, String password) throws ServiceException {
        UserValidator userValidator = new UserValidator();
        if (!userValidator.loginationUserValidator(login, password)) {
            return null;
        } else {
            try{
                User user = userDAO.findUserByLogin(login);
                if(BCrypt.checkpw(password, user.getPassword())){
                    return user;
                }
            } catch (DAOException e) {
               throw new ServiceException (e);
            }
        } return null;
    }
    @Override
    public int getUserRole(int userId) throws ServiceException {
        int userRole;
        try {
            userRole = userDAO.getUserRoleByUserId(userId);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return userRole;
    }

}
