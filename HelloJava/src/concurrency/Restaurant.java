package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static com.thinkinjava.util.Print.*;


class Meal{
    private final int orderNum;
    public Meal(int orderNum){this.orderNum =orderNum;}

    @Override
    public String toString() {
        return "Meal " + orderNum ;
    }
}

class WaitPerson implements Runnable{

    private Restaurant restaurant;
    public WaitPerson(Restaurant restaurant){this.restaurant = restaurant;}
    @Override
    public void run() {
        try{
            while (!Thread.interrupted()){
                synchronized (this){
                    while (restaurant.meal ==null)
                        wait();
                }
                println("Waitperson got " + restaurant.meal);
                synchronized (restaurant.chef){
                    restaurant.meal = null;
                    restaurant.chef.notifyAll();
                }
            }
        }catch (InterruptedException e){
            println("WaitPerson interrupted");
        }
    }
}

class Chef implements Runnable{
    private Restaurant restaurant;
    private int count = 0;
    public Chef(Restaurant restaurant){this.restaurant = restaurant;}
    @Override
    public void run() {

        try{
            while (!Thread.interrupted()){
                synchronized (this) {
                    while (restaurant.meal != null)
                        wait();
                }
                if(++count==10){
                    println("Out of food, closing");
                    restaurant.exec.shutdownNow();
                }
                print("Order up ");
                synchronized (restaurant.waitPerson){
                    restaurant.meal = new Meal(count);
                    restaurant.waitPerson.notifyAll();
                }
                TimeUnit.MILLISECONDS.sleep(100);
            }
        }catch (InterruptedException e){
            println("Chef interrupted");
        }
    }
}


public class Restaurant {
        Meal meal;
        ExecutorService exec = Executors.newCachedThreadPool();
        WaitPerson waitPerson = new WaitPerson(this);
        Chef chef = new Chef(this);
        public Restaurant(){
            exec.execute(chef);
            exec.execute(waitPerson);
        }

    public static void main(String[] args) {
        new Restaurant();
    }
}
