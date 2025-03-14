package inventory_consumer;

import inventory_producer.InventoryService;
import java.util.Scanner;

class InventoryConsumerImpl {
    private InventoryService service;

    public InventoryConsumerImpl(InventoryService service) {
        this.service = service;
    }

    public void run() {

        //using the scanner class to get the use inputs
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter item to check stock: ");
        String item = scanner.nextLine();

        service.checkStock(item);
    }
}