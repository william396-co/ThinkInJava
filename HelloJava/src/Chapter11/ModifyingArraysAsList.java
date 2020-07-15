package Chapter11;


import java.lang.reflect.Array;
import java.util.*;

import static com.thinkinjava.util.Print.*;

public class ModifyingArraysAsList {

    public static void main(String[] args) {
        Random rand = new Random(24);
        Integer[] ia = {1,2,3,4,5,6,7,8,9,10};
        List<Integer> list1 =
                new ArrayList<Integer>(Arrays.asList(ia));
        println("Before shuffling:"+list1);

        Collections.shuffle(list1,rand);
        println("After shuffling:"+list1);

        println("array:"+ Arrays.toString(ia));

        List<Integer> list2 = Arrays.asList(ia);
        println("Before shuffling:"+list2);
        Collections.shuffle(list2,rand);
        println("After shuffling:"+list2);
        println("array:"+Arrays.toString(ia));
    }
}
