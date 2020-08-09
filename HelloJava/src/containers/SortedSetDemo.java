package containers;


import java.util.Collections;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

import static com.thinkinjava.util.Print.*;

public class SortedSetDemo {

    public static void main(String[] args) {
        SortedSet<String> sortedSet = new TreeSet<String>();
        Collections.addAll(sortedSet,"one two three four five six seven eight".split(" "));
        println(sortedSet);

        String low = sortedSet.first();
        String high = sortedSet.last();
        println(low);
        println(high);

        Iterator<String> it = sortedSet.iterator();
        for(int i =0; i <= 6;i++)
        {
            if(i==3)
                low = it.next();
            else if(i == 6)
                high = it.next();
            else
                it.next();
        }

        println(low);
        println(high);
    }
}
