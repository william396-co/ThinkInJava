package containers;

import com.thinkinjava.util.Countries;

import java.util.*;
import static com.thinkinjava.util.Print.*;

public class SlowMap<K,V> extends AbstractMap<K,V> {

    private List<K> keys = new ArrayList<K>();
    private List<V> values = new ArrayList<V>();
    public V put(K key, V value)
    {
        V oldValue = get(key);
        if(!keys.contains(key)) {
            keys.add(key);
            values.add(value);
        }
        else
            values.set(keys.indexOf(key),value);
        return oldValue;
    }
    public V get(Object key)
    {
        if(!keys.contains(key))
            return null;
        return values.get(keys.indexOf(key));
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K,V>> set = new HashSet<Entry<K, V>>();
        Iterator<K> ki = keys.iterator();
        Iterator<V> vi = values.iterator();
        while(ki.hasNext())
            set.add(new MapEntry<K, V>(ki.next(),vi.next()));
        return set;
    }

    public static void main(String[] args) {
        SlowMap<String,String> m  = new SlowMap<String,String>();
        m.putAll(Countries.capitals(6));
        println(m);
        println(m.get("ALGENRIA"));
        println(m.entrySet());
    }
}
