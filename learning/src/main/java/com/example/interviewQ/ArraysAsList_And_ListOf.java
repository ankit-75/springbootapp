package com.example.interviewQ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ArraysAsList_And_ListOf {
    public static void main(String[] args) {
       // ArrayList
        String []strings = {"Name1", "Name2", "Name3", "Name4", "Name5"};


        // Fix the code start
        List<String> listString = Arrays.asList("Name1", "Name2", "Name3", "Name4", "Name5");
        for (String s: listString){
           // listString.remove(2); //UnsupportedOperationEx
        }
        // fix the code end

        //solution start
        List<String> listStringSol = new ArrayList<>(Arrays.asList("Name1", "Name2", "Name3", "Name4", "Name5"));
       // listStringSol.remove(2); // This works


        // ConsurrentModificationEx
//        for (String s: listStringSol){
//            listStringSol.remove(2);
//        }

        //This Works
        Iterator<String> itr1 =  listStringSol.iterator();
        int i = 0;
        while (itr1.hasNext()){
            itr1.next();
            if(i >= 2)
                itr1.remove();
            i++;
        }
        System.out.println("Removed "+ listStringSol);
        //solution end






        // Arrays return fixed size of list (AbstractList)
        List<String> listString2 = Arrays.asList(strings);
        System.out.println(listString2);
        strings[0] = ("Name6");
        listString2.set(1, "Name7");
        //listString2.add("NANME8");   //UnsupportedOperationEx
        //listString2.remove(0);       //UnsupportedOperationEx

        System.out.println(listString2);



        //strings[4] = null;            // NullPointerEx
        // crete immutable List(null not supported)
        List<String> immutableList =  List.of(strings);
        //immutableList.set(0, "UPDATE1");    //UnsupportedOperationEx
        System.out.println(immutableList);

    }
}
