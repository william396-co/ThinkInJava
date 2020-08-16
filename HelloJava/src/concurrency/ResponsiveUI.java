package concurrency;

import java.io.IOException;

import static com.thinkinjava.util.Print.*;

class UnresponsiveUI{
    private volatile double d = 1;
    public UnresponsiveUI() throws Exception{
        while (d > 0)
            d +=(Math.PI + Math.E);
        System.in.read();
    }
}


public class ResponsiveUI extends Thread {
    private static volatile double d  = 1;
    public ResponsiveUI(){
        setDaemon(true);
        start();
    }

    public void run(){
        while (true)
            d +=(Math.PI+Math.E)/d;
    }

    public static void main(String[] args) throws IOException {

        new ResponsiveUI();
        System.in.read();
        println(d);
    }

}
