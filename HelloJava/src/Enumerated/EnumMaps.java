package Enumerated;

import java.util.EnumMap;
import java.util.Map;

import static com.thinkinjava.util.Print.*;

interface Command{void action();}

public class EnumMaps {
    public static void main(String[] args){

        EnumMap<AlarmPoints,Command> enumMap =
                new EnumMap<AlarmPoints,Command>(AlarmPoints.class);

        enumMap.put(AlarmPoints.KITCHEN, new Command() {
            @Override
            public void action() {
                println("kitchen fire！");
            }
        });
        enumMap.put(AlarmPoints.BATHROOM, new Command() {
            @Override
            public void action() {
                println("Bathroom alert!");
            }
        });
        for(Map.Entry<AlarmPoints,Command> e: enumMap.entrySet())
        {
            print(e.getKey()+": ");
            e.getValue().action();
        }

        try
        {
            enumMap.get(AlarmPoints.UTILITY).action();
        }
        catch (Exception e)
        {
            println(e);
        }


    }
}
