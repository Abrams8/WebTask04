package by.epam.tr.task04.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

public class Car implements Serializable {

    private Integer carId;
    private String brand;
    private String model;
    private String transmissionType;
    private Integer yearOfIssue;
    private Double price;
    private String fuelType;
    private String bodyType;

    public Car() {
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getTransmissionType() {
        return transmissionType;
    }

    public void setTransmissionType(String transmissionType) {
        this.transmissionType = transmissionType;
    }

    public Integer getYearOfIssue() {
        return yearOfIssue;
    }

    public void setYearOfIssue(Integer yearOfIssue) {
        this.yearOfIssue = yearOfIssue;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(carId, car.carId) && Objects.equals(brand, car.brand) && Objects.equals(model, car.model) && Objects.equals(transmissionType, car.transmissionType) && Objects.equals(yearOfIssue, car.yearOfIssue) && Objects.equals(price, car.price) && Objects.equals(fuelType, car.fuelType) && Objects.equals(bodyType, car.bodyType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carId, brand, model, transmissionType, yearOfIssue, price, fuelType, bodyType);
    }

    @Override
    public String toString() {
        return "Car{" +
                "carId=" + carId +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", transmissionType='" + transmissionType + '\'' +
                ", yearOfIssue=" + yearOfIssue +
                ", price=" + price +
                ", fuelType='" + fuelType + '\'' +
                ", bodyType='" + bodyType + '\'' +
                '}';
    }
}