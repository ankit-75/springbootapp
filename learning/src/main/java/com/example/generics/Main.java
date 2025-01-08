package com.example.generics;


import java.util.*;

interface InterfaceA<A>{
    void add(A a);
    void print();
}
public class Main {
    public static void main(String[] args) {
        List<?> ls = new ArrayList<String>();
//        ls.add("A");
//        ls.add(new Object());
//        ls.get();

        Canvas canvas = new Canvas();
        List<Shape> shapes = new ArrayList<>();
        Circle circle = new Circle();
        shapes.add(circle);
        Rectangle rectangle = new Rectangle();
        shapes.add(rectangle);

        canvas.drawAll(shapes);

        List<Circle> circles = new ArrayList<>();
        circles.add(circle);
        canvas.drawAll(circles);


        Map<String, List<? extends Object>> map = new HashMap<>();
        List<String> stringList = new ArrayList<>();
        List<Object> objectList = new ArrayList<>();
        map.put("A", stringList);
        map.put("B", objectList);

        Integer [] ia = new Integer[]{1,2};
        Float [] fa = new Float[]{1.1f, 1.2f};
        Number [] na = new Number[]{1,2};

        Collection<Number> coll = new ArrayList<>();
        canvas.genericarrayToCollection(ia, coll);
        canvas.genericarrayToCollection(fa, coll);
        canvas.genericarrayToCollection(na, coll);
    }

}



 abstract class Shape {
    public abstract void draw(Canvas c);
}

 class Circle extends Shape {
    private int x, y, radius;
    public void draw(Canvas c) {
        System.out.println("draw Circle");
    }
}

 class Rectangle extends Shape {
    private int x, y, width, height;
    public void draw(Canvas c) {
        System.out.println("draw Rectangle");
    }
}

 class Canvas {
    public void draw(Shape s) {
        s.draw(this);
    }

     public void drawAll(List<? extends Shape> shapes) {
       // shapes.add(new Rectangle()); Compile Time Error
         for (Shape s: shapes) {
             s.draw(this);
         }
     }

     public void arrayToCollection(Object []a, Collection<Object> col) {
         for (Object s: a) {
            col.add(s);
         }
     }

     public <T> void genericarrayToCollection(T []a, Collection<T> col) {
         for (T s: a) {
             col.add(s);
         }
     }
}