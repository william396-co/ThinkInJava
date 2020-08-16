package concurrency;

import java.util.concurrent.TimeUnit;

import static com.thinkinjava.util.Print.*;

class ADaemon implements Runnable{

    @Override
    public void run() {

        try
        {
            println("Starting ADaemon");
            TimeUnit.SECONDS.sleep(1);
        }
        catch (InterruptedException e)
        {
            println("Exiting via InterruptedException");
        }
        finally {
            println("This should always run?");
        }

    }
}

public class DaemonsDontRunFinally {
    public static void main(String[] args) {

        Thread t = new Thread(new ADaemon());
        t.setDaemon(true);
        t.start();
    }

}
