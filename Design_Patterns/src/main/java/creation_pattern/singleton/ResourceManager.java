package creation_pattern.singleton;

import java.util.Collections;
import java.util.List;

public class ResourceManager {
    public static void main(String[] args) {

        Thread t1 = new Thread() { PrintSpooler p1 = PrintSpooler.getInstance(); };
//        Thread t2 = new Thread() { PrintSpooler p2 = PrintSpooler.getInstance(); };
//        Thread t3 = new Thread() { PrintSpooler p2 = PrintSpooler.getInstance(); };
//        Thread t4 = new Thread() { PrintSpooler p2 = PrintSpooler.getInstance(); };
        t1.start();
//        t2.start();
//        t3.start();
//        t4.start();

        PrintSpooler printSpooler = PrintSpooler.getInstance();
        List<PrintSpooler> list =   Collections.singletonList(printSpooler);
        //list.add(PrintSpooler.getInstance());
    }
}
