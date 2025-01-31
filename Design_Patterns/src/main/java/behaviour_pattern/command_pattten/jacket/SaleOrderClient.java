package behaviour_pattern.command_pattten.jacket;

public class SaleOrderClient {

    public static Jacket jacket = new Jacket();
    public static void main(String[] args) {
        OrderHandler placeOrderHandler = new OrderHandler();
        OrderHandler requtnOrderHandler = new OrderHandler();



        placeOrderHandler.invoke(new PlaceOrderCommand(jacket));
        requtnOrderHandler.invoke(new ReturnOrderCommand(jacket));

    }
}
