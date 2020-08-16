package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

import static com.thinkinjava.util.Print.*;

class ExceptionThread2 implements Runnable {

    @Override
    public void run() {
        Thread t = Thread.currentThread();
        println("run()  by" + t);
        println("eh = " + t.getUncaughtExceptionHandler());
        throw new RuntimeException();
    }
}

class MyUncaughtExceptionHandle implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        println("caught " + e);
    }
}

class HandlerThreadFactory implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r) {
        println(this + " creating new thread");
        Thread t = new Thread(r);
        println("created " + t);
        t.setUncaughtExceptionHandler(new MyUncaughtExceptionHandle());
        println("eh = " + t.getUncaughtExceptionHandler());
        return t;
    }
}

public class CaptureUncaughtException {

    public static void main(String[] args) {

        ExecutorService exec = Executors.newCachedThreadPool(
                new HandlerThreadFactory());
        exec.execute(new ExceptionThread2());

    }
}
