package by.epam.tr.task04.entity;

import java.io.Serializable;
import java.util.Objects;

public class OrderStatus implements Serializable {
    private Integer id;
    private Integer billId;
    private Integer carStatusId;
    private String rejectionReason;

    public OrderStatus(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBillId() {
        return billId;
    }

    public void setBillId(Integer billId) {
        this.billId = billId;
    }

    public Integer getCarStatusId() {
        return carStatusId;
    }

    public void setCarStatusId(Integer carStatusId) {
        this.carStatusId = carStatusId;
    }

    public String getRejectionReason() {
        return rejectionReason;
    }

    public void setRejectionReason(String rejectionReason) {
        this.rejectionReason = rejectionReason;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderStatus that = (OrderStatus) o;
        return Objects.equals(id, that.id) && Objects.equals(billId, that.billId) && Objects.equals(carStatusId, that.carStatusId) && Objects.equals(rejectionReason, that.rejectionReason);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, billId, carStatusId, rejectionReason);
    }

    @Override
    public String toString() {
        return "OrderStatus{" +
                "id=" + id +
                ", billId=" + billId +
                ", carStatusId=" + carStatusId +
                ", rejectionReason='" + rejectionReason + '\'' +
                '}';
    }
}
