package support_consumer;

import support_producer.SupportService;
import java.util.Scanner;

class SupportConsumerImpl {
    private SupportService service;

    public SupportConsumerImpl(SupportService service) {
        this.service = service;
    }

    public void run() {

        // User input to request customer support
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter issue: ");
        String issue = scanner.nextLine();

        service.provideSupport(issue);
    }
}
