package Chapter11;


import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static com.thinkinjava.util.Print.*;

public class Statistics {

    public static void main(String[]args)
    {
        Random rand = new Random(45);
        Map<Integer, Integer> m  = new HashMap<Integer,Integer>();
        for(int i =0;i < 10000;i++)
        {
            int r = rand.nextInt(20);
            Integer freq = m.get(r);
            m.put(r,freq==null?1:freq+1);
        }
        println(m);
    }
}
