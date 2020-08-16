package concurrency;


import Enumerated.Input;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import static com.thinkinjava.util.Print.*;

class SleepBlocked implements Runnable{

    @Override
    public void run() {
        try{
            TimeUnit.SECONDS.sleep(100);
        }
        catch (InterruptedException e){
            println("InterruptedException");
        }
        println("Exiting SleepBlocked.run()");
    }
}

class IOBlocked implements Runnable{
    private InputStream in;
    public IOBlocked(InputStream in){this.in =in;}

    @Override
    public void run() {

        try{
            println("Waiting for read(): ");
            in.read();
        }catch (IOException e){
            if(Thread.currentThread().isInterrupted())
                println("Interrupted from blocked I/O");
            else
                throw new RuntimeException(e);
        }

        println("Exiting IOBlocked.run()");
    }
}

class SynchronizedBlocked implements Runnable{
    public synchronized void f(){
        while (true)
            Thread.yield();
    }
    public SynchronizedBlocked(){
        new Thread(){
            public void run(){

                f();
            }
        }.start();
    }
    @Override
    public void run() {
        println("Trying to call f()");
        f();
        println("Exiting SynchronizedBlocked.run()");
    }
}

public class Interrupting {

    private static ExecutorService exec =
            Executors.newCachedThreadPool();
    static void test(Runnable r) throws InterruptedException{
        Future<?> f = exec.submit(r);
        TimeUnit.MILLISECONDS.sleep(100);
        println("Interrupting " +r.getClass().getName());
        f.cancel(true);
        println("Interrupt send to  "+ r.getClass().getName());
    }

    public static void main(String[] args) throws Exception {
        test(new SleepBlocked());
        test(new IOBlocked(System.in));
        test(new SynchronizedBlocked());

        TimeUnit.SECONDS.sleep(3);
        println("Aborting with System.exit(0)");
        System.exit(0);
    }
}
