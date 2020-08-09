package generics;

import static com.thinkinjava.util.Print.*;


public class CountedObject {

    private static long counter = 0;
    private final long id = counter++;
    public long id(){return id;}
    public String toString(){return "CountedObject " + id;}
}
