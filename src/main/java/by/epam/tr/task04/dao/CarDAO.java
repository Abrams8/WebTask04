package by.epam.tr.task04.dao;

import by.epam.tr.task04.entity.Car;

import java.sql.SQLException;
import java.sql.Date;
import java.util.List;

public interface CarDAO {

    List<Car> getAllCars() throws DAOException, SQLException;
    List<Car> getAllFreeCars() throws DAOException, SQLException;
    List<Car> getAllBusyCars() throws DAOException, SQLException;
    List<Car> getAllBrokenCars() throws DAOException, SQLException;

    Car findCarById(int carId) throws DAOException, SQLException;

    void addCar(Car car) throws DAOException, SQLException;
    void updateCar(Car car) throws DAOException, SQLException;
    void deleteCar(Car car) throws DAOException, SQLException;

    void addCarToRepair(Car car, Date startRepaired, Date endRepaired) throws DAOException, SQLException;
    void addCarToBusy(Car car, Date startRent, Date endRent) throws DAOException, SQLException;
    void deleteCarFromRepair(Car car) throws DAOException, SQLException;
    void deleteCarFromBusy(Car car) throws DAOException, SQLException;

    int getMaxCarStatusId() throws DAOException, SQLException;


}
