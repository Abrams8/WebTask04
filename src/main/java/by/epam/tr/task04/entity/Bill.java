package by.epam.tr.task04.entity;

import java.io.Serializable;
import java.util.Objects;

public class Bill implements Serializable {
    private Integer billId;
    private String status;
    private Double finalPrice;
    private Integer orderId;

    public Bill(){}

    public Integer getBillId() {
        return billId;
    }

    public void setBillId(Integer billId) {
        this.billId = billId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(Double finalPrice) {
        this.finalPrice = finalPrice;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bill bill = (Bill) o;
        return Objects.equals(billId, bill.billId) && Objects.equals(status, bill.status) && Objects.equals(finalPrice, bill.finalPrice) && Objects.equals(orderId, bill.orderId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(billId, status, finalPrice, orderId);
    }

    @Override
    public String toString() {
        return "Bill{" +
                "billId=" + billId +
                ", status='" + status + '\'' +
                ", finalPrice=" + finalPrice +
                ", orderId=" + orderId +
                '}';
    }
}
