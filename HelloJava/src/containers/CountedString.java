package containers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.thinkinjava.util.Print.*;

public class CountedString {

    private static List<String> created =
            new ArrayList<String>();
    private String s;
    private int id = 0;

    public CountedString(String string) {
        s = string;
        created.add(s);
        for (String str : created)
            if (str.equals(s))
                id++;
    }

    public String toString() {
        return "String: " + s + " id: " + id + " hashCode(): " + hashCode();
    }

    public int hashCode() {
        int result = 17;
        result = 37 * result + s.hashCode();
        result = 37 * result + id;
        return result;
    }

    public boolean equals(Object o) {
        return o instanceof CountedString &&
                s.equals(((CountedString) o).s) && id == ((CountedString) o).id;
    }

    public static void main(String[] args) {
        Map<CountedString, Integer> map
                = new HashMap<CountedString, Integer>();
        CountedString[] cs = new CountedString[5];
        for (int i = 0; i < cs.length; i++) {
            cs[i] = new CountedString("hi");
            map.put(cs[i], i);
        }
        println(map);

        for (CountedString str : cs) {
            print("Looking up " + str);
            println(map.get(str));
        }
    }
}
