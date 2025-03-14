package loyalty_producer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class LoyaltyActivator implements BundleActivator {
    private ServiceRegistration<?> registration;
    private LoyaltyServiceImpl service;

    public void start(BundleContext context) {

        // Register the LoyaltyService implementation as an OSGi service
        service = new LoyaltyServiceImpl();
        registration = context.registerService(LoyaltyService.class.getName(), service, null);
        System.out.println("Loyalty Service Started");
    }

    public void stop(BundleContext context) {

        // Unregister the service when stopping the bundle
        registration.unregister();
        System.out.println("Loyalty Service Stopped");
    }
}