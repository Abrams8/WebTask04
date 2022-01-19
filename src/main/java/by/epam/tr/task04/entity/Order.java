package by.epam.tr.task04.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;


public class Order implements Serializable {
    private Integer orderId;
    private Date startDate;
    private Date endDate;
    private String status;
    private Integer userId;
    private Integer carId;
    private OrderStatus orderStatus;

    public Order(){}

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(orderId, order.orderId) && Objects.equals(startDate, order.startDate) && Objects.equals(endDate, order.endDate) && Objects.equals(status, order.status) && Objects.equals(userId, order.userId) && Objects.equals(carId, order.carId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, startDate, endDate, status, userId, carId);
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", status='" + status + '\'' +
                ", userId=" + userId +
                ", carId=" + carId +
                '}';
    }
}
