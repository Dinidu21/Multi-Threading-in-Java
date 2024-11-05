package com.dinidu.practice.restaurantkitchen;

public class Chef extends Thread{
    private final String CHEF_NAME;
    private final OrderQueue orderQueue;
    public Chef(String chefName, OrderQueue orderQueue) {
        this.CHEF_NAME = chefName;
        this.orderQueue = orderQueue;
    }
    @Override
    public void run() {
        try{
            while (true){
                Order order = orderQueue.takeOrder();
                System.out.println("Chef " + CHEF_NAME + " is preparing " + order);
                Thread.sleep(2000); // Simulate cooking time
                System.out.println("Chef " + CHEF_NAME + " finished cooking " + order);
            }
        }catch (InterruptedException e) {
            System.out.println("Chef " + CHEF_NAME + " interrupted");
        }
    }
}
