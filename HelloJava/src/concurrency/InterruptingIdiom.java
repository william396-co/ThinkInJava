package concurrency;

import java.util.concurrent.TimeUnit;

import static com.thinkinjava.util.Print.*;

class NeedsCleanup{
    private final int id;
    public NeedsCleanup(int ident){
        id = ident;
        println("NeedsCleanup " +id);
    }
    public void cleanup(){
        println("Cleaning up " + id);
    }
}

class Blocked3 implements Runnable{

    private volatile double d  = 0.0;


    @Override
    public void run() {

        try
        {
            while (!Thread.interrupted()){

                NeedsCleanup n1 = new NeedsCleanup(1);
                try{
                    println("Sleeping");
                    TimeUnit.SECONDS.sleep(1);
                    NeedsCleanup n2 = new NeedsCleanup(2);
                    try
                    {
                        println("Calculating");
                        for(int i=0;i < 2500000;i++)
                            d += (Math.PI + Math.E)/d;
                        println("Finished time-consuming operation");
                    }
                    finally {
                        n2.cleanup();
                    }
                }finally {
                    n1.cleanup();
                }
            }
            println("Exiting via while() test");
        }catch (InterruptedException e){
            println("Exiting via InterruptedException");
        }

    }
}

public class InterruptingIdiom {

    public static void main(String[] args) throws InterruptedException {
        if(args.length != 1)
        {
            println("Usage: java InterruptingIdiom delay-in-ms");
            System.exit(1);
        }
        Thread t = new Thread(new Blocked3());
        t.start();
        TimeUnit.MILLISECONDS.sleep(new Integer(args[0]));
        t.interrupt();
    }
}
