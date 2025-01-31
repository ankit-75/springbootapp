package creation_pattern.factory;

import java.util.ArrayList;

public class CandyStore {
    public static void main(String[] args) {
        CandyFactory candyFactory = new CandyFactory();
    }

    // Move this code to factoryclass
    public static ArrayList getCandyPackage(int quantity, String type){
        Candy candy = getCandy(type);
        return candy.makeCandyPackage(quantity);
    }

    // Move this code to factoryclass
    public static Candy getCandy(String type){
        switch (type){
            case "hard candy": return new HardCandy();
            case "chocolate" : return new Chocolate();
            default: return null;
        }
    }
}
