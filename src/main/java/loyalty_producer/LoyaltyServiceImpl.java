package loyalty_producer;

import java.util.HashMap;
import java.util.Map;

class LoyaltyServiceImpl implements LoyaltyService {
    private Map<String, Integer> customerPoints = new HashMap<>();

    public void addPoints(String customer, int points) {

        // Add points to the customer's account
        customerPoints.put(customer, customerPoints.getOrDefault(customer, 0) + points);
        System.out.println("Added " + points + " points to " + customer);
    }

    @Override
    public int getPoints(String customer) {

        // Retrieve the customer's total points
        return customerPoints.getOrDefault(customer, 0);
    }
}