package containers;

import com.thinkinjava.util.Countries;

import java.util.*;
import java.util.List;

import static com.thinkinjava.util.Print.*;


public class ReadOnly {

    static Collection<String> data =
            new ArrayList<String>(Countries.names(6));

    public static void main(String[] args) {
        Collection<String> c=
                Collections.unmodifiableCollection(new ArrayList<String>(data));
        println(c);

        List<String> a =
                Collections.unmodifiableList(new ArrayList<String>(data));
        println(a);

        Set<String> s =
                Collections.unmodifiableSet(new HashSet<String>(data));
        println(s);

        Set<String> ss =
                Collections.unmodifiableSortedSet(new TreeSet<String>(data));
        println(ss);

        Map<String,String> m =
                Collections.unmodifiableMap(new HashMap<String,String>(Countries.capitals(6)));
        println(m);

        Map<String,String> sm =
                Collections.unmodifiableSortedMap(new TreeMap<String,String>(Countries.capitals(5)));
        println(sm);

    }
}
