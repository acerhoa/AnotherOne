package sample.Model;

import java.math.BigDecimal;

public class OrderLine {
    private int orderLineId;
    private int orderId;
    private int menuId;
    private BigDecimal orderAmount;

    public OrderLine() {
    }

    public OrderLine(int id, int orderId, int menuId, BigDecimal orderAmount) {
        orderLineId = id;
        this.orderId = orderId;
        this.menuId = menuId;
        this.orderAmount = orderAmount;
    }

    public int getOrderLineId() {
        return orderLineId;
    }

    public void setOrderLineId(int orderLineId) {
        this.orderLineId = orderLineId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }
}
