package containers;

import java.util.*;

import static com.thinkinjava.util.Print.*;

public class FailFast {
    public static void main(String[] args) {
        Collection<String> c = new ArrayList<String>();
        Iterator<String> it = c.iterator();
        c.add("An Object");
        try
        {
            String s = it.next();
        }
        catch (ConcurrentModificationException e)
        {
            println(e);
        }
    }
}
