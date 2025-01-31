package creation_pattern.factory;

import java.util.ArrayList;

public class Chocolate extends Candy {
    @Override
    ArrayList<Candy> makeCandyPackage(int quantity) {
        ArrayList chocolatePAckage = new ArrayList<>();
        for (int i=0; i< quantity; i++){
            chocolatePAckage.add(new Chocolate());
        }
        System.out.println("one package of "+quantity+"  chocolate has been made!");
        return chocolatePAckage;
    }
}
