package concurrency.waxomatic;

import org.omg.CORBA.INTERNAL;
import org.omg.CORBA.TIMEOUT;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static com.thinkinjava.util.Print.*;

class Car{
    private boolean waxOn = false;
    public synchronized void waxed(){
        waxOn = true;
        notifyAll();
    }
    public synchronized void buffed(){
        waxOn = false;
        notifyAll();
    }
    public synchronized void waitForWaxing() throws InterruptedException{
        while (!waxOn)
            wait();
    }
    public synchronized void waitForBuffing() throws InterruptedException{
        while (!waxOn)
            wait();
    }
}

class WaxOn implements Runnable{
    private Car car;
    public WaxOn(Car car){this.car = car;}

    @Override
    public void run() {

        try{
            while (!Thread.interrupted())
            {
                print("Wax On!");
                TimeUnit.MILLISECONDS.sleep(200);
                car.waxed();
                car.waitForBuffing();
            }
        }catch (InterruptedException e){
            println("Exiting via interrupting");
        }
        println("Ending Wax On task");
    }
}

class WaxOff implements Runnable{

    private Car car;
    public WaxOff(Car car){this.car = car;}
    @Override
    public void run() {

        try{
            while (!Thread.interrupted()){
                car.waitForBuffing();
                print("Wax off! ");
                TimeUnit.MILLISECONDS.sleep(200);
                car.buffed();
            }
        }catch (InterruptedException e){
            println("Exiting via interrupt");
        }
        println("Ending Wax Off task");
    }
}

public class WaxOMatic {

    public static void main(String[] args) throws InterruptedException {

        Car car = new Car();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new WaxOff(car));
        exec.execute(new WaxOn(car));
        TimeUnit.SECONDS.sleep(5);
        exec.shutdown();
    }
}
