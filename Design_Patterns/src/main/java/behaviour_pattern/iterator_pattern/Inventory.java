package behaviour_pattern.iterator_pattern;

public class Inventory implements Iterable{
    Item []items;

    public Inventory(Item ... items){
        this.items = items;
    }

    Item[] getItems(){
        return items;
    }

    @Override
    public StockIterator iterator() {
        return new StockIterator(this);
    }
}
