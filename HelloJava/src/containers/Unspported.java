package containers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static com.thinkinjava.util.Print.*;

public class Unspported {

    static void test(String msg, List<String> list)
    {
        println("======================================");
        Collection<String> c = list;
        Collection<String> sublist = list.subList(1,8);
        Collection<String> c2 = new ArrayList<String>(sublist);
        try
        {
            c.retainAll(c2);
        }catch (Exception e)
        {
            println("retainAll():" + e);
        }

    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("A B C D E F G H I J K L M N".split(" "));
        test("Modified Copy", new ArrayList<String>(list));
        test("Arrays.asList()", list);
    }
}
