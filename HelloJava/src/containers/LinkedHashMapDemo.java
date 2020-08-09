package containers;

import com.thinkinjava.util.CountingMapData;

import java.util.LinkedHashMap;

import static com.thinkinjava.util.Print.*;

public class LinkedHashMapDemo {
    public static void main(String[] args) {
        LinkedHashMap<Integer,String> linkedHashMap=
                new LinkedHashMap<Integer, String>(new CountingMapData(9));

        println(linkedHashMap);

        linkedHashMap = new LinkedHashMap<Integer, String>(16,0.75f,true);
        println(linkedHashMap);

        linkedHashMap.putAll(new CountingMapData(9));
        println(linkedHashMap);
        for(int i =0; i < 6; i++)
            linkedHashMap.get(i);
        println(linkedHashMap);
        linkedHashMap.get(0);
        println(linkedHashMap);
    }
}
