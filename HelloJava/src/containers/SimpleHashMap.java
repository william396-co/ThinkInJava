package containers;

import com.thinkinjava.util.Countries;
import static com.thinkinjava.util.Print.*;

import java.util.*;

/**
 *  基本的hash方式  数组+链表(buckets+linked list)
 * @param <K>
 * @param <V>
 */

public class SimpleHashMap<K,V> extends AbstractMap<K,V> {

    static final int SIZE = 997;
    LinkedList<MapEntry<K,V>>[] buckets =
            new LinkedList[SIZE];
    public V put(K key, V value)
    {
        V oldValue = null;
        int index = Math.abs(key.hashCode()) % SIZE;
        if (buckets[index] == null)
            buckets[index] = new LinkedList<MapEntry<K, V>>();
        LinkedList<MapEntry<K, V>> bucket = buckets[index];
        MapEntry<K, V> pair = new MapEntry<K, V>(key, value);
        boolean found = false;
        ListIterator<MapEntry<K, V>> it = bucket.listIterator();
        while (it.hasNext()) {
            MapEntry<K, V> ipair = it.next();
            if (ipair.getValue().equals(key)) {
                oldValue = ipair.getValue();
                it.set(pair);
                found = true;
                break;
            }
        }

        if (!found)
            buckets[index].add(pair);
        return oldValue;
    }

    public V get(Object key)
    {
        int index = Math.abs(key.hashCode()) % SIZE;
        if(buckets[index]==null)
            return null;
        for(MapEntry<K,V> ipair: buckets[index])
        {
            if(ipair.getKey().equals(key))
                return ipair.getValue();
        }
        return null;
    }
    @Override
    public Set<Entry<K, V>> entrySet() {

        Set<Map.Entry<K,V>> set= new HashSet<Entry<K, V>>();
        for(LinkedList<MapEntry<K,V>> bucket: buckets)
        {
            if(bucket==null)
                continue;
            for(MapEntry<K,V> mpair: bucket)
                set.add(mpair);
        }
        return set;
    }

    public static void main(String[] args) {
        SimpleHashMap<String,String> m =
                new SimpleHashMap<String, String>();
        m.putAll(Countries.capitals());
        println(m);
        println(m.get("CONGO"));
        println(m.entrySet());
    }
}
