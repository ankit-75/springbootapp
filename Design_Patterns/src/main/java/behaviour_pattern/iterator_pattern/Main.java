package behaviour_pattern.iterator_pattern;

public class Main {
    public static void main(String[] args) {
        Item pens = new Item("pen", 100);
        Item pencils = new Item("pencils", 0);
        Item paper = new Item("paper", 180);

        Inventory inventory = new Inventory(pens, pencils, paper);
        StockIterator stockIterator = inventory.iterator();

        while(stockIterator.hasNext()){
            Item item = stockIterator.next();
            System.out.println(item.getName());
        }

    }
}
