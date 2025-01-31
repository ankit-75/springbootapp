package behaviour_pattern.mediator_pattern;

public class Customer {
    String address;
    EcommerceSite site;

    public Customer(String address) {
        this.address = address;
        site = new EcommerceSite(this);
    }

    public void buy(String item, int quantity){
        if(site.checkInStocks(item, quantity)){
            site.sell(item, quantity);
        }

    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
