package org.example.Order;

import java.time.LocalDate;

public class Order {
    private int orderId;
    private int customerId;
    private LocalDate orderDate;
    private int amount;

    public Order(int orderId, int customerId, LocalDate orderDate, int amount) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.orderDate = orderDate;
        this.amount = amount;
    }
    public Order( int customerId, LocalDate orderDate, int amount) {
        this(0,customerId,orderDate,amount);
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", customerId=" + customerId +
                ", orderDate=" + orderDate +
                ", amount=" + amount +
                '}';
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
