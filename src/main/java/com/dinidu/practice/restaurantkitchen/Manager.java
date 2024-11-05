package com.dinidu.practice.restaurantkitchen;

import java.util.Random;

public class Manager extends Thread {
    private final OrderQueue orderQueue;
    private final Random random = new Random();

    public Manager(OrderQueue orderQueue) {
        this.orderQueue = orderQueue;
    }

    @Override
    public void run() {
        try {
            int orderCount = 1;
            while (true) {
                Thread.sleep(random.nextInt(2000)+1000); // Simulate random sleep time
                Order order = new Order(orderCount++);
                orderQueue.addOrders(order);
                System.out.println("Manager added order " + order);
            }
        } catch (InterruptedException e) {
            System.out.println("Manager interrupted");
        }
    }
}
