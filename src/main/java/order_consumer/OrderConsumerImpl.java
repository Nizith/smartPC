package order_consumer;

import inventory_producer.InventoryService;
import loyalty_producer.LoyaltyService;
import order_producer.OrderService;

import java.util.Scanner;

class OrderConsumerImpl {
    private OrderService orderService;
    private InventoryService inventoryService;
    private LoyaltyService loyaltyService;

    public OrderConsumerImpl(OrderService orderService, InventoryService inventoryService, LoyaltyService loyaltyService) {
        this.orderService = orderService;
        this.inventoryService = inventoryService;
        this.loyaltyService = loyaltyService;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter customer name: ");
        String customer = scanner.nextLine();

        System.out.println("Enter item to order: ");
        String item = scanner.nextLine();

        System.out.println("Enter quantity: ");
        int quantity = scanner.nextInt();

        // Place the order
        orderService.placeOrder(item, quantity);

        // Deduct stock from inventory
        inventoryService.updateStock(item, -quantity);
        System.out.println("Stock updated after order placement.");

        // Add loyalty points for the customer (Assuming 10 points per item)
        int pointsEarned = quantity * 10;
        loyaltyService.addPoints(customer, pointsEarned);
        System.out.println("Loyalty points added for " + customer + ": " + pointsEarned);
    }
}