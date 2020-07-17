package Chapter14;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.thinkinjava.util.Print.*;

class CountedInteger
{
    private Random rand = new Random(45);
    private static long counter;
    private final long id = counter++ * rand.nextInt(10);
    public String toString(){return Long.toString(id);}
}

public class FilledList<T> {
    private Class<T> type;
    public FilledList(Class<T> type){this.type = type;}
    public List<T> create(int nElements)
    {
        List<T> result = new ArrayList<T>();
        try
        {
            for(int i =0; i < nElements;i++)
                result.add(type.newInstance());
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
        return result;
    }

    public static void main(String[] args) {
        FilledList<CountedInteger> fl =
                new FilledList<CountedInteger>(CountedInteger.class);
        println(fl.create(15));
    }

}
