package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.thinkinjava.util.Print.*;


public class SettingDefaultHandler {

    public static void main(String[] args) {

        Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandle());
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new ExceptionThread());
    }
}
