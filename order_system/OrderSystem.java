import java.util.*;

public class OrderSystem {
    private PriorityQueue<Order> orderQueue;
    private Stack<Order> completedOrders;

    public OrderSystem() {
        orderQueue = new PriorityQueue<>();
        completedOrders = new Stack<>();
    }

    public void addOrder(Order order) {
        orderQueue.add(order);
        System.out.println("✅ Order " + order.getOrderId() + " added (" + order.getOrderType() + ")");
    }

    public void processNextOrder() {
        if (orderQueue.isEmpty()) {
            System.out.println("⚠️ No orders to process.");
            return;
        }

        Order next = orderQueue.poll();
        System.out.println("🚚 Processing order " + next.getOrderId() + " (" + next.getCustomerName() + ")...");
        try {
            Thread.sleep(1000); // Simulate processing
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        completedOrders.push(next);
        System.out.println("✅ Order " + next.getOrderId() + " completed.\n");
    }

    public void viewPendingOrders() {
        if (orderQueue.isEmpty()) {
            System.out.println("No pending orders.");
            return;
        }
        System.out.println("\n📦 Pending Orders:");
        for (Order o : orderQueue) {
            System.out.println(" - " + o);
        }
    }

    public void viewCompletedOrders() {
        if (completedOrders.isEmpty()) {
            System.out.println("No completed orders yet.");
            return;
        }
        System.out.println("\n✅ Completed Orders (most recent first):");
        for (int i = completedOrders.size() - 1; i >= 0; i--) {
            System.out.println(" - " + completedOrders.get(i));
        }
    }
}
