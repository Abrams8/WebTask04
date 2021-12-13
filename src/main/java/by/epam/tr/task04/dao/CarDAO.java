package by.epam.tr.task04.dao;

import by.epam.tr.task04.entity.Car;
import by.epam.tr.task04.entity.User;

import java.util.List;

public interface CarDAO {

    List<Car> getAllCars() throws DAOException;
    List<Car> getAllFreeCars() throws DAOException;
    List<Car> getAllLockCars() throws DAOException;
    List<Car> getAllBrokenCars() throws DAOException;

    Car findCarById(int carId) throws DAOException;

    void addCar(int CarId, Car car) throws DAOException;
    void updateCar(int CarId, Car car) throws DAOException;
    void deleteCar(int CarId, Car car) throws DAOException;

}
