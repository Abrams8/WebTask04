package by.epam.tr.task04.service.impl;

import by.epam.tr.task04.dao.CarDAO;
import by.epam.tr.task04.dao.DAOException;
import by.epam.tr.task04.dao.DAOFactory;
import by.epam.tr.task04.entity.Car;
import by.epam.tr.task04.service.CarService;
import by.epam.tr.task04.service.exception.ServiceException;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class CarServiceImpl implements CarService {

    private final CarDAO carDAO = DAOFactory.getInstance().getCarDAO();

    @Override
    public List<Car> getAllCars() throws ServiceException {
        List<Car> allCars;
        try {
            allCars = carDAO.getAllCars();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return allCars;
    }

    @Override
    public List<Car> getAllFreeCars() throws ServiceException {
        List<Car> allFreeCars;
        try {
            allFreeCars = carDAO.getAllFreeCars();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return allFreeCars;
    }

    @Override
    public List<Car> getAllBusyCars() throws ServiceException {
        List<Car> allBusyCars;
        try {
            allBusyCars = carDAO.getAllBusyCars();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return allBusyCars;
    }

    @Override
    public List<Car> getAllBrokenCars() throws ServiceException {
        List<Car> allBrokenCars;
        try {
            allBrokenCars = carDAO.getAllBrokenCars();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return allBrokenCars;
    }

    @Override
    public Car findCarById(int carId) throws ServiceException {
        Car car;
        try {
            car = carDAO.findCarById(carId);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return car;
    }

    @Override
    public void addCar(Car car) throws ServiceException {
        try {
            carDAO.addCar(car);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void updateCar(Car car) throws ServiceException {
        try {
            carDAO.updateCar(car);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void deleteCar(Car car) throws ServiceException {
        try {
            carDAO.deleteCar(car);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void addCarToRepair(Car car, LocalDate startRepaired, LocalDate endRepaired) throws ServiceException {
        try {
            carDAO.addCarToRepair(car, startRepaired, endRepaired);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void addCarToBusy(int carId, LocalDate startRent, LocalDate endRent) throws ServiceException {
        try {
            carDAO.addCarToBusy(carId, startRent, endRent);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void deleteCarFromRepair(Car car) throws ServiceException {
        try {
            carDAO.deleteCarFromRepair(car);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void deleteCarFromBusy(int carId) throws ServiceException {
        try {
            carDAO.deleteCarFromBusy(carId);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public int getMaxCarStatusId() throws ServiceException {
        int maxCarStatusId;
        try {
            maxCarStatusId = carDAO.getMaxCarStatusId();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return maxCarStatusId;
    }
}
