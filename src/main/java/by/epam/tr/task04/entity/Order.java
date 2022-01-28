package by.epam.tr.task04.entity;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;


public class Order implements Serializable {
    private int orderId;
    private LocalDate startDate;
    private LocalDate endDate;
    private int userId;
    private int carId;
    private String comments;
    private boolean isConfirmed;
    private boolean isPayed;
    private boolean isClosed;

    public Order() {
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public boolean getIsConfirmed() {
        return isConfirmed;
    }

    public void setConfirmed(boolean confirmed) {
        isConfirmed = confirmed;
    }

    public boolean getIsPayed() {
        return isPayed;
    }

    public void setPayed(boolean payed) {
        isPayed = payed;
    }

    public boolean getIsClosed() {
        return isClosed;
    }

    public void setClosed(boolean closed) {
        isClosed = closed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return isConfirmed == order.isConfirmed && isPayed == order.isPayed && isClosed == order.isClosed && Objects.equals(orderId, order.orderId) && Objects.equals(startDate, order.startDate) && Objects.equals(endDate, order.endDate) && Objects.equals(userId, order.userId) && Objects.equals(carId, order.carId) && Objects.equals(comments, order.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, startDate, endDate, userId, carId, comments, isConfirmed, isPayed, isClosed);
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", userId=" + userId +
                ", carId=" + carId +
                ", comments='" + comments + '\'' +
                ", isConfirmed=" + isConfirmed +
                ", isPayed=" + isPayed +
                ", isClosed=" + isClosed +
                '}';
    }
}
