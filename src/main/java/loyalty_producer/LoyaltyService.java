package loyalty_producer;

public interface LoyaltyService {

    //add points to a specific consumer based ont the orders
    void addPoints(String customer, int points);

    //retrieve the points for a specific consumers
    int getPoints(String customer);
}