package concurrency;

import static com.thinkinjava.util.Print.*;

public class BasicThreads {

    public static void main(String[] args) {

        Thread t = new Thread(new LiftOff());
        t.start();
        println("waiting for lift off");
      //  println("====");
    }
}
