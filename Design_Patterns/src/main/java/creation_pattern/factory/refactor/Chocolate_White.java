package creation_pattern.factory.refactor;



import java.util.ArrayList;

public class Chocolate_White extends Candy {
    @Override
    ArrayList<Candy> makeCandyPackage(int quantity) {
        ArrayList chocolatePAckage = new ArrayList<>();
        for (int i=0; i< quantity; i++){
            chocolatePAckage.add(new Chocolate_White());
        }
        System.out.println("one package of "+quantity+"  white chocolate has been made!");
        return chocolatePAckage;
    }
}
