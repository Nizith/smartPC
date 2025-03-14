package support_producer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class SupportActivator implements BundleActivator {
    private ServiceRegistration<?> registration;

    public void start(BundleContext context) {

        // Register the SupportService implementation as an OSGi service
        registration = context.registerService(SupportService.class.getName(), new SupportServiceImpl(), null);
        System.out.println("Support Service Started");
    }

    public void stop(BundleContext context) {

        // Unregister the service when stopping the bundle
        registration.unregister();
        System.out.println("Support Service Stopped");
    }
}