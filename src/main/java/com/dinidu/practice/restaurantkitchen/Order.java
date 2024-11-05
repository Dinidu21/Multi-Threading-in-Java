package com.dinidu.practice.restaurantkitchen;

public class Order {
    private final int ORDER_ID;

    public Order(int orderId) {
        this.ORDER_ID = orderId;
    }

    public int getOrderId() {
        return ORDER_ID;
    }

    public String toString() {
        return "Order #" + ORDER_ID;
    }
}
