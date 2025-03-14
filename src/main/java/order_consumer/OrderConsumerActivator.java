package order_consumer;

import inventory_producer.InventoryService; // Import InventoryService
import loyalty_producer.LoyaltyService;
import order_producer.OrderService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class OrderConsumerActivator implements BundleActivator {
    public void start(BundleContext context) {

        // Get reference for OrderService
        ServiceReference<?> orderRef = context.getServiceReference(OrderService.class.getName());
        ServiceReference<?> inventoryRef = context.getServiceReference(InventoryService.class.getName()); // Get InventoryService
        ServiceReference<?> loyaltyRef = context.getServiceReference(LoyaltyService.class.getName()); // Get LoyaltyService

        if (orderRef != null && inventoryRef != null && loyaltyRef != null) {
            OrderService orderService = (OrderService) context.getService(orderRef);
            InventoryService inventoryService = (InventoryService) context.getService(inventoryRef);
            LoyaltyService loyaltyService = (LoyaltyService) context.getService(loyaltyRef);

            OrderConsumerImpl consumer = new OrderConsumerImpl(orderService, inventoryService, loyaltyService);
            consumer.run();
        }
    }

    public void stop(BundleContext context) {}
}