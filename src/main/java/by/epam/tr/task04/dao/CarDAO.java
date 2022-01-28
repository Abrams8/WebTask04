package by.epam.tr.task04.dao;

import by.epam.tr.task04.entity.Car;

import java.sql.SQLException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public interface CarDAO {

    List<Car> getAllCars() throws DAOException;
    List<Car> getAllFreeCars() throws DAOException;
    List<Car> getAllBusyCars() throws DAOException;
    List<Car> getAllBrokenCars() throws DAOException;

    Car findCarById(int carId) throws DAOException;

    void addCar(Car car) throws DAOException;
    void updateCar(Car car) throws DAOException;
    void deleteCar(Car car) throws DAOException;

    void addCarToRepair(Car car, LocalDate startRepaired, LocalDate endRepaired) throws DAOException;
    void addCarToBusy(int carId, LocalDate startRent, LocalDate endRent) throws DAOException;
    void deleteCarFromRepair(Car car) throws DAOException;
    void deleteCarFromBusy(int carId) throws DAOException;

    int getMaxCarStatusId() throws DAOException;


}
