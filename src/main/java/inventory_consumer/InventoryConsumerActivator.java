package inventory_consumer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import inventory_producer.InventoryService;

import java.util.Scanner;

public class InventoryConsumerActivator implements BundleActivator {
    public void start(BundleContext context) {

        ServiceReference<?> reference = context.getServiceReference(InventoryService.class.getName());

        if (reference != null) {

            InventoryService service = (InventoryService) context.getService(reference);

            //using the scanner class to get the use inputs
            Scanner scanner = new Scanner(System.in);

            //allow the user to enter the item ti check the if it is available
            System.out.println("Enter item to check stock: ");
            String item = scanner.nextLine();

            //invoke the check method by passing the user input(item)
            service.checkStock(item);
        }
    }
    public void stop(BundleContext context) {}
}
