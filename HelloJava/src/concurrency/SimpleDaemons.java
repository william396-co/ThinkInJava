package concurrency;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import static com.thinkinjava.util.Print.*;

public class SimpleDaemons  implements Runnable{


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
            print("sleep() interrupted");
        }
    }

    public static void main(String[] args) throws Exception {
        for(int i=0;i < 10;i++){
            Thread daemon = new Thread(new SimpleDaemons());
            daemon.start();
        }
        println("All daemons started");
        TimeUnit.MILLISECONDS.sleep(175);
    }
}
