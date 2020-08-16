package concurrency;

import static com.thinkinjava.util.Print.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class Pair{
    private int x,y;
    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
    public Pair(){this(0,0);}
    public int getX(){return x;}
    public  int getY(){return y;}
    public void incrementX(){x++;}
    public void incrementY(){y++;}

    @Override
    public String toString() {
        return "Pair{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
    public class PairValuesNotEqualException extends RuntimeException{
        public PairValuesNotEqualException(){
            super("Pair values not equal:" + Pair.this);
        }
    }
    public void checkState(){
        if(x!=y)
            throw new PairValuesNotEqualException();
    }
}

abstract class PairManager{
    AtomicInteger checkCounter = new AtomicInteger(0);
    protected Pair p = new Pair();
    private List<Pair> storage =
            Collections.synchronizedList(new ArrayList<Pair>());
    public synchronized Pair getPair(){
        return new Pair(p.getX(),p.getY());
    }

    protected void store(Pair p){
        storage.add(p);
        try {
            TimeUnit.MILLISECONDS.sleep(50);
        }catch (InterruptedException ignor){}
    }
    public abstract void increment();
}

class PairManager1 extends PairManager{

    @Override
    public void increment() {
        p.incrementX();
        p.incrementY();
        store(getPair());
    }
}

class PairManager2 extends PairManager{

    @Override
    public void increment() {
        Pair temp;
        synchronized (this){
            p.incrementY();
            p.incrementX();
            temp = getPair();
        }
        store(temp);
    }
}

class PairMainpulator implements Runnable{

    private PairManager pm;
    public PairMainpulator(PairManager pm){this.pm = pm;}


    @Override
    public void run() {
        while (true)
            pm.increment();
    }
    public String toString(){
        return "Pair: " + pm.getPair()+" checkCounter = " + pm.checkCounter.get();
    }
}

class PairChecker implements Runnable{

    private PairManager pm;
    public PairChecker(PairManager pm){this.pm = pm;}

    @Override
    public void run() {
        while (true){
            pm.checkCounter.incrementAndGet();
            pm.getPair().checkState();
        }
    }
}

public class CriticalSection {

    static void testApproaches(PairManager pman1,PairManager pman2){
        ExecutorService exec = Executors.newCachedThreadPool();
        PairMainpulator pm1 = new PairMainpulator(pman1),
                pm2 = new PairMainpulator(pman2);

        PairChecker pcheck1 = new PairChecker(pman1),
                pcheck2 = new PairChecker(pman2);
        exec.execute(pm1);
        exec.execute(pm2);
        exec.execute(pcheck1);
        exec.execute(pcheck2);
        try{
            TimeUnit.MILLISECONDS.sleep(500);
        }catch (InterruptedException e){
            println("Sleep interrupted");
        }
        println("pm1: "+ pm1 +"\npm2: " +pm2);
        System.exit(0);
    }

    public static void main(String[] args) {

        PairManager pm1 = new PairManager1(),
                pm2 = new PairManager2();

        testApproaches(pm1,pm2);

    }
}
