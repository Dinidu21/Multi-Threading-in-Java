package com.dinidu.practice.restaurantkitchen;

import java.util.LinkedList;
import java.util.Queue;

public class OrderQueue {
    private final Queue<Order> orders = new LinkedList<>();

    public synchronized void addOrders(Order order) {
        orders.add(order);
        System.out.println(order + "   added to queue");
        notifyAll(); //Notify chefs that a new order is available
    }

    public synchronized Order takeOrder() throws InterruptedException {
        while (orders.isEmpty()) {
            wait(); // Wait until an order is added
            System.out.println("Waiting for order...");
        }
        System.out.println("Order taken from queue");
        return orders.poll(); // Remove and return the next order
    }

}
