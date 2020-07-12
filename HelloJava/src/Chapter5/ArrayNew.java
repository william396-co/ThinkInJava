package Chapter5;//package must first no-comment line

import java.util.Arrays;
import java.util.Random;
import static com.thinkinjava.util.Print.*;

public class ArrayNew {

    public static void main(String[] args) {
        int[] a;
        Random rand = new Random(46);
        a = new int[rand.nextInt(12)];
        println("length of a = " + a.length);
        for(int i =0; i < a.length;i++)
            a[i] = rand.nextInt(100);
        println(Arrays.toString(a));
    }
}
