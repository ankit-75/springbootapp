package creation_pattern.singleton;

public class PrintSpooler {
    private static final PrintSpooler printSpooler = new PrintSpooler();;
    private static boolean initialized = false;

    private PrintSpooler(){}
     public void init(){

     }

//     public static PrintSpooler getInstance(){
//        if(initialized) return printSpooler;
//        System.out.println("First Time..");
//        printSpooler = new PrintSpooler();
//        printSpooler.init();
//        initialized = true;
//        return printSpooler;
//     }

     public static synchronized PrintSpooler getInstance(){
        if(initialized) return printSpooler;
        System.out.println("First Time..");

        printSpooler.init();
        initialized = true;
        return printSpooler;
     }
}
