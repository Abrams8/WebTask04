package by.epam.tr.task04.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

public class CarStatus implements Serializable {

    private Integer carStatusId;
    private String carStatus;
    private Integer carId;
    private Date repairStartDate;
    private Date repairEndDate;

    public CarStatus(){}

    public Integer getCarStatusId() {
        return carStatusId;
    }

    public void setCarStatusId(Integer carStatusId) {
        this.carStatusId = carStatusId;
    }

    public String getCarStatus() {
        return carStatus;
    }

    public void setCarStatus(String carStatus) {
        this.carStatus = carStatus;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public Date getRepairStartDate() {
        return repairStartDate;
    }

    public void setRepairStartDate(Date repairStartDate) {
        this.repairStartDate = repairStartDate;
    }

    public Date getRepairEndDate() {
        return repairEndDate;
    }

    public void setRepairEndDate(Date repairEndDate) {
        this.repairEndDate = repairEndDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarStatus carStatus1 = (CarStatus) o;
        return Objects.equals(carStatusId, carStatus1.carStatusId) && Objects.equals(carStatus, carStatus1.carStatus) && Objects.equals(carId, carStatus1.carId) && Objects.equals(repairStartDate, carStatus1.repairStartDate) && Objects.equals(repairEndDate, carStatus1.repairEndDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carStatusId, carStatus, carId, repairStartDate, repairEndDate);
    }

    @Override
    public String toString() {
        return "CarStatus{" +
                "carStatusId=" + carStatusId +
                ", carStatus='" + carStatus + '\'' +
                ", carId=" + carId +
                ", repairStartDate=" + repairStartDate +
                ", repairEndDate=" + repairEndDate +
                '}';
    }
}
