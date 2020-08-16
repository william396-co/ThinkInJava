package concurrency;

import static com.thinkinjava.util.Print.*;
import java.util.ArrayList;
import java.util.concurrent.*;

class TaskWithResult implements Callable<String>
{
    private int id;
    public TaskWithResult(int id)
    {
        this.id = id;
    }
    public String call(){
        return "result of TaskWithResult " + id;
    }
}

public class CallableDemo {

    public static void main(String[] args) {

        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Future<String>> results =
                new ArrayList<Future<String>>();

        for(int i =0; i < 10;i++)
            results.add(exec.submit(new TaskWithResult(i)));

        for(Future<String> fs: results) {
            try {
                println(fs.get());
            }
            catch (InterruptedException e)
            {
                println(e);
                return;
            }
            catch (ExecutionException e)
            {
                println(e);
            }
            finally {
                exec.shutdown();
            }
        }
    }
}
