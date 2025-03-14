package order_producer;

public interface OrderService {

    //place the order according to the item and the quantity given
    void placeOrder(String item, int quantity);
}