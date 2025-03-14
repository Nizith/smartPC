package support_consumer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import support_producer.SupportService;

public class SupportConsumerActivator implements BundleActivator {
    public void start(BundleContext context) {

        // Retrieve the SupportService reference
        ServiceReference<?> reference = context.getServiceReference(SupportService.class.getName());
        if (reference != null) {
            SupportService service = (SupportService) context.getService(reference);
            SupportConsumerImpl consumer = new SupportConsumerImpl(service);
            consumer.run();
        }
    }
    public void stop(BundleContext context) {}
}