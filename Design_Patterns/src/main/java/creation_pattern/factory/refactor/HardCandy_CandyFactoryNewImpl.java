package creation_pattern.factory.refactor;

import java.util.ArrayList;

public class HardCandy_CandyFactoryNewImpl extends CandyFactoryNew {

    @Override
    public Candy getCandy(String type) {
        switch (type) {
            case "candycane":
                return new HardCandy_Candycane();
            case "lollipop":
                return new HardCandy_Lollipop();
            case "pepermint":
                return new HardCandy_Pepermint();
            default:
                return new HardCandy_Candycane();

        }
    }

    @Override
    public ArrayList getCandyPackage(int quantity, String type) {
        Candy candy = getCandy(type);
        if(quantity%10 != 0 ){
            System.out.println("Hard candy must be packeged in multiple of 10.");
            return null;
        }
        return candy.makeCandyPackage(quantity);
    }
}
