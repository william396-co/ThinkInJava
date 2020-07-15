package Chapter11;

import sun.reflect.generics.tree.Tree;

import java.util.Random;
import java.util.SortedSet;
import java.util.TreeSet;

import static com.thinkinjava.util.Print.*;


public class SortedSetOfInteger {

    public static void main(String[] args)
    {
        Random rand = new Random(100);
        SortedSet<Integer> intset = new TreeSet<Integer>();
        for(int i =0; i < 10000; i++)
            intset.add(rand.nextInt(50));
        println(intset);
    }
}
