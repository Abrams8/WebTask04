package by.epam.tr.task04.entity;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;

public class CarStatus implements Serializable {

    private int carStatusId;
    private Boolean isBusy;
    private Boolean isRepaired;
    private int carId;
    private LocalDate repairStartDate;
    private LocalDate repairEndDate;

    public CarStatus(){}

    public int getCarStatusId() {
        return carStatusId;
    }

    public void setCarStatusId(int carStatusId) {
        this.carStatusId = carStatusId;
    }

    public Boolean getBusy() {
        return isBusy;
    }

    public void setBusy(Boolean busy) {
        isBusy = busy;
    }

    public Boolean getRepaired() {
        return isRepaired;
    }

    public void setRepaired(Boolean repaired) {
        isRepaired = repaired;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public LocalDate getRepairStartDate() {
        return repairStartDate;
    }

    public void setRepairStartDate(LocalDate repairStartDate) {
        this.repairStartDate = repairStartDate;
    }

    public LocalDate getRepairEndDate() {
        return repairEndDate;
    }

    public void setRepairEndDate(LocalDate repairEndDate) {
        this.repairEndDate = repairEndDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarStatus carStatus = (CarStatus) o;
        return Objects.equals(carStatusId, carStatus.carStatusId) && Objects.equals(isBusy, carStatus.isBusy) && Objects.equals(isRepaired, carStatus.isRepaired) && Objects.equals(carId, carStatus.carId) && Objects.equals(repairStartDate, carStatus.repairStartDate) && Objects.equals(repairEndDate, carStatus.repairEndDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carStatusId, isBusy, isRepaired, carId, repairStartDate, repairEndDate);
    }

    @Override
    public String toString() {
        return "CarStatus{" +
                "carStatusId=" + carStatusId +
                ", isBusy=" + isBusy +
                ", isRepaired=" + isRepaired +
                ", carId=" + carId +
                ", repairStartDate=" + repairStartDate +
                ", repairEndDate=" + repairEndDate +
                '}';
    }
}
