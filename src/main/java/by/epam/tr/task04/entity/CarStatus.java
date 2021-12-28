package by.epam.tr.task04.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

public class CarStatus implements Serializable {

    private Integer carStatusId;
    private Boolean isBusy;
    private Boolean isRepaired;
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
