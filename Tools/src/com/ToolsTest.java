package com;


import java.util.*;

class Demo {
    public static void MapRemoveKey(
    Map<String,String> map, String key)

    {

        Iterator iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            String key2 = (String) iterator.next();
            if(key.equals(key2)) {
                map.remove(key2);
                break;
            }
        }
    }
}
public class ToolsTest {

    public static void main(String[] args) {
        Map<String,String> test = new HashMap<>();
        test.put("hello","1");
        test.put("world","2");

        System.out.println(test);

        Demo.MapRemoveKey(test,"hello");
        System.out.println(test);
    }
}
