package creation_pattern.factory.refactor;


import java.util.ArrayList;

public class HardCandy_Lollipop extends Candy {
    @Override
    ArrayList<Candy> makeCandyPackage(int quantity) {
        ArrayList hardCandyPackage = new ArrayList<>();
        for (int i=0; i< quantity; i++){
            hardCandyPackage.add(new HardCandy_Lollipop());
        }
        System.out.println(quantity+"  package of 10 candy lollypop has been made!");
        return hardCandyPackage;
    }
}
