package generics;

import java.util.ArrayList;
import java.util.List;

import static com.thinkinjava.util.Print.*;

public class GenericVarags {
    public static <T> List<T> makeList(T...args)
    {
        List<T> result = new ArrayList<T>();
        for(T item: args)
            result.add(item);
        return result;
    }

    public static void main(String[] args) {
        List<String> ls = makeList("A");
        println(ls);

        ls = makeList("A","B","C");
        println(ls);

        ls = makeList("ABCDEFGHIJKLMNOPQRSTUVWXYZ".split(""));
        println(ls);

    }
}
