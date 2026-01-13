public class Order implements Comparable<Order> {
    private int orderId;
    private String customerName;
    private String orderType; // "PRIME" or "NORMAL"
    private String[] items;
    private long timestamp;

    public Order(int orderId, String customerName, String orderType, String[] items) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.orderType = orderType;
        this.items = items;
        this.timestamp = System.currentTimeMillis();
    }

    public String getOrderType() {
        return orderType;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    @Override
    public int compareTo(Order other) {
        if (this.orderType.equals(other.orderType)) {
            return Long.compare(this.timestamp, other.timestamp); // FIFO
        }
        return this.orderType.equals("PRIME") ? -1 : 1; // PRIME before NORMAL
    }

    @Override
    public String toString() {
        return orderId + " | " + customerName + " | " + orderType;
    }
}
