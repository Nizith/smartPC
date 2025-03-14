package inventory_producer;

public interface InventoryService {

    //check whether the item is available on the stock or not
    void checkStock(String item);

    //update the stock after a consumer buys an item
    void updateStock(String item, int quantity);
}