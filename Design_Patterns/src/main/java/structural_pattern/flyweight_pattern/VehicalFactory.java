package structural_pattern.flyweight_pattern;

import java.util.HashMap;

public class VehicalFactory {
    HashMap<Integer, Vehicle> map = new HashMap<>();

    Vehicle getVehical(int type){
        if(map.containsKey(type)){
            return map.get(type);
        }else{
            Vehicle vehicle = null;
            if(type == 0){
                vehicle = new Car();
            }else if(type == 1){
                vehicle = new Truck();
            }
            map.put(type, vehicle);
            return vehicle;
        }


    }
}
