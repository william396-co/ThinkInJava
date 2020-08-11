package containers;

import sun.reflect.generics.tree.Tree;

import java.util.*;

import static com.thinkinjava.util.Print.*;

public class Synchronization {
    public static void main(String[] args) {
        Collection<String> c =
                Collections.synchronizedCollection(new ArrayList<String>());

        List<String> list = Collections.synchronizedList(new ArrayList<String>());
        Set<String> s = Collections.synchronizedSet(new HashSet<String>());

        SortedSet<String> ss = Collections.synchronizedSortedSet(new TreeSet<String>());
        Map<String,String> sm = Collections.synchronizedSortedMap(new TreeMap<String, String>());
    }
}
