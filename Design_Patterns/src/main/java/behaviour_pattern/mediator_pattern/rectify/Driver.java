package behaviour_pattern.mediator_pattern.rectify;


public class Driver {


    public void deliver(String item, int quantity, Customer customer) {
        System.out.println(quantity+ " "+ item+ " out of delivery to "+ customer.getAddress());
    }
}
