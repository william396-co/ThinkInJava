package concurrency;

import java.util.concurrent.TimeUnit;

import static com.thinkinjava.util.Print.*;

class Daemon implements Runnable {
    private Thread[] t= new Thread[10];

    @Override
    public void run() {
        for(int i =0; i < t.length;i++){
            t[i] = new Thread(new DaemonSpawn());
            t[i].start();
            print("DaemonSpawn  " +i+" started,");
        }
        for(int i =0;i <t.length;i++)
            print("t[" +i+"].isDaemon()= " + t[i].isDaemon() + ", ");

        while (true)
            Thread.yield();
    }
}

class DaemonSpawn implements Runnable{

    @Override
    public void run() {
        while (true)
            Thread.yield();
    }
}


public class Daemons
{
    public static void main(String[] args) throws Exception {
        Thread d = new Thread(new Daemon());
        d.setDaemon(true);
        d.start();
        print("d.isDaemon() = " + d.isDaemon() +", ");
        TimeUnit.MILLISECONDS.sleep(1);
    }

}