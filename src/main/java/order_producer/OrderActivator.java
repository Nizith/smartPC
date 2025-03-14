package order_producer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class OrderActivator implements BundleActivator {
    private ServiceRegistration<?> registration;
    private OrderServiceImpl service;

    public void start(BundleContext context) {
        service = new OrderServiceImpl();
        registration = context.registerService(OrderService.class.getName(), service, null);
        System.out.println("Order Management Service Started");
    }

    public void stop(BundleContext context) {
        registration.unregister();
        System.out.println("Order Management Service Stopped");
    }
}