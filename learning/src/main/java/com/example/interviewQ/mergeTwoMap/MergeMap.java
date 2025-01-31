package com.example.interviewQ.mergeTwoMap;

//https://javaconceptoftheday.com/java-8-merge-two-maps-with-same-keys/
import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MergeMap {
    public static void main(String[] args) {

        System.out.println(Runtime.getRuntime().availableProcessors() );
        HashMap<String, Integer> map1 = new HashMap<>();

        map1.put("Maths", 45);
        map1.put("Physics", 57);
        map1.put("Chemistry", 52);
        map1.put("History", 41);

        //Map-2

        HashMap<String, Integer> map2 = new HashMap<>();

        map2.put("Economics", 49);
        map2.put("Maths", 42);
        map2.put("Biology", 41);
        map2.put("History", 55);

        map2.merge("Economics", 1, (v1, v2) -> {
            System.out.println(" v1 "+ v1+ " v2 "+v2);
            return v1+v2;
        });
        System.out.println(map2);

        HashMap<String, Integer> map3 = new HashMap<>(map1);
        map2.forEach((key, val) ->  map3.merge(key, val,  (v1, v2) -> {
            System.out.println("Key "+key +" val "+ val +" v1 "+ v1+ " v2 "+v2);
            return v1+v2;
        }    )   );

        System.out.println(map3);



        //merge hashmap using stream
       HashMap<String, Integer> res =  Stream.concat(map1.entrySet().stream(), map2.entrySet().stream())
               .parallel()
                .collect(Collectors.toMap (Map.Entry::getKey, Map.Entry::getValue,  (v1, v2) -> v1+v2 , HashMap::new   ));

        System.out.println(res);


        System.out.println(map1);
        Map<String, Integer> sortedStudentMap
                = map1.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
                .collect(Collectors.toMap(ky -> ky.getKey(), vl -> vl.getValue(), (e1, e2) -> e1, LinkedHashMap::new));

        System.out.println(sortedStudentMap);

          List<String> l1 = Arrays.asList("1", "2", "3", "4","1");
//        List<String> l2 = Arrays.asList("AA", "BB", "CC", "DD");
//        Stream.concat(l1.stream(), l2.stream()).forEach(System.out::println);

           Map<String, Long> result =   l1.stream().collect(Collectors.groupingBy(Function.identity(),  Collectors.counting() ));
        System.out.println(result);


    }
}
