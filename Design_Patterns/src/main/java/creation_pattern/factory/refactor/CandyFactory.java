package creation_pattern.factory.refactor;

import java.util.ArrayList;

public class CandyFactory {


    public static ArrayList getCandyPackage(int quantity, String type, String section){
        Candy candy = getCandy(type);

        if(section.equals("hard candy")){
            if(quantity%10 != 0 ){
                System.out.println("Hard candy must be packeged in multiple of 10.");
                return null;
            }
        }
        return candy.makeCandyPackage(quantity);
    }

    public static Candy getCandy(String type){
        switch (type){
            case "milk": return new Chocolate_Milk();
            case "dark" : return new Chocolate_Dark();
            case "white" : return new Chocolate_White();
            case "candycane" : return new HardCandy_Candycane();
            case "lollipop" : return new HardCandy_Lollipop();
            case "pepermint" : return new HardCandy_Pepermint();
            default: return new Chocolate_Milk();
        }
    }
}
