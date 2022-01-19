package by.epam.tr.task04.service.impl;

import by.epam.tr.task04.dao.CarDAO;
import by.epam.tr.task04.dao.DAOException;
import by.epam.tr.task04.dao.DAOFactory;
import by.epam.tr.task04.entity.Car;
import by.epam.tr.task04.service.CarService;
import by.epam.tr.task04.service.exception.ServiceException;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class CarServiceImpl implements CarService {

    private final CarDAO carDAO = DAOFactory.getInstance().getCarDAO();

    @Override
    public List<Car> getAllCars() throws ServiceException {
        List<Car> allCars;
        try{
            allCars = carDAO.getAllCars();
        } catch (DAOException | SQLException e) {
            throw new ServiceException(e);
        } return allCars;
    }

    @Override
    public List<Car> getAllFreeCars() throws ServiceException {
        List<Car> allFreeCars;
        try{
            allFreeCars = carDAO.getAllFreeCars();
        } catch (DAOException | SQLException e) {
            throw new ServiceException(e);
        } return allFreeCars;
    }

    @Override
    public List<Car> getAllBusyCars() throws ServiceException {
        List<Car> allBusyCars;
        try{
            allBusyCars = carDAO.getAllBusyCars();
        } catch (DAOException | SQLException e) {
            throw new ServiceException(e);
        } return allBusyCars;
    }

    @Override
    public List<Car> getAllBrokenCars() throws ServiceException {
        List<Car> allBrokenCars;
        try{
            allBrokenCars = carDAO.getAllBrokenCars();
        } catch (DAOException | SQLException e) {
            throw new ServiceException(e);
        } return allBrokenCars;
    }

    @Override
    public Car findCarById(int carId) throws ServiceException {
        Car car;
        try{
            car = carDAO.findCarById(carId);
        } catch (DAOException | SQLException e) {
            throw new ServiceException(e);
        } return car;
    }

    @Override
    public void addCar(Car car) throws ServiceException {
        try{
           carDAO.addCar(car);
        } catch (DAOException | SQLException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void updateCar(Car car) throws ServiceException {
        try{
            carDAO.updateCar(car);
        } catch (DAOException | SQLException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void deleteCar(Car car) throws ServiceException {
        try{
            carDAO.deleteCar(car);
        } catch (DAOException | SQLException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void addCarToRepair(Car car, Date startRepaired, Date endRepaired) throws ServiceException {
        try{
            carDAO.addCarToRepair(car, startRepaired, endRepaired);
        } catch (DAOException | SQLException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void addCarToBusy(Car car, Date startRent, Date endRent) throws ServiceException {
        try{
            carDAO.addCarToBusy(car, startRent, endRent);
        } catch (DAOException | SQLException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void deleteCarFromRepair(Car car) throws ServiceException {
        try{
            carDAO.deleteCarFromRepair(car);
        } catch (DAOException | SQLException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void deleteCarFromBusy(Car car) throws ServiceException {
        try{
            carDAO.deleteCarFromBusy(car);
        } catch (DAOException | SQLException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public int getMaxCarStatusId() throws ServiceException {
        int maxCarStatusId;
        try{
            maxCarStatusId = carDAO.getMaxCarStatusId();
        } catch (DAOException | SQLException e) {
            throw new ServiceException(e);
        } return maxCarStatusId;
    }
}
