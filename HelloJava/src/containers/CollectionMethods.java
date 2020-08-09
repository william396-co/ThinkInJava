package containers;

import com.thinkinjava.util.Countries;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static com.thinkinjava.util.Print.*;

public class CollectionMethods {

    public static void main(String[] args) {
        Collection<String> c = new ArrayList<String>();

        c.addAll(Countries.names(6));
        c.add("ten");
        c.add("eleven");

        Object[] array = c.toArray();
        String[] str = c.toArray(new String[0]);
        println("Collection.max(c)= " + Collections.max(c));
        println("Collection.min(c)= " + Collections.min(c));
        println(c);
    }
}
