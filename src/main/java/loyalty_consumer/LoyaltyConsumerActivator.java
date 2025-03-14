package loyalty_consumer;

import loyalty_producer.LoyaltyService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class LoyaltyConsumerActivator implements BundleActivator {
    public void start(BundleContext context) {

        // Retrieve the LoyaltyService reference
        ServiceReference<?> reference = context.getServiceReference(LoyaltyService.class.getName());
        if (reference != null) {
            LoyaltyService service = (LoyaltyService) context.getService(reference);
            LoyaltyConsumerImpl consumer = new LoyaltyConsumerImpl(service);
            consumer.run();
        }
    }
    public void stop(BundleContext context) {}
}