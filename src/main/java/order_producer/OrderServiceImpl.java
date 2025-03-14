package order_producer;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

class OrderServiceImpl implements OrderService {
    private Map<String, String> orders = new HashMap<>();

    public void placeOrder(String item, int quantity) {
        String orderId = UUID.randomUUID().toString();
        orders.put(orderId, "Item: " + item + ", Quantity: " + quantity);
        System.out.println("Order placed. Order ID: " + orderId);
    }
}