package Chapter11;

import java.util.*;

import static com.thinkinjava.util.Print.*;

public class PrintingContainers {

    static Collection fill(Collection<String>collection)
    {
        collection.add("rat");
        collection.add("cat");
        collection.add("dog");
        collection.add("cow");
        collection.add("dog");
        return collection;
    }

    static Map fill(Map<String,String> map)
    {
        map.put("rat","Fuzzy");
        map.put("cat","Rags");
        map.put("dog","Bosco");
        map.put("dog","spot");
        return map;
    }

    public static void main(String[] args) {
        println(fill(new ArrayList<String>()));
        println(fill(new LinkedList<String>()));
        println(fill(new HashSet<String>()));
        println(fill(new TreeSet<String>()));
        println(fill(new LinkedHashSet<String>()));
        println("===================================");
        println(fill(new HashMap<String, String>()));
        println(fill(new TreeMap<String, String>()));
        println(fill(new LinkedHashMap<String, String>()));
    }
}
