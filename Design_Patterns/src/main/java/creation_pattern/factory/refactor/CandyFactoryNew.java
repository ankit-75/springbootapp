package creation_pattern.factory.refactor;

import java.util.ArrayList;

public abstract class CandyFactoryNew {


    public  ArrayList getCandyPackage(int quantity, String type){
        Candy candy = getCandy(type);
        return candy.makeCandyPackage(quantity);
    }

    public abstract Candy getCandy(String type);
}
