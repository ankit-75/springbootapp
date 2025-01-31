package creation_pattern.factory.refactor;


import java.util.ArrayList;

public class CandyStore {
    private static final CandyFactory candyFactory = new CandyFactory();
    private static final CandyFactoryNew chocolateFactory = new Chocolate_CandyFactoryNew();
    private static final CandyFactoryNew hardFactory = new HardCandy_CandyFactoryNewImpl();


    public static void main(String[] args) {
        candyFactory.getCandyPackage(12, "white", "chocolate");
        candyFactory.getCandyPackage(7, "dark", "chocolate");
        candyFactory.getCandyPackage(14, "lollipop", "hard candy");
        candyFactory.getCandyPackage(20, "pepermint", "hard candy");

        chocolateFactory.getCandyPackage(12, "white");
        chocolateFactory.getCandyPackage(7, "dark");
        hardFactory.getCandyPackage(14, "lollipop");
        hardFactory.getCandyPackage(20, "pepermint");

    }

}
