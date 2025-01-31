package creation_pattern.protype;

public class Main {
    public static void main(String[] args) {
        Rabbit rabbit = new Rabbit();
        rabbit.setOwner("Ankit");
        rabbit.setAge(8);
        Rabbit rabbitCopy = rabbit.clone();
        rabbitCopy.setAge(9);
        System.out.println("Age of first object "+ rabbit.getAge());
        System.out.println("Age of copy object "+ rabbitCopy.getAge());
        System.out.println("owner name object "+ rabbit.getOwner().getName());
        System.out.println("owner name copy object "+ rabbitCopy.getOwner().getName());

        rabbitCopy.getOwner().setName("Kumar");
        System.out.println("--owner name object "+ rabbit.getOwner().getName());
        System.out.println("--owner name copy object "+ rabbitCopy.getOwner().getName());

    }
}
