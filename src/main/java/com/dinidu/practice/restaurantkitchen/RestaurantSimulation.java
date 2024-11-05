package com.dinidu.practice.restaurantkitchen;

public class RestaurantSimulation  {
    public static void main(String[] args) {
        OrderQueue orderQueue = new OrderQueue(); // Create a shared order queue
        Manager manager = new Manager(orderQueue); // Create a manager thread
        manager.start(); // Start the manager thread

        Chef chef1 = new Chef(" Bob", orderQueue); // Create a chef thread
        Chef chef2 = new Chef(" Alice", orderQueue); // Create a chef thread
        chef1.start(); // Start the first chef thread
        chef2.start(); // Start the second chef thread
    }
}
