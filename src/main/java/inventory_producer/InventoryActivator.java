package inventory_producer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class InventoryActivator implements BundleActivator {
    private ServiceRegistration<?> registration;
    private InventoryServiceImpl service;

    public void start(BundleContext context) {
        service = new InventoryServiceImpl();
        registration = context.registerService(InventoryService.class.getName(), service, null);
        System.out.println("Inventory Management Service Started");
    }

    public void stop(BundleContext context) {
        registration.unregister();
        System.out.println("Inventory Management Service Stopped");
    }
}