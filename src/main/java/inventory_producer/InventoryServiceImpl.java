package inventory_producer;

import java.util.HashMap;
import java.util.Map;

class InventoryServiceImpl implements InventoryService {
    private Map<String, Integer> stock = new HashMap<>();

    //constructor to define the items in the stock
    public InventoryServiceImpl() {
        stock.put("Wireless Keyboard", 10);
        stock.put("Gaming Mouse", 5);
    }

    @Override
    public void checkStock(String item) {
        System.out.println("Stock for " + item + ": " + stock.getOrDefault(item, 0));
    }

    @Override
    public void updateStock(String item, int quantity) {
        stock.put(item, stock.getOrDefault(item, 0) + quantity);
        System.out.println("Updated stock for " + item + ": " + stock.get(item));
    }
}