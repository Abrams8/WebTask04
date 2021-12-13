package by.epam.tr.task04.entity;

import java.io.Serializable;
import java.util.Objects;

public class BlackList implements Serializable {
    private Integer userId;
    private String reason;

    public BlackList (){}

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BlackList blackList = (BlackList) o;
        return Objects.equals(userId, blackList.userId) && Objects.equals(reason, blackList.reason);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, reason);
    }

    @Override
    public String toString() {
        return "BlackList{" +
                "userId=" + userId +
                ", reason='" + reason + '\'' +
                '}';
    }
}
