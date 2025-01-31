package creation_pattern.factory;

import java.util.ArrayList;

public class CandyFactory {


    public static ArrayList getCandyPackage(int quantity, String type){
        Candy candy = getCandy(type);
        return candy.makeCandyPackage(quantity);
    }

    public static Candy getCandy(String type){
        switch (type){
            case "hard candy": return new HardCandy();
            case "chocolate" : return new Chocolate();
            default: return null;
        }
    }
}
