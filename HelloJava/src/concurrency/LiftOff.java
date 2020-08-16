package concurrency;

import static com.thinkinjava.util.Print.*;

public class LiftOff implements Runnable {

    protected int coutDown = 10;
    private static int taskCount =0;
    private final int id = taskCount++;

    public LiftOff(){}
    public LiftOff(int coutDown)
    {
        this.coutDown = coutDown;
    }

    public String status(){
        return "#" + id +"(" + (coutDown >0? coutDown:"LiftOff!") + ",) ";
    }

    @Override
    public void run() {

        while (coutDown-->0)
        {
            print(status());
            Thread.yield();
        }
    }
}
