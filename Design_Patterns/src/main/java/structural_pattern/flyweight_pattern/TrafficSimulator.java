package structural_pattern.flyweight_pattern;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TrafficSimulator {
    static ArrayList<Vehicle> vehicles = new ArrayList<>();
    public static void main(String[] args) {
        Runnable createVehical = () -> creteRandomCar();
        Runnable removeVehical = () -> remove();

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
        executorService.scheduleAtFixedRate(createVehical, 0, 3, TimeUnit.SECONDS);
        executorService.scheduleAtFixedRate(removeVehical, 5, 5, TimeUnit.SECONDS);

    }

    public static void creteRandomCar(){
        Random random = new Random();
        int randInt =  random.nextInt(2);
        Vehicle vehicle = null;
        if(randInt == 0){
            vehicle = new Car();
        }else if(randInt == 1){
            vehicle = new Truck();
        }
        vehicle.setLocation(random.nextInt(1000), random.nextInt(1000));
        System.out.println("Creating vehical"+ vehicle +"  type: "+vehicle.getType()+" location: "+vehicle.getLocation()[0] + " " + vehicle.getLocation()[1]);
        vehicles.add(vehicle);
    }

    public static void remove(){
        System.out.println("removing vehical "+vehicles.get(0));
        vehicles.remove(0);
    }
}
