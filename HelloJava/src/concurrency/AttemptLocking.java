package concurrency;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import static com.thinkinjava.util.Print.*;

public class AttemptLocking {

    private ReentrantLock lock = new ReentrantLock();
    public void untimed(){
        boolean captured = lock.tryLock();
        try
        {
            println("tryLock():" + captured);
        }finally {
            if(captured)
                lock.unlock();
        }
    }
    public void timed(){
        boolean captured = false;
        try{
            captured = lock.tryLock(2, TimeUnit.SECONDS);

        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
        try {
            println("tryLock(2,TimeUnit.SECONDS):" +captured);
        }
        finally {
            if(captured)
                lock.unlock();
        }
    }

    public static void main(String[] args) {

        final AttemptLocking al = new AttemptLocking();
        al.untimed();
        al.timed();
        new Thread(){
            {
            setDaemon(true);
        }
        public void run(){
            al.lock.lock();
            println("acquired");
        }
        }.start();
        Thread.yield();
        al.untimed();
        al.timed();
    }
}
