package creation_pattern.factory.refactor;

public class Chocolate_CandyFactoryNew extends CandyFactoryNew {
    @Override
    public Candy getCandy(String type) {
        switch (type) {
            case "milk":
                return new Chocolate_Milk();
            case "dark":
                return new Chocolate_Dark();
            case "white":
                return new Chocolate_White();
            default:  return new Chocolate_Milk();
        }
    }
}
