package containers;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.thinkinjava.util.Print.*;

class StringAddress
{
    private String str;
    public StringAddress(String str){this.str = str;}
    public String toString()
    {
        return super.toString() + " " + str;
    }
}

public class FillingLists {

    public static void main(String[] args) {
        List<StringAddress> list = new ArrayList<StringAddress>(
                Collections.nCopies(4,new StringAddress("Hello")));
        println(list);
        Collections.fill(list,new StringAddress("world"));
        println(list);
    }
}
