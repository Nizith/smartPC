package loyalty_consumer;

import loyalty_producer.LoyaltyService;
import java.util.Scanner;

class LoyaltyConsumerImpl {
    private LoyaltyService service;

    public LoyaltyConsumerImpl(LoyaltyService service) {
        this.service = service;
    }

    public void run() {

        // User input to check loyalty points
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter customer name: ");
        String customer = scanner.nextLine();
        System.out.println("Loyalty points for " + customer + ": " + service.getPoints(customer));
    }
}