package sample.Model;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Order {
    private int orderId;
    private int cusId;
    private int empPin;
    private String orderItems;
    private BigDecimal orderTotal;
    private String paymentType;
    private Timestamp orderDate;

    public Order() {
    }

    public Order(int orderId, int cusId, int empPin, String orderItems, BigDecimal orderTotal, String paymentType, Timestamp orderDate) {
        this.orderId = orderId;
        this.cusId = cusId;
        this.empPin = empPin;
        this.orderItems = orderItems;
        this.orderTotal = orderTotal;
        this.paymentType = paymentType;
        this.orderDate = orderDate;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getEmpPin() {
        return empPin;
    }

    public void setEmpPin(int empPin) {
        this.empPin = empPin;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    public int getCusId() {
        return cusId;
    }

    public void setCusId(int cusId) {
        this.cusId = cusId;
    }

    public BigDecimal getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(BigDecimal orderTotal) {
        this.orderTotal = orderTotal;
    }

    public String getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(String orderItems) {
        this.orderItems = orderItems;
    }
}
