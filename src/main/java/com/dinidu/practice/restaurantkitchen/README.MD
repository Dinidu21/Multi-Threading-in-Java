## Problem Statement:

You are tasked with simulating a restaurant kitchen. The kitchen has multiple chefs working in parallel, preparing orders. Each chef takes an order, prepares it, and then serves it. There’s also a manager who takes new orders from customers and assigns them to chefs.

The goal is to simulate the workflow using threads:

    The chefs will be represented by separate threads, each processing orders.
    The orders will be represented as tasks that need to be handled.
    The manager will assign orders to the chefs when new ones arrive.
    You’ll need to coordinate the chefs so they don’t take the same order twice.

Detailed Steps:
### Step 1: Identify the Components

You’ll first break down the problem into different components that need to be handled by threads.

    Chefs (Threads): Each chef should be a thread that continuously waits for a new order and processes it.
    Order Queue (Shared Resource): There needs to be a common queue where orders are placed. Chefs will access this queue to pick up new orders. This will require synchronization to avoid race conditions (multiple chefs picking the same order at the same time).
    Manager (Thread): The manager thread simulates new orders arriving randomly. The manager adds orders to the queue.

### Step 2: Create the Chef Class

Each chef will be a separate thread. The chef will:

    Continuously check for new orders.
    Pick an order from the queue and prepare it.
    Serve the order and wait for the next one.

For thread synchronization, you’ll need to ensure that chefs do not pick the same order. You can use synchronized blocks or locks to manage access to the order queue.
### Step 3: Create the Order Queue

The Order Queue will be shared between all chef threads. It should allow:

    Adding orders: The manager adds new orders.
    Removing orders: Each chef picks and removes an order from the queue.

To manage this queue, you’ll need to:

    Use thread-safe access methods (like synchronized or ReentrantLock) to ensure that only one chef picks an order at a time.
    When no orders are available, chefs should wait until the manager adds a new order. This will involve using wait() and notifyAll() for thread communication.

### Step 4: Create the Manager Class

The manager will be a separate thread. It will:

    Add new orders to the queue periodically.
    After adding an order, it should notify all the chefs that a new order is available.

The manager will simulate real-world behavior by randomly generating new orders and placing them in the queue.
### Step 5: Coordinate Chefs and Manager

    When chefs find that the order queue is empty, they should call wait(). This will put them in a waiting state until they are notified by the manager that an order has been added.
    The manager, after placing a new order, should call notifyAll() to wake up all the waiting chefs.

### Step 6: Implement Thread Safety

You’ll need to ensure that access to the shared order queue is thread-safe. This can be done using:

    Synchronized blocks: Use synchronized to ensure that only one thread can add or remove an order at a time.
    Locks: Alternatively, you can use more advanced locking mechanisms like ReentrantLock if you want more fine-grained control.

### Step 7: Simulate Random Events

To make the simulation more realistic:

    Orders should arrive at random intervals, so the manager thread should sleep for random amounts of time between generating orders.
    Chefs can have varying preparation times for each order, so their threads should also sleep for random periods to simulate the cooking process.

### Step 8: Graceful Shutdown

Since this simulation involves continuous threads, think about how you would gracefully stop the simulation. You could add a mechanism to stop all threads after a certain number of orders have been processed or after a fixed period.
Key Thread Concepts You’ll Practice:

    Thread Creation: For both chefs and the manager.
    Synchronization: Managing access to the shared order queue using synchronized blocks or locks.
    Thread Communication: Using wait() and notifyAll() for chefs to wait for new orders and be notified by the manager.
    Thread Lifecycle: Keeping threads alive, making them wait, and gracefully shutting them down.

This problem will give you hands-on practice with multi-threading concepts in a real-world scenario!

## Key Concepts Practiced:

    Thread Creation: The chefs and manager are represented as separate threads.
    Synchronization: Access to the shared OrderQueue is synchronized to prevent race conditions.
    Thread Communication: Chefs wait for new orders (wait()), and the manager notifies them when new orders are available (notifyAll()).
    Simulated Random Events: The manager adds orders at random intervals, and the chefs simulate the time taken to prepare orders.