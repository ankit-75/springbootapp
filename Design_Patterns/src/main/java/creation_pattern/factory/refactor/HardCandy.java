package creation_pattern.factory.refactor;


import java.util.ArrayList;

public class HardCandy extends Candy {
    @Override
    ArrayList<Candy> makeCandyPackage(int quantity) {
        ArrayList hardCandyPackage = new ArrayList<>();
        for (int i=0; i< quantity; i++){
            hardCandyPackage.add(new HardCandy());
        }
        System.out.println(quantity+"  package of 10 candy has been made!");
        return hardCandyPackage;
    }
}
