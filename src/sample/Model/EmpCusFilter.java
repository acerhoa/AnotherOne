package sample.Model;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class EmpCusFilter {
    private int orderId;
    private String customer;
    private String employee;
    private String orderItems;
    private BigDecimal orderTotal;
    private String paymentType;
    private Timestamp orderDate;

    public EmpCusFilter() {
    }

    public EmpCusFilter(int orderId, String customer, String employee, String orderItems, BigDecimal orderTotal, String paymentType, Timestamp orderDate) {
        this.orderId = orderId;
        this.customer = customer;
        this.employee = employee;
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

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public String getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(String orderItems) {
        this.orderItems = orderItems;
    }

    public BigDecimal getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(BigDecimal orderTotal) {
        this.orderTotal = orderTotal;
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

    public Integer toInteger(){
        return orderId;
    }
}
