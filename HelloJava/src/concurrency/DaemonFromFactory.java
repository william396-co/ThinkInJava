package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static com.thinkinjava.util.Print.*;

public class DaemonFromFactory  implements Runnable{
    @Override
    public void run() {

        try
        {
            while (true){
                TimeUnit.MILLISECONDS.sleep(100);
                println(Thread.currentThread()+" " + this);
            }
        }
        catch (InterruptedException e)
        {
            println("Interrupted");
        }
    }

    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool(new DaemonThreadFactory());
        for(int i =0;i < 10;i++)
            exec.execute(new DaemonFromFactory());
        println("All daemons started");
        TimeUnit.MILLISECONDS.sleep(500);

    }
}
