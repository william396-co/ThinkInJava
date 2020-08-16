package concurrency;


import static com.thinkinjava.util.Print.*;

class Sleeper extends Thread{
    private int duration;
    public Sleeper(String name,int sleepTime){
        super(name);
        duration = sleepTime;
        start();
    }

    @Override
    public void run() {
        try
        {
            sleep(duration);
        }catch (InterruptedException e){
            println(getName() +" was interrupted. " + " isInterrupted(): " + isInterrupted());
            return;
        }
        println(getName()+" has awakened");
    }
}

class Joiner extends Thread{
    private Sleeper sleeper;
    public Joiner(String name,Sleeper sleeper){
        super(name);
        this.sleeper = sleeper;
        start();
    }

    @Override
    public void run() {
        try{
            sleeper.join();
        }
        catch (InterruptedException e){
            println(getName()+" join completed");
        }
    }
}

public class Joining {

    public static void main(String[] args) {

        Sleeper sleeper = new Sleeper("Sleeper",1500),
                grumpy = new Sleeper("Grumpy",1500);
        Joiner dopey = new Joiner("Dopey",sleeper),
                doc = new Joiner("Doc",grumpy);
        grumpy.interrupt();
    }
}
