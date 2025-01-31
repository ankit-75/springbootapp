package behaviour_pattern.mediator_pattern.rectify;

public class Mediator {
    Customer customer;
    EcommerceSite site;
    Driver driver;

    public Mediator() {
        customer = new Customer("Street 1 NYC");
        site = new EcommerceSite();
        driver = new Driver();

    }

    public void buy(String item, int quantity){
        if(site.checkInStocks(item, quantity)){
            site.sell(item, quantity);
            driver.deliver(item, quantity, customer);
        }

    }
}
