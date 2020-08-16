package concurrency;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static com.thinkinjava.util.Print.*;

class BlockedMutex{

    private Lock lock = new ReentrantLock();
    public BlockedMutex(){
        lock.lock();
    }
    public void f(){
        try{
            lock.lockInterruptibly();
        }
        catch (InterruptedException e){
            println("Interrupted from lock acquisition in f()");
        }
    }
}

class Blocked2  implements Runnable{
    BlockedMutex blockedMutex = new BlockedMutex();

    @Override
    public void run() {
        println("Waiting for f() in BlockedMutex");
        blockedMutex.f();
        println("Broken out of blocked call");
    }
}

public class Interrupting2 {

    public static void main(String[] args) throws InterruptedException {

        Thread t = new Thread(new Blocked2());
        t.start();
        TimeUnit.SECONDS.sleep(1);
        println("Issuing t.interrupt()");
        t.interrupt();
    }

}
