package Chapter11;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import static com.thinkinjava.util.Print.*;

public class SetOfInteger {

    public static void main(String[] args) {
        Random rand =new Random(100);
        Set<Integer> intset = new HashSet<Integer>();
        for(int i = 0; i < 10000;i++)
            intset.add(rand.nextInt(34));
        println(intset);
    }
}
