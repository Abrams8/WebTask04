package by.epam.tr.task04.dao.impl;

import by.epam.tr.task04.dao.CarDAO;
import by.epam.tr.task04.dao.DAOException;
import by.epam.tr.task04.entity.Car;

import java.util.List;

public class CarDAOImpl implements CarDAO {


    @Override
    public List<Car> getAllCars() throws DAOException {
        return null;
    }

    @Override
    public List<Car> getAllFreeCars() throws DAOException {
        return null;
    }

    @Override
    public List<Car> getAllLockCars() throws DAOException {
        return null;
    }

    @Override
    public List<Car> getAllBrokenCars() throws DAOException {
        return null;
    }

    @Override
    public Car findCarById(int carId) throws DAOException {
        return null;
    }

    @Override
    public void addCar(int CarId, Car car) throws DAOException {

    }

    @Override
    public void updateCar(int CarId, Car car) throws DAOException {

    }

    @Override
    public void deleteCar(int CarId, Car car) throws DAOException {

    }
}
