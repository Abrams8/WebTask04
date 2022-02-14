package by.epam.tr.task04.service;

import by.epam.tr.task04.entity.Car;
import by.epam.tr.task04.service.exception.ServiceException;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public interface CarService {
    List<Car> getAllCars() throws ServiceException;

    List<Car> getAllFreeCars() throws ServiceException;

    List<Car> getAllBusyCars() throws ServiceException;

    List<Car> getAllBrokenCars() throws ServiceException;

    Car findCarById(int carId) throws ServiceException;

    void addCar(Car car) throws ServiceException;

    void updateCarPrice(int carId, double price) throws ServiceException;

    void deleteCar(int carId) throws ServiceException;

    void addCarToRepair(int carId) throws ServiceException;

    void addCarToBusy(int carId, LocalDate startRent, LocalDate endRent) throws ServiceException;

    void deleteCarFromRepair(int carId) throws ServiceException;

    void deleteCarFromBusy(int carId) throws ServiceException;

    int getMaxCarStatusId() throws ServiceException;

}