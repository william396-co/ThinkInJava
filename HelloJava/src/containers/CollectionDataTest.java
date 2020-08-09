package containers;

import com.thinkinjava.util.CollectionData;
import com.thinkinjava.util.Generator;

import java.util.LinkedHashSet;
import java.util.Set;

import static com.thinkinjava.util.Print.*;

class Government implements Generator<String>
{
    String[] foundation = ("Strange woman lying in ponds " +
            "distributing swords is not basis for a system of  " +
            "government").split(" ");
    private int index;
    public String next(){return foundation[index++];}
}

public class CollectionDataTest {

    public static void main(String[] args) {
        Set<String> set= new LinkedHashSet<String>(
                new CollectionData<String>(new Government(),15)
        );
        set.addAll(CollectionData.list(new Government(),15));
        println(set);

    }
}
