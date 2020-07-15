package Chapter11;

import java.util.Arrays;

import static com.thinkinjava.util.Print.*;

public class ArrayIsNotIterator {

    static <T> void test(Iterable<T> ib)
    {
        for(T t: ib)
            print(t+" ");
        println();
    }

    public static void main(String[] args) {
        test(Arrays.asList(1,2,3));
        String[] strings = {"A","B","C"};
       // test(strings); //you must explicitly convert it to an Iterator
        test(Arrays.asList(strings));
    }
}
