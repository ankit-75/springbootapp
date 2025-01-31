package behaviour_pattern.mediator_pattern.rectify;

import java.util.HashMap;

public class EcommerceSite {

    HashMap<String, Integer> stock;

    public EcommerceSite() {
        stock = new HashMap<>();
        stock.put("pen", 100);
        stock.put("pencils", 100);
        stock.put("paper", 200);
    }

    public boolean checkInStocks(String item, int quantity) {
        if(stock.containsKey(item) && stock.get(item) > quantity){
            return true;
        }
        return false;
    }

    public void sell(String item, int quantity) {
        int newQuantity = stock.get(item) - quantity;
        stock.put(item, newQuantity);
    }
}
