package creation_pattern.factory;

import java.util.ArrayList;

public class HardCandy extends Candy {
    @Override
    ArrayList<Candy> makeCandyPackage(int quantity) {
        ArrayList hardCandyPackage = new ArrayList<>();
        for (int i=0; i< quantity; i++){
            hardCandyPackage.add(new HardCandy());
        }
        System.out.println("one package of "+quantity+"  hardcandy has been made!");
        return hardCandyPackage;
    }
}
